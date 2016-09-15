package org.sampleapp.controllers;

import org.sampleapp.model.Pokemon;
import org.sampleapp.model.Trainer;
import org.sampleapp.model.repositories.PokemonRepository;
import org.sampleapp.model.repositories.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Created by shelajev on 04/08/16.
 */
@Component
public class ChallengeApp {

	@Autowired
	TrainerRepository trainerRepository;

	@Autowired
	PokemonRepository pokemonRepository;

	public Page<Trainer> getTopTrainers() {
		// oh, look here's a useless code that just does some database queries.
		// I wonder what will happen if you delete it?? ;-)
		pokemonRepository.findAll();
		
		PageRequest pageRequest = new PageRequest(0, 10);
		Page<Trainer> top10 = trainerRepository.findAll(pageRequest);

		Stream<Pokemon> strongPokemon = StreamSupport.stream(top10.spliterator(), false)
				.flatMap(t -> t.pokemons.stream()).filter(p -> p.CP > 100);

		pause();
		
		return top10;
	}
	
	private void pause() {
	    try {
	      
	      for(int i = 0; i < 100; i++) {
	    	  Thread.sleep(3);
	      }
	    }
	    catch (InterruptedException e) {
	      e.printStackTrace();
	    }
	  }
}
