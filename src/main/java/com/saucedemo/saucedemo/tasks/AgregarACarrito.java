package com.saucedemo.saucedemo.tasks;

import com.saucedemo.saucedemo.models.Usuario;
import com.saucedemo.saucedemo.userinterfaces.Checkout;
import com.saucedemo.saucedemo.userinterfaces.Productos;
import com.saucedemo.saucedemo.utils.MetodosGenericos;

import groovy.util.logging.Slf4j;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;

@Slf4j
public class AgregarACarrito implements Task {

    String producto;

    public static AgregarACarrito conElProducto(String producto) {
        return new AgregarACarrito(producto);
    }

    private AgregarACarrito(String producto) {
        this.producto = producto;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Click.on(Productos.AGREGAR_AL_CARRITO(producto)),
            Click.on(Productos.IR_CARRITO)
        );

        actor.remember("TituloProducto", Productos.ITEM_NAME.resolveFor(actor).getText());
        actor.remember("DescripcionProducto", Productos.ITEM_DESCRIPTION.resolveFor(actor).getText());
        actor.remember("PrecioProducto", Productos.ITEM_PRICE.resolveFor(actor).getText());

        Usuario usuario = MetodosGenericos.obtenerValor();
        actor.attemptsTo(
            Click.on(Checkout.CHECKOUT),
            SendKeys.of(usuario.getNombre()).into(Checkout.FIRSTNAME),
            SendKeys.of(usuario.getApellido()).into(Checkout.LASTNAME),
            SendKeys.of(usuario.getCodigoPostal()).into(Checkout.ZIP_POSTAL_CODE),
            Click.on(Checkout.CONTINUE)
        );
    }
}