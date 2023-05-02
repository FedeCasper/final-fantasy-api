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
									  SummonRepository summonRepository, LocationRepository locationRepository){
		return (args) -> {

			System.out.println("------------------");
			System.out.println("Magic has started!");
			System.out.println("------------------");


	// GAMES -----------------------//
			Game finalFantasyI = new Game("Final Fantasy I", "31/12/1999", "https://th.bing.com/th/id/OIP.Pcp_rJhq2R0aQk7sPB8WVAHaF8?pid=ImgDet&rs=1", "Playstation", GameDescription.FF_8_DESCRIPTION);
			Game finalFantasyII = new Game("Final Fantasy II", "31/12/1999", "https://static.wikia.nocookie.net/finalfantasy/images/6/69/FFII_logo.png", "Playstation", GameDescription.FF_8_DESCRIPTION);
			Game finalFantasyIII = new Game("Final Fantasy III", "31/12/1999", "", "Playstation", GameDescription.FF_3_DESCRIPTION);
			Game finalFantasyIV = new Game("Final Fantasy IV", "31/12/1999", "", "Playstation", GameDescription.FF_4_DESCRIPTION);
			Game finalFantasyV = new Game("Final Fantasy V", "31/12/1999", "", "Playstation", GameDescription.FF_5_DESCRIPTION);
			Game finalFantasyVI = new Game("Final Fantasy VI", "31/12/1999", "", "Playstation", GameDescription.FF_6_DESCRIPTION);
			Game finalFantasyVII = new Game("Final Fantasy VII", "31/12/1999", "", "Playstation", GameDescription.FF_7_DESCRIPTION);
			Game finalFantasyVIII = new Game("Final Fantasy VIII", "31/12/1999", "", "Playstation", GameDescription.FF_8_DESCRIPTION);
			Game finalFantasyIX = new Game("Final Fantasy IX", "31/12/1999", "", "Playstation", GameDescription.FF_9_DESCRIPTION);
			Game finalFantasyX = new Game("Final Fantasy X", "31/12/1999", "", "Playstation", GameDescription.FF_10_DESCRIPTION);
			Game finalFantasyX2 = new Game("Final Fantasy X-2", "31/12/1999", "", "Playstation", GameDescription.FF_10_2DESCRIPTION);
			Game finalFantasyXII = new Game("Final Fantasy XII", "31/12/1999", "h", "Playstation", GameDescription.FF_12_DESCRIPTION);
			Game finalFantasyXIII = new Game("Final Fantasy XIII", "31/12/1999", "", "Playstation", GameDescription.FF_13_DESCRIPTION);
			Game finalFantasyXV = new Game("Final Fantasy XV", "31/12/1999", "", "Playstation", GameDescription.FF_15_DESCRIPTION);
			Game finalFantasyDissidia = new Game("Final Fantasy Dissidia", "1/2/2017", "https://static.wikia.nocookie.net/finalfantasy/images/b/b6/Dissidia_Logo.jpg", "Playstation", GameDescription.FF_DISSIDIA);

			List<Game> games = Arrays.asList(finalFantasyI, finalFantasyII, finalFantasyIII, finalFantasyIV, finalFantasyV, finalFantasyVI, finalFantasyVII, finalFantasyVIII, finalFantasyIX, finalFantasyX, finalFantasyX2, finalFantasyXII, finalFantasyXIII, finalFantasyXV, finalFantasyDissidia);

			for(Game game : games){
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

	// PROTAGONIST - FINAL FANTASY 7 -----------------------//
			Protagonist Cloud = new Protagonist("Cloud", "Strife", Gender.MALE, "Ex Soldier", ProtagonistDescription.CLOUD, "Human", GameEdition.FINAL_FANTASY_VIII, "https://static.wikia.nocookie.net/finalfantasy/images/e/ef/Cloud_Strife_from_FFVII_Remake_bust_render.png");

	// PROTAGONIST - FINAL FANTASY 8 -----------------------//
			Protagonist Squall = new Protagonist("Squall", "Leonheart", Gender.MALE, "Soldier", ProtagonistDescription.SQUALL, "Human", GameEdition.FINAL_FANTASY_VIII, "https://static.wikia.nocookie.net/finalfantasy/images/d/d2/Ff8-squall.jpg");
			Protagonist Rinoa = new Protagonist("Rinoa", "Heartilly", Gender.FEMALE,"Strategist",ProtagonistDescription.RINOA,"Human",GameEdition.FINAL_FANTASY_VIII, "https://static.wikia.nocookie.net/finalfantasy/images/0/09/Ff8-rinoa.jpg");
			Protagonist Irvine = new Protagonist("Irvine", "Kinneas", Gender.MALE, "Mercenary", ProtagonistDescription.IRVINE,"Human", GameEdition.FINAL_FANTASY_VIII, "https://static.wikia.nocookie.net/finalfantasy/images/1/18/Ff8-irvine.jpg");
			Protagonist Zell = new Protagonist("Zell", "Dincht", Gender.MALE,"Mercenary", ProtagonistDescription.ZELL, "Human", GameEdition.FINAL_FANTASY_VIII, "https://static.wikia.nocookie.net/finalfantasy/images/7/75/Ff8-zell.jpg");
			Protagonist Selphie = new Protagonist("Selphie", "Tilmitt", Gender.FEMALE,"Mercenary", ProtagonistDescription.SELPHIE, "Human", GameEdition.FINAL_FANTASY_VIII, "https://static.wikia.nocookie.net/finalfantasy/images/c/cd/Ff8-selphie.jpg");
			Protagonist Quistis = new Protagonist("Quistis", "Trepe", Gender.FEMALE,"Instructor", ProtagonistDescription.QUISTIS, "Human", GameEdition.FINAL_FANTASY_VIII, "https://static.wikia.nocookie.net/finalfantasy/images/9/92/Ff8-quistis.jpg");
			Protagonist Seifer = new Protagonist("Seifer", "Almasy", Gender.MALE, "Mercenary" , ProtagonistDescription.SEIFER, "Human", GameEdition.FINAL_FANTASY_VIII, "https://static.wikia.nocookie.net/finalfantasy/images/f/f7/Ff8-seifer.jpg");
			Protagonist Edea = new Protagonist("Edea", "Kramer", Gender.FEMALE,"Ambassador", ProtagonistDescription.EDEA, "Human", GameEdition.FINAL_FANTASY_VIII, "https://static.wikia.nocookie.net/finalfantasy/images/7/7f/Ff8-edea.jpg");
			Protagonist Laguna = new Protagonist("Laguna", "Loire", Gender.MALE, "President of Esthar", ProtagonistDescription.LAGUNA, "Human", GameEdition.FINAL_FANTASY_VIII, "https://static.wikia.nocookie.net/finalfantasy/images/d/dc/Ff8-laguna.jpg");
			Protagonist Kiros = new Protagonist("Kiros", "Seagill", Gender.MALE, "Soldier", ProtagonistDescription.KIROS, "Human", GameEdition.FINAL_FANTASY_VIII, "https://static.wikia.nocookie.net/finalfantasy/images/9/95/Kiros2.jpg");
			Protagonist Ward = new Protagonist("Ward", "Zabac", Gender.MALE,"Soldier", ProtagonistDescription.WARD, "Human", GameEdition.FINAL_FANTASY_VIII, "https://static.wikia.nocookie.net/finalfantasy/images/9/93/Ward.jpg");
			Protagonist Adel = new Protagonist("Adel","Unknown", Gender.FEMALE, "Sorceress", ProtagonistDescription.ADEL, "Human", GameEdition.FINAL_FANTASY_VIII, "https://vignette.wikia.nocookie.net/finalfantasy/images/a/af/Adel2.jpg");
			Protagonist Ultimecia = new Protagonist("Ultimecia", "Unknown", Gender.FEMALE, "Sorceress", ProtagonistDescription.ULTIMECIA, "Human", GameEdition.FINAL_FANTASY_VIII, "https://www.heypoorplayer.com/wp-content/uploads/2017/08/Face_of_Sorceress_Ultimecia.jpg");

			List<Protagonist> protagonistsFF7 = Arrays.asList(Cloud);
			List<Protagonist> protagonistsFF8 = Arrays.asList(Squall, Zell, Irvine, Seifer, Laguna, Ward, Kiros, Rinoa, Selphie, Edea, Adel, Ultimecia, Quistis);

			for (Protagonist protagonist : protagonistsFF8){
				protagonistRepository.save(protagonist);
			}

	// GAME-PROTAGONIST -----------------------//
			GameProtagonist squallFF8 = new GameProtagonist(finalFantasyVIII, Squall);
			GameProtagonist zellFF8 = new GameProtagonist(finalFantasyVIII, Zell);
			GameProtagonist squallFFDisidia = new GameProtagonist(finalFantasyDissidia, Squall);


			List<GameProtagonist> gameProtagonistsDissidia = Arrays.asList(squallFF8, squallFFDisidia, zellFF8);

			for (GameProtagonist gameProtagonist : gameProtagonistsDissidia){
				gameProtagonistRepository.save(gameProtagonist);
			}

	// GAME-SUMMON -----------------------//
			List<GameSummon> gameSummonsFF8 = Arrays.asList(
				// Ramuh
				new GameSummon(finalFantasyIII, summonsList.get(1), SummonImage.IFRIT_IMG_FF3),
				new GameSummon(finalFantasyIV, summonsList.get(1), SummonImage.IFRIT_IMG_FF4),
				new GameSummon(finalFantasyV, summonsList.get(1), SummonImage.IFRIT_IMG_FF5),
				new GameSummon(finalFantasyVI, summonsList.get(1), SummonImage.IFRIT_IMG_FF6),
				new GameSummon(finalFantasyVII, summonsList.get(1), SummonImage.IFRIT_IMG_FF7),
				new GameSummon(finalFantasyIX, summonsList.get(1), SummonImage.IFRIT_IMG_FF9),

				// Leviathan
				new GameSummon(finalFantasyIII, summonsList.get(17), SummonImage.IFRIT_IMG_FF3),
				new GameSummon(finalFantasyIV, summonsList.get(17), SummonImage.IFRIT_IMG_FF4),
				new GameSummon(finalFantasyV, summonsList.get(17), SummonImage.IFRIT_IMG_FF5),
				new GameSummon(finalFantasyVII, summonsList.get(17), SummonImage.IFRIT_IMG_FF7),
				new GameSummon(finalFantasyVIII, summonsList.get(17), SummonImage.IFRIT_IMG_FF8),
				new GameSummon(finalFantasyIX, summonsList.get(17), SummonImage.IFRIT_IMG_FF9),

				// Shiva
				new GameSummon(finalFantasyIII, summonsList.get(27), SummonImage.IFRIT_IMG_FF3),
				new GameSummon(finalFantasyIV, summonsList.get(27), SummonImage.IFRIT_IMG_FF4),
				new GameSummon(finalFantasyV, summonsList.get(27), SummonImage.IFRIT_IMG_FF5),
				new GameSummon(finalFantasyVI, summonsList.get(27), SummonImage.IFRIT_IMG_FF6),
				new GameSummon(finalFantasyVII, summonsList.get(27), SummonImage.IFRIT_IMG_FF7),
				new GameSummon(finalFantasyVIII, summonsList.get(27), SummonImage.IFRIT_IMG_FF8),
				new GameSummon(finalFantasyIX, summonsList.get(27), SummonImage.IFRIT_IMG_FF9),

				// Ifrit
				new GameSummon(finalFantasyIII, summonsList.get(26), SummonImage.IFRIT_IMG_FF3),
				new GameSummon(finalFantasyIV, summonsList.get(26), SummonImage.IFRIT_IMG_FF4),
				new GameSummon(finalFantasyV, summonsList.get(26), SummonImage.IFRIT_IMG_FF5),
				new GameSummon(finalFantasyVI, summonsList.get(26), SummonImage.IFRIT_IMG_FF6),
				new GameSummon(finalFantasyVII, summonsList.get(26), SummonImage.IFRIT_IMG_FF7),
				new GameSummon(finalFantasyVIII, summonsList.get(26), SummonImage.IFRIT_IMG_FF8),
				new GameSummon(finalFantasyIX, summonsList.get(26), SummonImage.IFRIT_IMG_FF9)
			);


			for (GameSummon gameSummon : gameSummonsFF8){
				 gameSummonRepository.save(gameSummon);
			}

	// LOCATIONS -----------------------//

			Set<LocationImage> locationImageSet = new HashSet<>();
			locationImageSet.add(LocationImage.FIRE_CAVERN_IMG);
			locationImageSet.add(LocationImage.FIRE_CAVERN_MAP);


			List<Location> locationListFF8 = Arrays.asList(
					new Location("Fire Cavern", GameEdition.FINAL_FANTASY_VIII, LocationDescription.FIRE_CAVERN, locationImageSet , finalFantasyVIII )
			);

			for (Location location : locationListFF8){
				locationRepository.save(location);
			}

		};

	}
}
