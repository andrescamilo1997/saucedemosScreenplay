package com.saucedemo.saucedemo.questions;

import com.saucedemo.saucedemo.userinterfaces.Checkout;

import groovy.util.logging.Slf4j;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

@Slf4j
public class ValidarRegistroProducto implements Question<Boolean> {

    private String mensajeEsperado;

    public static ValidarRegistroProducto productoRegistrado(String mensajeEsperado) {
        ValidarRegistroProducto instancia = new ValidarRegistroProducto();
        instancia.mensajeEsperado = mensajeEsperado;
        return instancia;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String mensajeObtenido = Checkout.MENSAJE_OBTENIDO.resolveFor(actor).getText();

        return mensajeObtenido.equals(mensajeEsperado);
    }
}