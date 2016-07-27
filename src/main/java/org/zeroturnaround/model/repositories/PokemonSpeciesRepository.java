package org.zeroturnaround.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.zeroturnaround.model.PokemonSpecies;

/**
 * Created by shelajev on 22/07/16.
 */
public interface PokemonSpeciesRepository extends CrudRepository<PokemonSpecies, Long> {
  public PokemonSpecies findByNumber(long number);
}