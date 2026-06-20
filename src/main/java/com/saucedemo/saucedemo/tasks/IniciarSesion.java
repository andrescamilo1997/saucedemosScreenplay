package com.saucedemo.saucedemo.tasks;

import com.saucedemo.saucedemo.userinterfaces.IniciarSesionDefinition;

import groovy.util.logging.Slf4j;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

@Slf4j
public class IniciarSesion implements Task {

    String usuario;
    String password;

    public static IniciarSesion conLasCredenciales(String usuario, String password) {
        return new IniciarSesion(usuario, password);
    }

    private IniciarSesion(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Enter.theValue(usuario).into(IniciarSesionDefinition.USUARIO),
            Enter.theValue(password).into(IniciarSesionDefinition.PASSWORD),
            Click.on(IniciarSesionDefinition.LOG_IN)
        );
    }
}