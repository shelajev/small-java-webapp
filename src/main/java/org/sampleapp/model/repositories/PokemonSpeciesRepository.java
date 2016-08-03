package org.sampleapp.model.repositories;

import org.sampleapp.model.PokemonSpecies;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by shelajev on 22/07/16.
 */
public interface PokemonSpeciesRepository extends CrudRepository<PokemonSpecies, Long> {
  public PokemonSpecies findByNumber(long number);
}