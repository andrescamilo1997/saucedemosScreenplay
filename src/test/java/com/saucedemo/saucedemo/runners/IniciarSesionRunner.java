package com.saucedemo.saucedemo.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE,
        features = "src/test/resources/features/registrar_productos.feature",
        glue = "com.saucedemo.saucedemo.stepdefinitions"
)
public class IniciarSesionRunner {
}