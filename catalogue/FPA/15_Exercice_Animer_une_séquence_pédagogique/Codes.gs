const FORM_ID = "1DmEbk9VJlJ6HDHHnhSEdipxudWtAAxp3KeZpNHgHPjo";
const SPREADSHEET_URL = "https://docs.google.com/spreadsheets/d/1qv_4HN-MM6OhRG0W1m7RFJ8Ryu0Ob1DapjwSIiBk9k4/edit?usp=drive_link";
const ERROR_QUESTIONS_MSG = "Erreur lors du chargement des questions du formulaire : ";
const ERROR_EVALUATION_MSG = "Erreur lors du chargement de l'évaluation : ";

/*=================================================================================*/
const onSubmit = () => Logger.log("Cycle de vie de la Form: A la soumission du QCM");


/*=================================================================================*/
const onStartUp = () => EvaluationManager
  .matchError(EvaluationManager
    .Maybe.of(EvaluationManager.loadEvaluation(FORM_ID, SPREADSHEET_URL)))
  .onNothing(() => Logger.log("L'évaluation n'a pas été correctement initialisée."))
  .onJust((evaluation) => {
    EvaluationManager.saveEvaluation(evaluation);
    EvaluationManager.loadFormQuestions(evaluation);
    EvaluationManager.getQuestions(evaluation).forEach((q) => Logger.log(q));
  });


/*=================================================================================*/
const EvaluationManager = {

  /*=================================================================================*/
  Maybe: {
    of: (value) => ({
      value,
      map: (fn) => (value ? EvaluationManager.Maybe.of(fn(value)) : EvaluationManager.Maybe.of(null)),
      flatMap: (fn) => (value ? fn(value) : EvaluationManager.Maybe.of(null)),
      isNothing: () => value === null || value === undefined,
      getOrElse: (defaultValue) => (EvaluationManager.Maybe.of(value).isNothing() ? defaultValue : value),
    }),
  },

  /*=================================================================================*/
  matchError: (maybeEvaluation) => ({
    onNothing: (fn) => (maybeEvaluation.isNothing() ? fn() : EvaluationManager
      .matchError(maybeEvaluation)),
    onJust: (fn) => (maybeEvaluation.isNothing() ? EvaluationManager
      .matchError(maybeEvaluation) : fn(maybeEvaluation.value)),
  }),

  /*=================================================================================*/
  getQuestions: (evaluation) => evaluation
    .sheetData
    .slice(1)
    .map((exercice) => exercice[0]),

  /*=================================================================================*/
  getExistingTitles: (form) => new Set(form
    .getItems()
    .map(item => item.getTitle())
  ),

  /*=================================================================================*/
  loadFormQuestions: (evaluation) => {
    try {
      const existingTitles = EvaluationManager.getExistingTitles(evaluation.form);
      evaluation.sheetData.slice(1).map(([question, propositions]) => ({
        question,
        propositions: Array.from(JSON.parse(`[${propositions}]`))
          .map(prop => prop.trim()),
      })).forEach(({ question, propositions }) => {
        if (!existingTitles.has(question)) {
          EvaluationManager.addQuestionToForm(
            evaluation.form,
            question,
            propositions);
          existingTitles.add(question);
        }
      });
    } catch (error) {
      throw new Error(`${ERROR_QUESTIONS_MSG}${error.message}`);
    }
  },

  /*=================================================================================*/
  loadEvaluation: (id, url) => {
    try {
      const sheetId = EvaluationManager.getSheetIdFromUrl(url);
      return {
        form: FormApp.openById(id),
        sheetId,
        sheetData:SpreadsheetApp
        .openById(sheetId)
        .getActiveSheet()
        .getDataRange()
        .getValues(),
      };
    } catch (error) {
      throw new Error(`${ERROR_EVALUATION_MSG}${error.message}`);
    }
  },

  /*=================================================================================*/
  getEvaluation: () => {
    const evaluationString = PropertiesService.getScriptProperties().getProperty("evaluation");
    return evaluationString ? JSON.parse(evaluationString) : null;
  },

  /*=================================================================================*/
  saveEvaluation: (evaluation) => {
    PropertiesService.getScriptProperties().setProperty("evaluation", JSON.stringify(evaluation));
    return evaluation;
  },

  /*=================================================================================*/
  addQuestionToForm: (form, question, propositions) => {
    form
      .addMultipleChoiceItem()
      .setTitle(question)
      .setChoiceValues(propositions)
      .setPoints(1)
      .setRequired(true);
  },

  /*=================================================================================*/
  getSheetIdFromUrl: (url) => {
    const matches = url.match(/\/d\/([a-zA-Z0-9-_]+)/);
    return matches && matches[1] ? matches[1] : null;
  },
};