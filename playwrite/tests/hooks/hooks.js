import { Before, After, BeforeAll, AfterAll, AfterStep } from '@cucumber/cucumber';
import { chromium, firefox, webkit } from '@playwright/test';
import config from '../../playwright.config.js';

let browser;
let projectConfig;

BeforeAll({ timeout: 20000 }, async function () {
    const browserName = process.env.BROWSER || 'chromium';
    
    // 💡 Aquí capturamos la variable limpia que configuramos en el package.json
    // Si viene en "true" o no viene (undefined), por defecto será true.
    const esHeadless = process.env.HEADLESS !== 'false';

    projectConfig = config.projects.find(p => p.name === browserName.toLowerCase()) 
                    || config.projects[0];

    console.log(`Iniciando suite en el proyecto: ${projectConfig.name.toUpperCase()} (Headless: ${esHeadless})`);

    const opcionesLanzamiento = {
        ...config.browserOptions,
        headless: esHeadless
    };

    switch (projectConfig.name) {
        case 'firefox':
            browser = await firefox.launch(opcionesLanzamiento);
            break;
        case 'webkit':
            browser = await webkit.launch(opcionesLanzamiento);
            break;
        case 'chromium':
        default:
            browser = await chromium.launch(opcionesLanzamiento);
            break;
    }
});

Before({ timeout: 20000 }, async function () {
    this.context = await browser.newContext({
        ...projectConfig.use
    });
    
    this.page = await this.context.newPage();
});

AfterStep(async function () {
    if (this.page) {
        const screenshot = await this.page.screenshot({ type: 'png' });
        this.attach(screenshot, 'image/png');
    }
});

After({ timeout: 20000 }, async function () {
    if (this.page) await this.page.close();
    if (this.context) await this.context.close();
});

AfterAll({ timeout: 20000 }, async function () {
    if (browser) await browser.close();
});