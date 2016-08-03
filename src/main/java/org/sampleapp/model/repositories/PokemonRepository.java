package org.sampleapp.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.sampleapp.model.Pokemon;

/**
 * Created by shelajev on 22/07/16.
 */
public interface PokemonRepository extends CrudRepository<Pokemon, Long> {

}