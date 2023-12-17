// Définition du type Result
class Result {
  constructor(value) {
    this.value = value;
  }

  // Méthode map pour le functor
  map(fn) {
    return this.value ? new Result(fn(this.value)) : this;
  }

  // Pattern matching pour obtenir la valeur ou une valeur par défaut
  match({ Ok, Err }) {
    return this.value ? Ok(this.value) : Err("Erreur de résultat");
  }
}

// Fonction utilitaire pour créer un Result à partir d'une expression
const resultify = (expression) => {
  try {
    const value = expression();
    return new Result(value);
  } catch (error) {
    return new Result(null);
  }
};

// Fonction pour obtenir l'ID de la feuille de calcul depuis l'URL
const getSheetIdFromUrl = (url) => {
  const matches = url.match(/\/d\/([a-zA-Z0-9-_]+)/);
  return matches && matches[1] ? matches[1] : null;
};

// Fonction pour récupérer les données de la feuille de calcul
const getSheetData = (url) => {
  const sheetId = getSheetIdFromUrl(url);
  const sheet = SpreadsheetApp.openById(sheetId).getActiveSheet();
  const range = sheet.getDataRange();
  return range.getValues();
};

// Fonction pour initialiser et récupérer l'évaluation
const initializeAndRetrieveEvaluation = (questionsCsv) => {
  return resultify(() => {
    const sheetId = getSheetIdFromUrl(questionsCsv);
    const sheetData = getSheetData(questionsCsv);

    const evaluation = {
      questions_csv: questionsCsv,
      sheetId,
      sheetData,
    };

    PropertiesService.getScriptProperties().setProperty("evaluation", JSON.stringify(evaluation));

    return evaluation;
  });
};

// Fonction pour démarrer le formulaire
const onStartUp = () => {
  const questionsCsv = "https://docs.google.com/spreadsheets/d/1qv_4HN-MM6OhRG0W1m7RFJ8Ryu0Ob1DapjwSIiBk9k4/edit?usp=drive_link";

  // Utilisation de Result pour gérer le succès ou l'échec de l'initialisation
  const evaluationResult = initializeAndRetrieveEvaluation(questionsCsv);

  evaluationResult.match({
    Ok: (evaluation) => Logger.log(evaluation.sheetData),
    Err: (error) => Logger.log(`Erreur lors de l'initialisation : ${error}`),
  });
};

// Fonction appelée à la soumission du formulaire
const onSubmit = () => {
  Logger.log("Cycle de vie de la Form: A la soumission du QCM");
};


