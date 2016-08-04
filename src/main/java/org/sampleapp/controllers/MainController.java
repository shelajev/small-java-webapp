package org.sampleapp.controllers;

import org.sampleapp.SmallJavaWebappApplication;
import org.sampleapp.model.Pokemon;
import org.sampleapp.model.Trainer;
import org.sampleapp.model.repositories.PokemonRepository;
import org.sampleapp.model.repositories.TrainerRepository;
import org.sampleapp.util.Git;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Created by shelajev on 24/07/16.
 */

@Controller
public class MainController {

  private static final Logger log = LoggerFactory.getLogger(SmallJavaWebappApplication.class);

  @Autowired TrainerRepository trainerRepository;

  @Autowired PokemonRepository pokemonRepository;

  @RequestMapping("/")
  public String index() {
    return "tour";
  }

  @RequestMapping("/challenge")
  public String challenge(Model model) {
    log.info("Loading all the trainers and their pokemon (even if they don't have any)");

    PageRequest pageRequest = new PageRequest(0, 20);
    Page<Trainer> top10 = trainerRepository.findAll(pageRequest);

    Stream<Pokemon> strongPokemon = StreamSupport.stream(top10.spliterator(), false)
      .flatMap(t -> t.pokemons.stream())
      .filter(p -> p.CP > 100);

    model.addAttribute("trainers", top10);
    return "challenge";
  }

  @RequestMapping("/revert")
  public String revert() {
    new Git().revert();
    return "redirect:/";
  }

}
