package com.saucedemo.saucedemo.utils;

import com.saucedemo.saucedemo.models.Usuario;
import net.datafaker.Faker; // O usa com.github.javafaker.Faker si tienes la versión antigua
import java.util.Locale;
import groovy.util.logging.Slf4j;

@Slf4j
public class MetodosGenericos {

    public static Usuario obtenerValor() {
        Faker faker = new Faker(new Locale("es-MX"));
        return new Usuario(
            faker.name().firstName(),       
            faker.name().lastName(),        
            faker.address().zipCode()       
        );
    }

}