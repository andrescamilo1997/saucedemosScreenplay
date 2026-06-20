// @ts-check
import { devices } from '@playwright/test';

/**
 * Configuración adaptada para uso con Cucumber JS.
 * Las opciones aquí definidas serán consumidas por los Hooks para levantar los navegadores.
 */
const config = {
  // Opciones de lanzamiento globales para los navegadores
  browserOptions: {
    headless: process.env.CI ? true : false, // Headless en CI/CD, con interfaz localmente
    slowMo: 0,                               // Puedes subirlo a 50 si quieres ralentizar las acciones para verlas
    args: ['--start-maximized']              // Abre el navegador maximizado si el OS lo soporta
  },

  // Base URL centralizada para no hardcodearla en las páginas
  baseURL: 'https://www.saucedemo.com',

  // Configuración de emulación de dispositivos nativos de Playwright
  projects: [
    {
      name: 'chromium',
      use: { ...devices['Desktop Chrome'] },
    },
    {
      name: 'firefox',
      use: { ...devices['Desktop Firefox'] },
    },
    {
      name: 'webkit',
      use: { ...devices['Desktop Safari'] },
    },
    /* Puedes activar estos si en el futuro necesitas validar layouts móviles */
    // {
    //   name: 'mobile-chrome',
    //   use: { ...devices['Pixel 5'] },
    // },
    // {
    //   name: 'mobile-safari',
    //   use: { ...devices['iPhone 12'] },
    // }
  ],
};

export default config;