package com.saucedemo.saucedemo.userinterfaces;

import groovy.util.logging.Slf4j;
import net.serenitybdd.screenplay.targets.Target;

@Slf4j
public class Productos {

    public static final Target IR_CARRITO = Target.the("título de la página de productos")
            .locatedBy("//a[@data-test='shopping-cart-link']");

    public static final Target CHECKOUT = Target.the("botón de checkout")
            .locatedBy("//*[@data-test='checkout']"); 
            
    public static final Target FIRSTNAME = Target.the("campo de nombre")
            .locatedBy("//*[@data-test='firstName']");      
            
    public static final Target LASTNAME = Target.the("campo de apellido")
            .locatedBy("//*[@data-test='lastName']"); 

    public static final Target ZIP_POSTAL_CODE = Target.the("campo de código postal")
            .locatedBy("//*[@data-test='postalCode']");

    public static final Target ITEM_NAME = Target.the("Nombre del producto")
            .locatedBy("[data-test='inventory-item-name']");

    public static final Target ITEM_DESCRIPTION = Target.the("Descripción del producto")
            .locatedBy("[data-test='inventory-item-desc']");

    public static final Target ITEM_PRICE = Target.the("Precio del producto")
            .locatedBy("[data-test='inventory-item-price']");
    
    private static String PRODUCTO = "//div[@data-test='inventory-item-name' and text()='%s']/ancestor::div[@data-test='inventory-item-description']//button[contains(@name, 'add-to-cart')]";

    public static Target AGREGAR_AL_CARRITO(String nombreProducto) {
        return Target.the("botón de agregar al carrito para el producto " + nombreProducto)
                .locatedBy(String.format(PRODUCTO, nombreProducto));
    }

}