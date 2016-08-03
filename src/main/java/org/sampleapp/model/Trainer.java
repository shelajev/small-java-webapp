package org.sampleapp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by shelajev on 22/07/16.
 */
@Entity
public class Trainer {

  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  public Long id;
  public String name;

  public Long level;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "trainer", fetch = FetchType.EAGER)
  public Set<Pokemon> pokemons = new HashSet<>();


  public Trainer() {}

  public Trainer(String name, Long level) {
    this.name = name;
    this.level = level;
  }

  public Trainer addPokemon(Pokemon pokemon) {
    this.pokemons.add(pokemon);
    pokemon.setTrainer(this);
    return this;
  }
}
