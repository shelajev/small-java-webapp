package org.sampleapp;

import org.sampleapp.model.PokemonSpecies;
import org.sampleapp.model.Trainer;
import org.sampleapp.model.repositories.PokemonRepository;
import org.sampleapp.model.repositories.PokemonSpeciesRepository;
import org.sampleapp.model.repositories.TrainerRepository;
import org.sampleapp.util.Names;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.sampleapp.model.Pokemon;

import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
public class SmallJavaWebappApplication {

  private static final Logger log = LoggerFactory.getLogger(SmallJavaWebappApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(SmallJavaWebappApplication.class, args);
  }

  @Bean
  public CommandLineRunner demo(PokemonSpeciesRepository species, PokemonRepository pokemons, TrainerRepository trainers) {
    return (args) -> {
      createPokemonSpecies(species);
      createTrainers(species, pokemons, trainers);
    };
  }

  private void createTrainers(PokemonSpeciesRepository species, PokemonRepository pokemons, TrainerRepository trainers) {
    if (trainers.count() > 0) {
      return;
    }

    int n = 100;
    for (int i = 0; i < n; i++) {
      long level = ThreadLocalRandom.current().nextLong(1, 30);
      int c = ThreadLocalRandom.current().nextInt(1, 20);
      Trainer t = new Trainer(Names.randomName(), level);
      for (int j = 0; j < c; j++) {
        long number = ThreadLocalRandom.current().nextLong(1, 100);
        PokemonSpecies kind = species.findByNumber(number);
        long hp = ThreadLocalRandom.current().nextLong(10, 400);
        long cp = ThreadLocalRandom.current().nextLong(10, 400);
        Pokemon p = new Pokemon(kind, Names.randomFirstName(), cp, hp);
        t.addPokemon(p);
      }
      trainers.save(t);
    }

  }

