package org.sampleapp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by shelajev on 22/07/16.
 */
@Entity
public class PokemonSpecies {

  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  public Long id;
  public Long number;
  public String name;

  @ManyToMany
  public Set<PokemonSpecies> previousEvolution = new HashSet<>();

  @ManyToMany
  public Set<PokemonSpecies> nextEvolution = new HashSet<>();

  public PokemonSpecies() {
  }

  public PokemonSpecies(long n, String name) {
    this.number = n;
    this.name = name;
  }
}
