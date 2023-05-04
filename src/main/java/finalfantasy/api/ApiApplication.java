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

import java.util.*;
import java.util.stream.Collectors;

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


			/*List<Game> gamesList = Arrays.asList(
			new Game("Final Fantasy I", "31/12/1999", "https://th.bing.com/th/id/OIP.Pcp_rJhq2R0aQk7sPB8WVAHaF8?pid=ImgDet&rs=1", Plataform.SNES, GameDescription.FF_8_DESCRIPTION, AvailableProtagonists.EMPTY.getAvailableProtagonistList()),
			new Game("Final Fantasy II", "31/12/1999", "https://static.wikia.nocookie.net/finalfantasy/images/6/69/FFII_logo.png", Plataform.SNES, GameDescription.FF_8_DESCRIPTION, AvailableProtagonists.EMPTY.getAvailableProtagonistList()),
			new Game("Final Fantasy III", "31/12/1999", "", Plataform.SNES, GameDescription.FF_3_DESCRIPTION, AvailableProtagonists.EMPTY.getAvailableProtagonistList()),
			new Game("Final Fantasy IV", "31/12/1999", "", Plataform.SUPER_NES, GameDescription.FF_4_DESCRIPTION, AvailableProtagonists.EMPTY.getAvailableProtagonistList()),
			new Game("Final Fantasy IV, After Years", "31/12/1999", "", Plataform.SUPER_NES, GameDescription.FF_4_DESCRIPTION, AvailableProtagonists.EMPTY.getAvailableProtagonistList()),
			new Game("Final Fantasy V", "31/12/1999", "", Plataform.SUPER_NES, GameDescription.FF_5_DESCRIPTION, AvailableProtagonists.EMPTY.getAvailableProtagonistList()),
			new Game("Final Fantasy VI", "31/12/1999", "", Plataform.SUPER_NES, GameDescription.FF_6_DESCRIPTION, AvailableProtagonists.EMPTY.getAvailableProtagonistList()),
			new Game("Final Fantasy VII", "31/12/1999", "", Plataform.PLAYSTATION, GameDescription.FF_7_DESCRIPTION, AvailableProtagonists.FF7.getAvailableProtagonistList()),
			new Game("Final Fantasy VII, Before Crisis", "31/12/1999", "", Plataform.MOBIL_PHONE, GameDescription.FF_7_DESCRIPTION, AvailableProtagonists.EMPTY.getAvailableProtagonistList()),
			new Game("Final Fantasy VII, Dirge of Cerberus", "31/12/1999", "", Plataform.PLAYSTATION_2, GameDescription.FF_7_DESCRIPTION, AvailableProtagonists.EMPTY.getAvailableProtagonistList()),
			new Game("Final Fantasy VII, Crisis Core", "31/12/1999", "", Plataform.PSP, GameDescription.FF_7_DESCRIPTION, AvailableProtagonists.EMPTY.getAvailableProtagonistList()),
			new Game("Final Fantasy VIII", "31/12/1999", "", Plataform.PLAYSTATION, GameDescription.FF_8_DESCRIPTION, AvailableProtagonists.FF8.getAvailableProtagonistList()),
			new Game("Final Fantasy IX", "31/12/1999", "", Plataform.PLAYSTATION, GameDescription.FF_9_DESCRIPTION, AvailableProtagonists.EMPTY.getAvailableProtagonistList()),
			new Game("Final Fantasy X", "31/12/1999", "", Plataform.PLAYSTATION_2, GameDescription.FF_10_DESCRIPTION, AvailableProtagonists.EMPTY.getAvailableProtagonistList()),
			new Game("Final Fantasy X-2", "31/12/1999", "", Plataform.PLAYSTATION_2, GameDescription.FF_10_2DESCRIPTION, AvailableProtagonists.EMPTY.getAvailableProtagonistList()),
			new Game("Final Fantasy XII", "31/12/1999", "h", Plataform.PLAYSTATION_2, GameDescription.FF_12_DESCRIPTION, AvailableProtagonists.EMPTY.getAvailableProtagonistList()),
			new Game("Final Fantasy XIII", "31/12/1999", "", Plataform.PLAYSTATION_3, GameDescription.FF_13_DESCRIPTION, AvailableProtagonists.EMPTY.getAvailableProtagonistList()),
			new Game("Final Fantasy XIII-2", "31/12/1999", "", Plataform.PLAYSTATION_3, GameDescription.FF_13_DESCRIPTION, AvailableProtagonists.EMPTY.getAvailableProtagonistList()),
			new Game("Final Fantasy XIII, Lightning Returns", "31/12/1999", "", Plataform.PLAYSTATION_3, GameDescription.FF_13_DESCRIPTION, AvailableProtagonists.EMPTY.getAvailableProtagonistList()),
			new Game("Final Fantasy XV", "31/12/1999", "", Plataform.PLAYSTATION_4, GameDescription.FF_15_DESCRIPTION, AvailableProtagonists.EMPTY.getAvailableProtagonistList()),
			new Game("Final Fantasy Dissidia", "1/2/2017", "https://static.wikia.nocookie.net/finalfantasy/images/b/b6/Dissidia_Logo.jpg", Plataform.PSP, GameDescription.FF_DISSIDIA, AvailableProtagonists.EMPTY.getAvailableProtagonistList()),
			new Game("Final Fantasy Type-0", "31/12/1999", "", Plataform.PLAYSTATION_4, GameDescription.FF_7_DESCRIPTION, AvailableProtagonists.EMPTY.getAvailableProtagonistList())
			);*/

			/*for(Game game : gamesList){
				gameRepository.save(game);
			}*/



			/*for (Protagonist protagonist : protagonistsList){
				for(Game game : gamesList){
					if(game.getAvailableProtagonistList().contains(protagonist.getName())){
						if(
								!(gameProtagonistRepository.findAll().stream().map(gameProtagonist ->
										gameProtagonist.getProtagonist().getLastName()).collect(Collectors.toList())).contains(protagonist.getLastName())
								/*&&!(gameProtagonistRepository.findAll().stream().map(gameProtagonist ->
										gameProtagonist.getGame().getId()).collect(Collectors.toList())).contains( game.getId() )*/
						/*){
							gameProtagonistRepository.save(new GameProtagonist(game, protagonist));
						}
					}

				}
			}*/

	// GAME-PROTAGONIST -----------------------//
			/*GameProtagonist squallFF8 = new GameProtagonist(gamesList.get(2), protagonistsList.get(2));
			GameProtagonist zellFF8 = new GameProtagonist(gamesList.get(3), protagonistsList.get(3));
			GameProtagonist squallFFDisidia = new GameProtagonist(gamesList.get(4), protagonistsList.get(4));*/


			/*List<GameProtagonist> gameProtagonistsDissidia = Arrays.asList(squallFF8, squallFFDisidia, zellFF8);

			for (GameProtagonist gameProtagonist : gameProtagonistsDissidia){
				gameProtagonistRepository.save(gameProtagonist);
			}*/

	// GAME-SUMMON -----------------------//
			/*List<GameSummon> gameSummonsFF8 = Arrays.asList(
				// Ramuh
				new GameSummon(gamesList.get(2), summonsList.get(1), SummonImage.IFRIT_IMG_FF3),
				new GameSummon(gamesList.get(3), summonsList.get(1), SummonImage.IFRIT_IMG_FF4),
				new GameSummon(gamesList.get(4), summonsList.get(1), SummonImage.IFRIT_IMG_FF5),
				new GameSummon(gamesList.get(5), summonsList.get(1), SummonImage.IFRIT_IMG_FF6),
				new GameSummon(gamesList.get(6), summonsList.get(1), SummonImage.IFRIT_IMG_FF7),
				new GameSummon(gamesList.get(7), summonsList.get(1), SummonImage.IFRIT_IMG_FF9),

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
			}*/

	// LOCATIONS -----------------------//

			/*Set<LocationImage> locationImageSet = new HashSet<>();
			locationImageSet.add(LocationImage.FIRE_CAVERN_IMG);
			locationImageSet.add(LocationImage.FIRE_CAVERN_MAP);


			List<Location> locationListFF8 = Arrays.asList(
					new Location("Fire Cavern", GameEdition.FINAL_FANTASY_VIII, LocationDescription.FIRE_CAVERN, locationImageSet , gamesList.get(2) )
			);

			for (Location location : locationListFF8){
				locationRepository.save(location);
			}*/

		};

	}
}
