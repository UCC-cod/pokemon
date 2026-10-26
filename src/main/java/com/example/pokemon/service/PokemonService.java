package com.example.pokemon.service;

import com.example.pokemon.dto.PokemonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class PokemonService {
    private final RestTemplate restTemplate;
    @Value("${pokemon.api.url}")
    private String url;

    public PokemonResponse consultarPokemon(String nombre){

        //Consumo de API externa
        Map<String, Object> respuesta = restTemplate.getForObject(url+nombre, Map.class);

        String nombrePokemon = (String)respuesta.get("name");
        Integer altura = (Integer)respuesta.get("height");
        Integer peso = (Integer)respuesta.get("weight");

        return new PokemonResponse(
                nombrePokemon,
                altura,
                peso
        );
    }
}
