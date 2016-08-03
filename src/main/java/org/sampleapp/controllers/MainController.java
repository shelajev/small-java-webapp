package org.sampleapp.controllers;

import org.sampleapp.model.Trainer;
import org.sampleapp.model.repositories.PokemonRepository;
import org.sampleapp.model.repositories.TrainerRepository;
import org.sampleapp.util.Git;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.sampleapp.SmallJavaWebappApplication;
import org.sampleapp.model.Pokemon;

import java.util.List;
import java.util.stream.Collectors;
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
    log.info("Rendering the challenge");
    Iterable<Pokemon> pokemons = pokemonRepository.findAll();
    List<Trainer> trainers = StreamSupport
      .stream(pokemons.spliterator(), false)
      .map(p -> p.getTrainer())
      .collect(Collectors.toList());

    model.addAttribute("trainers", trainers);
    return "challenge";
  }

  @RequestMapping("/revert")
  public String revert() {
    new Git().revert();
    return "redirect:/";
  }

}
