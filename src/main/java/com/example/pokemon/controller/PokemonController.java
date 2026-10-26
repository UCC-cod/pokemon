package com.example.pokemon.controller;

import com.example.pokemon.dto.PokemonResponse;
import com.example.pokemon.service.PokemonService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pokemon")
@RequiredArgsConstructor
public class PokemonController {
    private final PokemonService pokemonService;


    //Se documenta cada método
    @Operation(
            summary = "Consultar la información de un pokemon"
    )
    @GetMapping("/{nombre}")
    public PokemonResponse consultar(@PathVariable String nombre){
        return pokemonService.consultarPokemon(nombre);
    }

}
