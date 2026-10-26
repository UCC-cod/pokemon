package com.example.pokemon.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraServiceTest {
    @Test
    void debeSumarDosNumeros(){

        //Inicio
        CalculadoraService calculadoraService = new CalculadoraService();

        //Act
        int resultado = calculadoraService.sumar(5, 4);

        //Assert
        assertEquals(9, resultado);
    }
}
