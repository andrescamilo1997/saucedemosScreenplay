import { Given, When, Then } from '@cucumber/cucumber';
import { expect } from '@playwright/test';
import { LoginPage } from '../../src/user-interface/LoginPage.js';
import { HomePage } from '../../src/user-interface/HomePage.js';
import { CatalogoSauceDemo } from '../../src/utils/CatalogoSauceDemo.js'; 

Given('que el usuario {string} se encuentra en la página de inicio de sesión',{ timeout: 20000 }, async function (usuario) {
    this.loginPage = new LoginPage(this.page);
    this.homePage = new HomePage(this.page);
    
    await this.loginPage.irA();
    await this.loginPage.login(usuario, 'secret_sauce');
    
    this.usuarioActual = usuario;
});

When('que verifica los productos existentes', async function () {
    console.log(`Verificando que todos los nombres existan en la UI...`);
    
    const productos = Object.values(CatalogoSauceDemo);
    const nombresNoEncontrados = [];

    for (const producto of productos) {
        const existe = await this.homePage.verificarExistenciaNombre(producto.nombre);
        if (existe) {
            console.log(`Nombre correcto: ${producto.nombre}`);
        } else {
            console.log(`Nombre ausente: ${producto.nombre}`);
            nombresNoEncontrados.push(producto.nombre);
        }
    }

    expect(nombresNoEncontrados.length, `Los siguientes nombres no existen: [${nombresNoEncontrados.join(', ')}]`).toBe(0);
});

Then('se identifica que cada producto tiene un precio asociado.', async function () {
    console.log(`Validando que los precios coincidan...`);
    
    const productos = Object.values(CatalogoSauceDemo);
    const fallosDePrecios = [];

    for (const producto of productos) {
        // Ejecuta el método nativo (con locator.filter) o el XPath que definiste en tu HomePage
        const precioRealUI = await this.homePage.obtenerPrecioDelProducto(producto.nombre);
        const precioEsperado = producto.precio;

        const precioLimpio = precioRealUI?.trim();

        if (precioLimpio === precioEsperado) {
            console.log(`${producto.nombre} -> Precio correcto: ${precioLimpio}`);
        } else {
            console.log(`${producto.nombre} -> Error. Esperado: ${precioEsperado}, Encontrado: ${precioLimpio}`);
            fallosDePrecios.push(`${producto.nombre} (Esperaba: ${precioEsperado}, Vio: ${precioLimpio})`);
        }
    }

    expect(fallosDePrecios.length, `Errores de correspondencia en catálogo: [${fallosDePrecios.join(' | ')}]`).toBe(0);
});