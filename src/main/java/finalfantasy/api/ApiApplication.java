package finalfantasy.api;

import finalfantasy.api.IntermediateTables.GameProtagonist;
import finalfantasy.api.IntermediateTables.GameSummon;
import finalfantasy.api.enums.*;
import finalfantasy.api.models.*;
import finalfantasy.api.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(ProtagonistRepository protagonistRepository, GameRepository gameRepository,
									  GameProtagonistRepository gameProtagonistRepository, GameSummonRepository gameSummonRepository,
									  SummonRepository summonRepository, LocationRepository locationRepository, EnemyRepository enemyRepository){
		return (args) -> {

			System.out.println("------------------");
			System.out.println("Magic has started!");
			System.out.println("------------------");


	// GAMES -----------------------//
			Set<String> availableProtagonistFF8 = new HashSet<>();
			availableProtagonistFF8.add("Squall");
			availableProtagonistFF8.add("Rinoa");

			Set<String> availableProtagonistFF7 = new HashSet<>();
			availableProtagonistFF7.add("Cloud");
			availableProtagonistFF7.add("Tifa");

			Set<String> emptySet = new HashSet<>();

			List<Game> gamesList = Arrays.asList(
			new Game("Final Fantasy I", "31/12/1999", "https://th.bing.com/th/id/OIP.Pcp_rJhq2R0aQk7sPB8WVAHaF8?pid=ImgDet&rs=1", Plataform.SNES, GameDescription.FF_8_DESCRIPTION, emptySet),
			new Game("Final Fantasy II", "31/12/1999", "https://static.wikia.nocookie.net/finalfantasy/images/6/69/FFII_logo.png", Plataform.SNES, GameDescription.FF_8_DESCRIPTION, emptySet),
			new Game("Final Fantasy III", "31/12/1999", "", Plataform.SNES, GameDescription.FF_3_DESCRIPTION, emptySet),
			new Game("Final Fantasy IV", "31/12/1999", "", Plataform.SUPER_NES, GameDescription.FF_4_DESCRIPTION, emptySet),
			new Game("Final Fantasy IV, After Years", "31/12/1999", "", Plataform.SUPER_NES, GameDescription.FF_4_DESCRIPTION, emptySet),
			new Game("Final Fantasy V", "31/12/1999", "", Plataform.SUPER_NES, GameDescription.FF_5_DESCRIPTION, emptySet),
			new Game("Final Fantasy VI", "31/12/1999", "", Plataform.SUPER_NES, GameDescription.FF_6_DESCRIPTION, emptySet),
			new Game("Final Fantasy VII", "31/12/1999", "", Plataform.PLAYSTATION, GameDescription.FF_7_DESCRIPTION, availableProtagonistFF7),
			new Game("Final Fantasy VII, Before Crisis", "31/12/1999", "", Plataform.MOBIL_PHONE, GameDescription.FF_7_DESCRIPTION, emptySet),
			new Game("Final Fantasy VII, Dirge of Cerberus", "31/12/1999", "", Plataform.PLAYSTATION_2, GameDescription.FF_7_DESCRIPTION, emptySet),
			new Game("Final Fantasy VII, Crisis Core", "31/12/1999", "", Plataform.PSP, GameDescription.FF_7_DESCRIPTION, emptySet),
			new Game("Final Fantasy VIII", "31/12/1999", "", Plataform.PLAYSTATION, GameDescription.FF_8_DESCRIPTION, availableProtagonistFF8),
			new Game("Final Fantasy IX", "31/12/1999", "", Plataform.PLAYSTATION, GameDescription.FF_9_DESCRIPTION, emptySet),
			new Game("Final Fantasy X", "31/12/1999", "", Plataform.PLAYSTATION_2, GameDescription.FF_10_DESCRIPTION, emptySet),
			new Game("Final Fantasy X-2", "31/12/1999", "", Plataform.PLAYSTATION_2, GameDescription.FF_10_2DESCRIPTION, emptySet),
			new Game("Final Fantasy XII", "31/12/1999", "h", Plataform.PLAYSTATION_2, GameDescription.FF_12_DESCRIPTION, emptySet),
			new Game("Final Fantasy XIII", "31/12/1999", "", Plataform.PLAYSTATION_3, GameDescription.FF_13_DESCRIPTION, emptySet),
			new Game("Final Fantasy XIII-2", "31/12/1999", "", Plataform.PLAYSTATION_3, GameDescription.FF_13_DESCRIPTION, emptySet),
			new Game("Final Fantasy XIII, Lightning Returns", "31/12/1999", "", Plataform.PLAYSTATION_3, GameDescription.FF_13_DESCRIPTION, emptySet),
			new Game("Final Fantasy XV", "31/12/1999", "", Plataform.PLAYSTATION_4, GameDescription.FF_15_DESCRIPTION, emptySet),
			new Game("Final Fantasy Dissidia", "1/2/2017", "https://static.wikia.nocookie.net/finalfantasy/images/b/b6/Dissidia_Logo.jpg", Plataform.PSP, GameDescription.FF_DISSIDIA, emptySet),
			new Game("Final Fantasy Type-0", "31/12/1999", "", Plataform.PLAYSTATION_4, GameDescription.FF_7_DESCRIPTION, emptySet)
			);

			for(Game game : gamesList){
				gameRepository.save(game);
			}

	// SUMMON - FINAL FANTASY 8 -----------------------//
			List<Summon> summonsList = Arrays.asList(
				new Summon("Chocobo", SummonType.NON_ELEMENTAL),
				new Summon("Ramuh", SummonType.THUNDER),
				new Summon("Titan", SummonType.EARTH),
				new Summon("Odin", SummonType.NON_ELEMENTAL),
				new Summon("Neo Bahamut", SummonType.NON_ELEMENTAL),
				new Summon("Bahamut Zero", SummonType.NON_ELEMENTAL),
				new Summon("Hades", SummonType.NON_ELEMENTAL),
				new Summon("Knights of the Round", SummonType.NON_ELEMENTAL),
				new Summon("Kujata", SummonType.EARTH),
				new Summon("Phoenix", SummonType.FIRE),
				new Summon("Typhon", SummonType.WIND),
				new Summon("Gilgamesh", SummonType.NON_ELEMENTAL),
				new Summon("Anima", SummonType.NON_ELEMENTAL),
				new Summon("Quetzacotl", SummonType.THUNDER),
				new Summon("Brothers", SummonType.EARTH),
				new Summon("Diablos", SummonType.GRAVITY),
				new Summon("Carbuncle", SummonType.NON_ELEMENTAL),
				new Summon("Leviathan", SummonType.WATER),
				new Summon("Pandemona", SummonType.WIND),
				new Summon("Cerberus", SummonType.NON_ELEMENTAL),
				new Summon("Alexander", SummonType.HOLY),
				new Summon("Doomtrain", SummonType.POISON),
				new Summon("Bahamut", SummonType.NON_ELEMENTAL),
				new Summon("Cactuar", SummonType.NON_ELEMENTAL),
				new Summon("Tonberry", SummonType.NON_ELEMENTAL),
				new Summon("Eden", SummonType.NON_ELEMENTAL),
				new Summon("Ifrit", SummonType.FIRE),
				new Summon("Shiva", SummonType.ICE),
				new Summon("Siren", SummonType.NON_ELEMENTAL)
			);


			for(Summon summon : summonsList){
				summonRepository.save(summon);
			}


			List<Protagonist> protagonistsList = Arrays.asList(
		// PROTAGONIST - FINAL FANTASY 7 -----------------------//
				new Protagonist("Cloud", "Strife", Gender.MALE, "Ex Soldier", ProtagonistDescription.CLOUD, "Human", GameEdition.FINAL_FANTASY_VII, "https://static.wikia.nocookie.net/finalfantasy/images/e/ef/Cloud_Strife_from_FFVII_Remake_bust_render.png"),
				new Protagonist("Tifa", "Lockhart", Gender.FEMALE, "Avalanche Member", ProtagonistDescription.TIFA, "Human", GameEdition.FINAL_FANTASY_VII, "https://static.wikia.nocookie.net/finalfantasy/images/9/9c/Tifa_Lockhart_from_FFVII_Remake_promo_render.png"),
				new Protagonist("Barret", "Wallace", Gender.MALE, "Leader in Avalanche", ProtagonistDescription.BARRET, "Human", GameEdition.FINAL_FANTASY_VII, "https://static.wikia.nocookie.net/finalfantasy/images/a/a8/Barret_Wallace_from_FFVII_Remake_promo_render.png"),


		// PROTAGONIST - FINAL FANTASY 8 -----------------------//
				new Protagonist("Squall", "Leonheart", Gender.MALE, "Soldier", ProtagonistDescription.SQUALL, "Human", GameEdition.FINAL_FANTASY_VIII, "https://static.wikia.nocookie.net/finalfantasy/images/d/d2/Ff8-squall.jpg"),
				new Protagonist("Rinoa", "Heartilly", Gender.FEMALE,"Strategist",ProtagonistDescription.RINOA,"Human",GameEdition.FINAL_FANTASY_VIII, "https://static.wikia.nocookie.net/finalfantasy/images/0/09/Ff8-rinoa.jpg"),
				new Protagonist("Irvine", "Kinneas", Gender.MALE, "Mercenary", ProtagonistDescription.IRVINE,"Human", GameEdition.FINAL_FANTASY_VIII, "https://static.wikia.nocookie.net/finalfantasy/images/1/18/Ff8-irvine.jpg"),
				new Protagonist("Zell", "Dincht", Gender.MALE,"Mercenary", ProtagonistDescription.ZELL, "Human", GameEdition.FINAL_FANTASY_VIII, "https://static.wikia.nocookie.net/finalfantasy/images/7/75/Ff8-zell.jpg"),
				new Protagonist("Selphie", "Tilmitt", Gender.FEMALE,"Mercenary", ProtagonistDescription.SELPHIE, "Human", GameEdition.FINAL_FANTASY_VIII, "https://static.wikia.nocookie.net/finalfantasy/images/c/cd/Ff8-selphie.jpg"),
				new Protagonist("Quistis", "Trepe", Gender.FEMALE,"Instructor", ProtagonistDescription.QUISTIS, "Human", GameEdition.FINAL_FANTASY_VIII, "https://static.wikia.nocookie.net/finalfantasy/images/9/92/Ff8-quistis.jpg"),
				new Protagonist("Seifer", "Almasy", Gender.MALE, "Mercenary" , ProtagonistDescription.SEIFER, "Human", GameEdition.FINAL_FANTASY_VIII, "https://static.wikia.nocookie.net/finalfantasy/images/f/f7/Ff8-seifer.jpg"),
				new Protagonist("Edea", "Kramer", Gender.FEMALE,"Ambassador", ProtagonistDescription.EDEA, "Human", GameEdition.FINAL_FANTASY_VIII, "https://static.wikia.nocookie.net/finalfantasy/images/7/7f/Ff8-edea.jpg"),
				new Protagonist("Laguna", "Loire", Gender.MALE, "President of Esthar", ProtagonistDescription.LAGUNA, "Human", GameEdition.FINAL_FANTASY_VIII, "https://static.wikia.nocookie.net/finalfantasy/images/d/dc/Ff8-laguna.jpg"),
				new Protagonist("Kiros", "Seagill", Gender.MALE, "Soldier", ProtagonistDescription.KIROS, "Human", GameEdition.FINAL_FANTASY_VIII, "https://static.wikia.nocookie.net/finalfantasy/images/9/95/Kiros2.jpg"),
				new Protagonist("Ward", "Zabac", Gender.MALE,"Soldier", ProtagonistDescription.WARD, "Human", GameEdition.FINAL_FANTASY_VIII, "https://static.wikia.nocookie.net/finalfantasy/images/9/93/Ward.jpg"),
				new Protagonist("Adel","Unknown", Gender.FEMALE, "Sorceress", ProtagonistDescription.ADEL, "Human", GameEdition.FINAL_FANTASY_VIII, "https://vignette.wikia.nocookie.net/finalfantasy/images/a/af/Adel2.jpg"),
				new Protagonist("Ultimecia", "Unknown", Gender.FEMALE, "Sorceress", ProtagonistDescription.ULTIMECIA, "Human", GameEdition.FINAL_FANTASY_VIII, "https://www.heypoorplayer.com/wp-content/uploads/2017/08/Face_of_Sorceress_Ultimecia.jpg")
			);

			for (Protagonist protagonist : protagonistsList){
				protagonistRepository.save(protagonist);
			}

			for (Protagonist protagonist : protagonistsList){
				for(Game game : gamesList){
					if(game.getAvailableProtagonist().contains(protagonist.getName())){
						gameProtagonistRepository.save(new GameProtagonist(game, protagonist));
					}
				}
			}

	// GAME-PROTAGONIST -----------------------//
			/*GameProtagonist squallFF8 = new GameProtagonist(finalFantasyVIII, Squall);
			GameProtagonist zellFF8 = new GameProtagonist(finalFantasyVIII, Zell);
			GameProtagonist squallFFDisidia = new GameProtagonist(finalFantasyDissidia, Squall);*/


			/*List<GameProtagonist> gameProtagonistsDissidia = Arrays.asList(squallFF8, squallFFDisidia, zellFF8);*/

			/*for (GameProtagonist gameProtagonist : gameProtagonistsDissidia){
				gameProtagonistRepository.save(gameProtagonist);
			}*/

	// GAME-SUMMON -----------------------//
			List<GameSummon> gameSummonsFF8 = Arrays.asList(
				// Ramuh
				new GameSummon(gamesList.get(2), summonsList.get(1), SummonImage.IFRIT_IMG_FF3),
				new GameSummon(gamesList.get(2), summonsList.get(1), SummonImage.IFRIT_IMG_FF4),
				new GameSummon(gamesList.get(2), summonsList.get(1), SummonImage.IFRIT_IMG_FF5),
				new GameSummon(gamesList.get(2), summonsList.get(1), SummonImage.IFRIT_IMG_FF6),
				new GameSummon(gamesList.get(2), summonsList.get(1), SummonImage.IFRIT_IMG_FF7),
				new GameSummon(gamesList.get(2), summonsList.get(1), SummonImage.IFRIT_IMG_FF9),

				// Leviathan
				new GameSummon(gamesList.get(2), summonsList.get(17), SummonImage.IFRIT_IMG_FF3),
				new GameSummon(gamesList.get(2), summonsList.get(17), SummonImage.IFRIT_IMG_FF4),
				new GameSummon(gamesList.get(2), summonsList.get(17), SummonImage.IFRIT_IMG_FF5),
				new GameSummon(gamesList.get(2), summonsList.get(17), SummonImage.IFRIT_IMG_FF7),
				new GameSummon(gamesList.get(2), summonsList.get(17), SummonImage.IFRIT_IMG_FF8),
				new GameSummon(gamesList.get(2), summonsList.get(17), SummonImage.IFRIT_IMG_FF9),

				// Shiva
				new GameSummon(gamesList.get(2), summonsList.get(27), SummonImage.IFRIT_IMG_FF3),
				new GameSummon(gamesList.get(2), summonsList.get(27), SummonImage.IFRIT_IMG_FF4),
				new GameSummon(gamesList.get(2), summonsList.get(27), SummonImage.IFRIT_IMG_FF5),
				new GameSummon(gamesList.get(2), summonsList.get(27), SummonImage.IFRIT_IMG_FF6),
				new GameSummon(gamesList.get(2), summonsList.get(27), SummonImage.IFRIT_IMG_FF7),
				new GameSummon(gamesList.get(2), summonsList.get(27), SummonImage.IFRIT_IMG_FF8),
				new GameSummon(gamesList.get(2), summonsList.get(27), SummonImage.IFRIT_IMG_FF9),

				// Ifrit
				new GameSummon(gamesList.get(2), summonsList.get(26), SummonImage.IFRIT_IMG_FF3),
				new GameSummon(gamesList.get(2), summonsList.get(26), SummonImage.IFRIT_IMG_FF4),
				new GameSummon(gamesList.get(2), summonsList.get(26), SummonImage.IFRIT_IMG_FF5),
				new GameSummon(gamesList.get(2), summonsList.get(26), SummonImage.IFRIT_IMG_FF6),
				new GameSummon(gamesList.get(2), summonsList.get(26), SummonImage.IFRIT_IMG_FF7),
				new GameSummon(gamesList.get(2), summonsList.get(26), SummonImage.IFRIT_IMG_FF8),
				new GameSummon(gamesList.get(2), summonsList.get(26), SummonImage.IFRIT_IMG_FF9)
			);


			for (GameSummon gameSummon : gameSummonsFF8){
				 gameSummonRepository.save(gameSummon);
			}

	// LOCATIONS -----------------------//

			Set<LocationImage> locationImageSet = new HashSet<>();
			locationImageSet.add(LocationImage.FIRE_CAVERN_IMG);
			locationImageSet.add(LocationImage.FIRE_CAVERN_MAP);


			List<Location> locationListFF8 = Arrays.asList(
					new Location("Fire Cavern", GameEdition.FINAL_FANTASY_VIII, LocationDescription.FIRE_CAVERN, locationImageSet , gamesList.get(2) )
			);

			for (Location location : locationListFF8){
				locationRepository.save(location);
			}

		};

	}
}
