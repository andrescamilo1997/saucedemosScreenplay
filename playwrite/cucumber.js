// cucumber.js
export default {
  paths: ['tests/features/**/*.feature'],
  import: [
    'tests/step-definitions/**/*.js',
    'tests/hooks/**/*.js'
  ],
  format: [
    'summary',
    'html:reports/cucumber-report.html'
  ]
};