  private void createPokemonSpecies(PokemonSpeciesRepository repository) {
    if (repository.count() > 0) {
      return;
    }
    repository.save(new PokemonSpecies(1, "Bulbasaur"));
    repository.save(new PokemonSpecies(2, "Ivysaur"));
    repository.save(new PokemonSpecies(3, "Venusaur"));
    repository.save(new PokemonSpecies(4, "Charmander"));
    repository.save(new PokemonSpecies(5, "Charmeleon"));
    repository.save(new PokemonSpecies(6, "Charizard"));
    repository.save(new PokemonSpecies(7, "Squirtle"));
    repository.save(new PokemonSpecies(8, "Wartortle"));
    repository.save(new PokemonSpecies(9, "Blastoise"));
    repository.save(new PokemonSpecies(10, "Caterpie"));
    repository.save(new PokemonSpecies(11, "Metapod"));
    repository.save(new PokemonSpecies(12, "Butterfree"));
    repository.save(new PokemonSpecies(13, "Weedle"));
    repository.save(new PokemonSpecies(14, "Kakuna"));
    repository.save(new PokemonSpecies(15, "Beedrill"));
    repository.save(new PokemonSpecies(16, "Pidgey"));
    repository.save(new PokemonSpecies(17, "Pidgeotto"));
    repository.save(new PokemonSpecies(18, "Pidgeot"));
    repository.save(new PokemonSpecies(19, "Rattata"));
    repository.save(new PokemonSpecies(20, "Raticate"));
    repository.save(new PokemonSpecies(21, "Spearow"));
    repository.save(new PokemonSpecies(22, "Fearow"));
    repository.save(new PokemonSpecies(23, "Ekans"));
    repository.save(new PokemonSpecies(24, "Arbok"));
    repository.save(new PokemonSpecies(25, "Pikachu"));
    repository.save(new PokemonSpecies(26, "Raichu"));
    repository.save(new PokemonSpecies(27, "Sandshrew"));
    repository.save(new PokemonSpecies(28, "Sandslash"));
    repository.save(new PokemonSpecies(29, "Nidoran♀"));
    repository.save(new PokemonSpecies(30, "Nidorina"));
    repository.save(new PokemonSpecies(31, "Nidoqueen"));
    repository.save(new PokemonSpecies(32, "Nidoran♂"));
    repository.save(new PokemonSpecies(33, "Nidorino"));
    repository.save(new PokemonSpecies(34, "Nidoking"));
    repository.save(new PokemonSpecies(35, "Clefairy"));
    repository.save(new PokemonSpecies(36, "Clefable"));
    repository.save(new PokemonSpecies(37, "Vulpix"));
    repository.save(new PokemonSpecies(38, "Ninetales"));
    repository.save(new PokemonSpecies(39, "Jigglypuff"));
    repository.save(new PokemonSpecies(40, "Wigglytuff"));
    repository.save(new PokemonSpecies(41, "Zubat"));
    repository.save(new PokemonSpecies(42, "Golbat"));
    repository.save(new PokemonSpecies(43, "Oddish"));
    repository.save(new PokemonSpecies(44, "Gloom"));
    repository.save(new PokemonSpecies(45, "Vileplume"));
    repository.save(new PokemonSpecies(46, "Paras"));
    repository.save(new PokemonSpecies(47, "Parasect"));
    repository.save(new PokemonSpecies(48, "Venonat"));
    repository.save(new PokemonSpecies(49, "Venomoth"));
    repository.save(new PokemonSpecies(50, "Diglett"));
    repository.save(new PokemonSpecies(51, "Dugtrio"));
    repository.save(new PokemonSpecies(52, "Meowth"));
    repository.save(new PokemonSpecies(53, "Persian"));
    repository.save(new PokemonSpecies(54, "Psyduck"));
    repository.save(new PokemonSpecies(55, "Golduck"));
    repository.save(new PokemonSpecies(56, "Mankey"));
    repository.save(new PokemonSpecies(57, "Primeape"));
    repository.save(new PokemonSpecies(58, "Growlithe"));
    repository.save(new PokemonSpecies(59, "Arcanine"));
    repository.save(new PokemonSpecies(60, "Poliwag"));
    repository.save(new PokemonSpecies(61, "Poliwhirl"));
    repository.save(new PokemonSpecies(62, "Poliwrath"));
    repository.save(new PokemonSpecies(63, "Abra"));
    repository.save(new PokemonSpecies(64, "Kadabra"));
    repository.save(new PokemonSpecies(65, "Alakazam"));
    repository.save(new PokemonSpecies(66, "Machop"));
    repository.save(new PokemonSpecies(67, "Machoke"));
    repository.save(new PokemonSpecies(68, "Machamp"));
    repository.save(new PokemonSpecies(69, "Bellsprout"));
    repository.save(new PokemonSpecies(70, "Weepinbell"));
    repository.save(new PokemonSpecies(71, "Victreebel"));
    repository.save(new PokemonSpecies(72, "Tentacool"));
    repository.save(new PokemonSpecies(73, "Tentacruel"));
    repository.save(new PokemonSpecies(74, "Geodude"));
    repository.save(new PokemonSpecies(75, "Graveler"));
    repository.save(new PokemonSpecies(76, "Golem"));
    repository.save(new PokemonSpecies(77, "Ponyta"));
    repository.save(new PokemonSpecies(78, "Rapidash"));
    repository.save(new PokemonSpecies(79, "Slowpoke"));
    repository.save(new PokemonSpecies(80, "Slowbro"));
    repository.save(new PokemonSpecies(81, "Magnemite"));
    repository.save(new PokemonSpecies(82, "Magneton"));
    repository.save(new PokemonSpecies(83, "Farfetch'd"));
    repository.save(new PokemonSpecies(84, "Doduo"));
    repository.save(new PokemonSpecies(85, "Dodrio"));
    repository.save(new PokemonSpecies(86, "Seel"));
    repository.save(new PokemonSpecies(87, "Dewgong"));
    repository.save(new PokemonSpecies(88, "Grimer"));
    repository.save(new PokemonSpecies(89, "Muk"));
    repository.save(new PokemonSpecies(90, "Shellder"));
    repository.save(new PokemonSpecies(91, "Cloyster"));
    repository.save(new PokemonSpecies(92, "Gastly"));
    repository.save(new PokemonSpecies(93, "Haunter"));
    repository.save(new PokemonSpecies(94, "Gengar"));
    repository.save(new PokemonSpecies(95, "Onix"));
    repository.save(new PokemonSpecies(96, "Drowzee"));
    repository.save(new PokemonSpecies(97, "Hypno"));
    repository.save(new PokemonSpecies(98, "Krabby"));
    repository.save(new PokemonSpecies(99, "Kingler"));
    repository.save(new PokemonSpecies(100, "Voltorb"));
    repository.save(new PokemonSpecies(101, "Electrode"));
    repository.save(new PokemonSpecies(102, "Exeggcute"));
    repository.save(new PokemonSpecies(103, "Exeggutor"));
    repository.save(new PokemonSpecies(104, "Cubone"));
    repository.save(new PokemonSpecies(105, "Marowak"));
    repository.save(new PokemonSpecies(106, "Hitmonlee"));
    repository.save(new PokemonSpecies(107, "Hitmonchan"));
    repository.save(new PokemonSpecies(108, "Lickitung"));
    repository.save(new PokemonSpecies(109, "Koffing"));
    repository.save(new PokemonSpecies(110, "Weezing"));
    repository.save(new PokemonSpecies(111, "Rhyhorn"));
    repository.save(new PokemonSpecies(112, "Rhydon"));
    repository.save(new PokemonSpecies(113, "Chansey"));
    repository.save(new PokemonSpecies(114, "Tangela"));
    repository.save(new PokemonSpecies(115, "Kangaskhan"));
    repository.save(new PokemonSpecies(116, "Horsea"));
    repository.save(new PokemonSpecies(117, "Seadra"));
    repository.save(new PokemonSpecies(118, "Goldeen"));
    repository.save(new PokemonSpecies(119, "Seaking"));
    repository.save(new PokemonSpecies(120, "Staryu"));
    repository.save(new PokemonSpecies(121, "Starmie"));
    repository.save(new PokemonSpecies(122, "Mr. Mime"));
    repository.save(new PokemonSpecies(123, "Scyther"));
    repository.save(new PokemonSpecies(124, "Jynx"));
    repository.save(new PokemonSpecies(125, "Electabuzz"));
    repository.save(new PokemonSpecies(126, "Magmar"));
    repository.save(new PokemonSpecies(127, "Pinsir"));
    repository.save(new PokemonSpecies(128, "Tauros"));
    repository.save(new PokemonSpecies(129, "Magikarp"));
    repository.save(new PokemonSpecies(130, "Gyarados"));
    repository.save(new PokemonSpecies(131, "Lapras"));
    repository.save(new PokemonSpecies(132, "Ditto"));
    repository.save(new PokemonSpecies(133, "Eevee"));
    repository.save(new PokemonSpecies(134, "Vaporeon"));
    repository.save(new PokemonSpecies(135, "Jolteon"));
    repository.save(new PokemonSpecies(136, "Flareon"));
    repository.save(new PokemonSpecies(137, "Porygon"));
    repository.save(new PokemonSpecies(138, "Omanyte"));
    repository.save(new PokemonSpecies(139, "Omastar"));
    repository.save(new PokemonSpecies(140, "Kabuto"));
    repository.save(new PokemonSpecies(141, "Kabutops"));
    repository.save(new PokemonSpecies(142, "Aerodactyl"));
    repository.save(new PokemonSpecies(143, "Snorlax"));
    repository.save(new PokemonSpecies(144, "Articuno"));
    repository.save(new PokemonSpecies(145, "Zapdos"));
    repository.save(new PokemonSpecies(146, "Moltres"));
    repository.save(new PokemonSpecies(147, "Dratini"));
    repository.save(new PokemonSpecies(148, "Dragonair"));
    repository.save(new PokemonSpecies(149, "Dragonite"));
    repository.save(new PokemonSpecies(150, "Mewtwo"));
    repository.save(new PokemonSpecies(151, "Mew"));
  }
}
