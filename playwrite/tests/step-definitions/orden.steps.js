import { When, Then } from '@cucumber/cucumber';
import { expect } from '@playwright/test';

When('realiza la acción de organizar los precios de los productos', { timeout: 20000 }, async function () {
    console.log('Ordenando productos de la Z a la A...');
    await this.homePage.ordenarPor('za');
});

Then('se identifica que se organizan los items en orden', async function () {
    console.log('Validando que el ordenamiento de Z a A sea correcto...');
    
    const nombresRealesUI = await this.homePage.obtenerNombresVisibles();
    console.log('   Orden en pantalla:', nombresRealesUI);

    const nombresOrdenadosEsperados = [...nombresRealesUI].sort().reverse();
    console.log('   Orden esperado (Z-A):', nombresOrdenadosEsperados);

    expect(nombresRealesUI).toEqual(nombresOrdenadosEsperados);
    console.log('¡El ordenamiento en la interfaz es 100% correcto!');
});