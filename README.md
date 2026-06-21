# saucedemo

Serenity BDD automation project using the Screenplay pattern.

## Project Structure

```
proyecto
├── src
│   ├── main
│   │   └── java
│   │       └── com/saucedemo/saucedemo
│   │           ├── enums/             # Enumeraciones para valores constantes
│   │           ├── exceptions/        # Excepciones personalizadas
│   │           ├── integrations/      # Integraciones con APIs externas
│   │           ├── interactions/      # Interacciones específicas
│   │           ├── models/            # Objetos de negocio y DTOs
│   │           ├── questions/         # Consultas para verificar estados
│   │           ├── tasks/             # Tareas de alto nivel
│   │           ├── userinterfaces/    # Mapeo de elementos UI
│   │           └── utils/             # Utilidades comunes
│   └── test
│       ├── java
│       │   └── com/saucedemo/saucedemo
│       │       ├── runners/           # Ejecución de escenarios
│       │       └── stepdefinitions/   # Implementación de pasos Gherkin
│       └── resources
│           ├── features/             # Escenarios en Gherkin
│           ├── setdatos/             # Archivos de datos externos
│           └── serenity.conf         # Configuración de Serenity
│
├── target/                           # Archivos generados
├── .gitignore                        # Archivos ignorados por Git
├── sonar-project.properties          # Configuración SonarQube
├── serenity.properties               # Propiedades de Serenity
├── CI/   
│    └── azure-pipeline-template.yaml # Pipeline de Azure DevOps
├── build.gradle                      # Configuración de Gradle
├── playwrite                         # proyecto automatizado de PW con reporte y escenarios
└── evidenciasjenkins                 #Evidencias de ejecución y muestra de reportes ejecutados desde jenkins
```

## Configuration

- **Base Package**: `com.saucedemo.saucedemo`
- **Base URL**: `https://saucedemo.com`
- **Build Tool**: Gradle

## Running Tests

### Gradle

```bash
# Run all tests
gradle clean test

# Generate aggregated report
gradle clean test aggregate
```
## View Reports

After running tests, open the Serenity report:

```bash
open build/reports/serenity/index.html
```

## Playwrite
```bash
cd playwrite
npm ci
npx playwright install chromium
npm test
```

