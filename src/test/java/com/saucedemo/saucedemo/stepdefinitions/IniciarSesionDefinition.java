package com.saucedemo.saucedemo.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.saucedemo.saucedemo.questions.ValidarInformacion;
import com.saucedemo.saucedemo.questions.ValidarRegistroProducto;
import com.saucedemo.saucedemo.questions.ValidarSesionFallida;
import com.saucedemo.saucedemo.tasks.AgregarACarrito;
import com.saucedemo.saucedemo.tasks.IniciarSesion;

import groovy.util.logging.Slf4j;
import io.cucumber.java.Before;
import io.cucumber.java.ast.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.model.util.EnvironmentVariables;

@Slf4j
public class IniciarSesionDefinition {

    @Managed
    private WebDriver suNavegador;

    // 2. Inyectas las variables de entorno de Serenity
    private EnvironmentVariables environmentVariables;

    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());
        String baseUrl = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("webdriver.base.url");
        System.out.println("Base URL recuperada: " + baseUrl);
        OnStage.theActorCalled("agente");
        OnStage.theActorInTheSpotlight().can(BrowseTheWeb.with(suNavegador));
        OnStage.theActorInTheSpotlight().attemptsTo(
                Open.url(baseUrl)
        );
    }
    @Dado("que el usuario {string} está en la página de registro de productos")
    @Cuando("que el usuario {string} está bloqueado")
    public void queElUsuarioEstaBloqueado(String usuario) {
        OnStage.theActorInTheSpotlight().attemptsTo(
            IniciarSesion.conLasCredenciales(usuario, "secret_sauce")
        );
    }

    @Entonces("el sistema debería mostrar un mensaje de error {string}")
    public void elSistemaDeberiaMostrarUnMensajeDeError(String mensaje) {
        OnStage.theActorInTheSpotlight().asksFor(
            ValidarSesionFallida.conMensajeError(mensaje)
        );
    }

    @Cuando("el usuario ingresa los productos al carrito: {string}")
    public void elUsuarioIngresaLosProductosAlCarrito(String nombreProducto) {
        OnStage.theActorInTheSpotlight().attemptsTo(
            AgregarACarrito.conElProducto(nombreProducto)
        );
    }

    @Entonces("el producto debería ser registrado exitosamente")
    public void elProductoDeberiaSerRegistradoExitosamente() {
        OnStage.theActorInTheSpotlight().asksFor(
            ValidarInformacion.productoRegistrado()
        );
    }

    @Entonces("el sistema debería mostrar un mensaje de confirmación {string}")
    public void elSistemaDeberiaMostrarUnMensajeDeConfirmacion(String mensaje) {
        OnStage.theActorInTheSpotlight().asksFor(
            ValidarRegistroProducto.productoRegistrado(mensaje)
        );
    }

}