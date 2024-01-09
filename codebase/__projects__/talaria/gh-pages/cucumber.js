const config = {
    paths: ['tests-bdd/acceptance/features/**/*.feature'],
    require: ['tests-bdd/acceptance/step_definitions/**/*.ts'],
    requireModule: ['ts-node/register'],
    format: [
      'summary',
      'progress-bar',
    ],
    formatOptions: { snippetInterface: 'async-await' },
    publishQuiet: true,
  };

module.exports = {
   default: config
}
