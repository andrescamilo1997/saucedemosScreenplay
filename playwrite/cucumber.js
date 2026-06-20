export default {
  default: {
    parallel: 1,
    format: [
      'summary',
      'json:reports/cucumber_report.json',
      'html:reports/cucumber-report.html' // 🚀 ¡ESTA LÍNEA HACE TODO EL TRABAJO!
    ],
    paths: ['tests/features/**/*.feature'],
    import: ['tests/step-definitions/**/*.js', 'tests/support/**/*.js'] // Ajusta según tus rutas de hooks
  }
};