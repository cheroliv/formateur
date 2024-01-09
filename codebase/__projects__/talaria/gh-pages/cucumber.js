const config = {
    paths: ['tests-behaviors/acceptance/features/**/*.feature'],
    require: ['tests-behaviors/acceptance/step_definitions/**/*.ts'],
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
