package com.example.pokemon.service;

import com.example.pokemon.dto.PokemonResponse;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PokemonServiceTest {

    @Test
    void debeConsultarPokemon(){

        //Simulamos la conexión a la API externa
        RestTemplate restTemplate = Mockito.mock(RestTemplate.class);

        PokemonService service = new PokemonService(restTemplate);

        Map<String, Object> respuesta = Map.of(
                "name", "charizard",
                "height", 17,
                "weight", 905
        );

        Mockito.when(restTemplate.getForObject(
                Mockito.anyString(),
                Mockito.eq(Map.class)
        )).thenReturn(respuesta);

        PokemonResponse pokemonResponse = service.consultarPokemon("charizard");

        assertEquals("charizard", pokemonResponse.getNombre());
        assertEquals(17, pokemonResponse.getAltura());
        assertEquals(905, pokemonResponse.getPeso());
    }
}
