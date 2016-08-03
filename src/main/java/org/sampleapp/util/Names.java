package org.sampleapp.util;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by shelajev on 29/07/16.
 */
public class Names {

  public static String[] names = {
    "Tyrion Lannister",
    "Jaime Lannister",
    "Cersei Lannister",
    "Daenerys Targaryen",
    "Jon Snow",
    "Petyr Baelish",
    "Jorah Mormont",
    "Sansa Stark",
    "Arya Stark",
    "Theon Greyjoy",
    "Bran Stark",
    "Sandor Clegane",
    "Joffrey Baratheon",
    "Catelyn Stark",
    "Robb Stark",
    "Ned Stark",
    "Robert Baratheon",
    "Viserys Targaryen",
    "Varys",
    "Samwell Tarly",
    "Bronn",
    "Tywin Lannister",
    "Shae",
    "Jeor Mormont",
    "Gendry",
    "Tommen Baratheon",
    "Jaqen H'ghar",
    "Khal Drogo",
    "Davos Seaworth",
    "Melisandre",
    "Margaery Tyrell",
    "Stannis Baratheon",
    "Ygritte",
    "Talisa Stark",
    "Brienne of Tarth",
    "Gilly",
    "Roose Bolton",
    "Tormund Giantsbane",
    "Ramsay Bolton",
    "Daario Naharis",
    "Missandei",
    "Ellaria Sand",
    "The High Sparrow"
  };


  public static String[] firstNames = {
    "Willena",
    "Nelly",
    "Renate",
    "Clarine",
    "Truman",
    "Bradly",
    "Candis",
    "Caprice",
    "Annalee",
    "Kaylee",
    "Solange",
    "Ashlyn",
    "Tomas",
    "Jinny",
    "Juli",
    "Evelia",
    "Isaura",
    "Leeanna",
    "Mara",
    "Seth",
    "Twyla",
    "Roselee",
    "Lisha",
    "Mammie",
    "Jenee",
    "Victorina",
    "Stella",
    "Shery",
    "Nadia",
    "Lynelle",
    "Brad",
    "Grace",
    "Aida",
    "Staci",
    "Leonore",
    "Jodie",
    "Andres",
    "Madaline",
    "Shakita",
    "Coralie",
    "Assunta",
    "Raina",
    "Jona",
    "Kirstin",
    "Maisie",
    "Meredith",
    "Sherika",
    "Noriko",
    "Wendi",
    "Cliff"
  };

  public static String randomName() {
    return names[ThreadLocalRandom.current().nextInt(names.length)];
  }

  public static String randomFirstName() {
    return firstNames[ThreadLocalRandom.current().nextInt(firstNames.length)];
  }
}


