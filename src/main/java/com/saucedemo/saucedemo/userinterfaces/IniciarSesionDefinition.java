package com.saucedemo.saucedemo.userinterfaces;

import groovy.util.logging.Slf4j;
import net.serenitybdd.screenplay.targets.Target;

@Slf4j
public class IniciarSesionDefinition {
    
    public static final Target USUARIO = Target.the("campo de identificación")
            .locatedBy("//*[@id='user-name']");

    public static final Target PASSWORD = Target.the("campo de contraseña")
            .locatedBy("//*[@id='password']");

    public static final Target LOG_IN = Target.the("botón de inicio de sesión")
            .locatedBy("//*[@id='login-button']");

    public static final Target MSG_ERROR = Target.the("mensaje de error")
        .locatedBy("//div[@class='error-message-container error']/h3");

}