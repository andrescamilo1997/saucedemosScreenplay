pipeline {
    agent any

    stages {

        stage('QA Automation - Screenplay') {
            steps {
                echo 'Iniciando pruebas de Serenity Screenplay...'
                bat 'gradlew clean build test aggregate'
            }

            post {
                always {
                    publishHTML([
                        allowMissing: false,
                        alwaysLinkToLastBuild: true,
                        keepAll: true,
                        reportDir: 'target/site/serenity',
                        reportFiles: 'index.html',
                        reportName: 'Reporte Serenity Visual'
                    ])
                }
            }
        }

        stage('QA Automation - Playwright') {
            steps {
                echo 'Ejecutando Playwright + Cucumber...'

                bat '''
                    cd playwrite
                    npm ci
                    npx playwright install chromium
                    npm test
                '''
            }

            post {
                always {

                    // Publica reporte HTML de Cucumber directamente
                    publishHTML([
                        allowMissing: true,
                        alwaysLinkToLastBuild: true,
                        keepAll: true,
                        reportDir: 'playwrite/reports',
                        reportFiles: 'cucumber-report.html',
                        reportName: 'Reporte Cucumber Playwright'
                    ])

                    // Guarda TODOS los reportes como artefactos (sin comprimir)
                    archiveArtifacts artifacts: 'playwrite/reports/**', allowEmptyArchive: true
                }
            }
        }
    }
}