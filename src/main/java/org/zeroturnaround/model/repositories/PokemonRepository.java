package org.zeroturnaround.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.zeroturnaround.model.Pokemon;

/**
 * Created by shelajev on 22/07/16.
 */
public interface PokemonRepository extends CrudRepository<Pokemon, Long> {

}