package org.sampleapp.controllers.api;

import org.sampleapp.model.Trainer;
import org.sampleapp.model.repositories.PokemonRepository;
import org.sampleapp.model.repositories.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.sampleapp.model.Pokemon;

/**
 * Created by shelajev on 22/07/16.
 */

@RestController
@RequestMapping(value = "/api")
public class ApiController {

  @Autowired
  public TrainerRepository trainersRepository;

  @Autowired
  public PokemonRepository pokemonRepository;


  @RequestMapping("/trainers")
  public Iterable<Trainer> trainers(@RequestParam(value="name", defaultValue="") String name) {
    if(name.isEmpty()) {
      return trainersRepository.findAll();
    }
    return trainersRepository.findByName(name);
  }

  @RequestMapping("/pokemons")
  public Iterable<Pokemon> pokemons() {
      return pokemonRepository.findAll();
  }

}
