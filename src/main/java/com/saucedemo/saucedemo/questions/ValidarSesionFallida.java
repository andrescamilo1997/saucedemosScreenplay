package com.saucedemo.saucedemo.questions;

import com.saucedemo.saucedemo.userinterfaces.IniciarSesionDefinition;

import groovy.util.logging.Slf4j;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

@Slf4j
public class ValidarSesionFallida implements Question<Boolean> {

    String msgError;

    public static ValidarSesionFallida conMensajeError(String msgError) {
        return new ValidarSesionFallida(msgError);
    }

    private ValidarSesionFallida(String msgError) {
        this.msgError = msgError;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String msg = IniciarSesionDefinition.MSG_ERROR.resolveFor(actor).getTextValue();
        return msg.contains(msgError);
    }
}