package org.zeroturnaround.model;

import javax.persistence.*;

/**
 * Created by shelajev on 22/07/16.
 */
@Entity
public class Pokemon {

  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  public Long id;

  @ManyToOne
  public PokemonSpecies species;

  public String name;
  public Long CP;
  public Long HP;

  public Pokemon() {}


  public Pokemon(PokemonSpecies species, String name, Long CP, Long HP) {
    this.species = species;
    this.name = name;
    this.CP = CP;
    this.HP = HP;
  }


}
