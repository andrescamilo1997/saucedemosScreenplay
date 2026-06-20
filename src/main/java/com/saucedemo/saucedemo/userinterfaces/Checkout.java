package com.saucedemo.saucedemo.userinterfaces;

import groovy.util.logging.Slf4j;
import net.serenitybdd.screenplay.targets.Target;

@Slf4j
public class Checkout {

    public static final Target CHECKOUT = Target.the("botón de checkout")
            .locatedBy("//*[@data-test='checkout']"); 
            
    public static final Target FIRSTNAME = Target.the("campo de nombre")
            .locatedBy("//*[@data-test='firstName']");      
            
    public static final Target LASTNAME = Target.the("campo de apellido")
            .locatedBy("//*[@data-test='lastName']"); 

    public static final Target ZIP_POSTAL_CODE = Target.the("campo de código postal")
            .locatedBy("//*[@data-test='postalCode']");

    public static final Target CONTINUE = Target.the("botón de continuar")
            .locatedBy("//*[@data-test='continue']");

            
    public static final Target FINISH = Target.the("botón de finalizar")
            .locatedBy("//*[@data-test='finish']");

    public static final Target MENSAJE_OBTENIDO = Target.the("mensaje de confirmación")
            .locatedBy("//noscript");

}