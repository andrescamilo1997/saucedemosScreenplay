package com.saucedemo.saucedemo.questions;

import com.saucedemo.saucedemo.userinterfaces.Checkout;
import com.saucedemo.saucedemo.userinterfaces.Productos;

import groovy.util.logging.Slf4j;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;

@Slf4j
public class ValidarInformacion implements Question<Boolean> {

    public static ValidarInformacion productoRegistrado() {
        return new ValidarInformacion();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String tituloProductoGuardado = actor.recall("TituloProducto");
        String descripcionProductoGuardado = actor.recall("DescripcionProducto");
        String precioProductoGuardado = actor.recall("PrecioProducto");

        String tituloProducto = Productos.ITEM_NAME.resolveFor(actor).getText();
        String descripcionProducto = Productos.ITEM_DESCRIPTION.resolveFor(actor).getText();
        String precioProducto = Productos.ITEM_PRICE.resolveFor(actor).getText();

        OnStage.theActorInTheSpotlight().attemptsTo(
            Click.on(Checkout.FINISH)
        );

        return tituloProductoGuardado.equals(tituloProducto) &&
               descripcionProductoGuardado.equals(descripcionProducto) &&
               precioProductoGuardado.equals(precioProducto);
    }
}