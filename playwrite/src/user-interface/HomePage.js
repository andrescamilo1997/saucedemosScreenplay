// src/user-interface/HomePage.js
export class HomePage {
    /**
     * @param {import('@playwright/test').Page} page
     */
    constructor(page) {
        this.page = page;
        //this.preciosProductos = page.locator('.inventory_item_price');
        //this.sortDropdown = page.locator('[data-test="product-sort-container"]');
    }

    async verificarExistenciaNombre(nombreProducto) {
        const selector = this.page.getByText(nombreProducto, { exact: true });
        return await selector.isVisible();
    }

    async obtenerPrecioDelProducto(nombreProducto) {
        const tarjetaProducto = this.page.locator('.inventory_item')
            .filter({ hasText: nombreProducto }); 

        const elementoPrecio = tarjetaProducto.locator('.inventory_item_price');

        return await elementoPrecio.textContent();
    }

    async ordenarPor(valorOpcion) {
        const dropdown = this.page.locator('[data-test="product-sort-container"]');
        await dropdown.waitFor({ state: 'visible', timeout: 5000 });
        await dropdown.selectOption(valorOpcion);
    }
    
    async obtenerNombresVisibles() {
        const nombres = this.page.locator('.inventory_item_name');
        return await nombres.allTextContents();
    }
}