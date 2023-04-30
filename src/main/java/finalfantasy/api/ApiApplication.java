package finalfantasy.api;

import finalfantasy.api.IntermediateTables.GameProtagonist;
import finalfantasy.api.IntermediateTables.GameSummon;
import finalfantasy.api.enums.GameEdition;
import finalfantasy.api.enums.Gender;
import finalfantasy.api.enums.SummonType;
import finalfantasy.api.models.*;
import finalfantasy.api.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(ProtagonistRepository protagonistRepository, GameRepository gameRepository,
									  GameProtagonistRepository gameProtagonistRepository, GameSummonRepository gameSummonRepository,
									  SummonRepository summonRepository){
		return (args) -> {

			System.out.println("------------------");
			System.out.println("Magic has started!");
			System.out.println("------------------");


	// GAMES -----------------------//
			Game finalFantasyI = new Game("Final Fantasy I", "31/12/1999", "https://th.bing.com/th/id/OIP.Pcp_rJhq2R0aQk7sPB8WVAHaF8?pid=ImgDet&rs=1", "Playstation", GameDescription.FF_8);
			Game finalFantasyII = new Game("Final Fantasy II", "31/12/1999", "https://th.bing.com/th/id/OIP.Pcp_rJhq2R0aQk7sPB8WVAHaF8?pid=ImgDet&rs=1", "Playstation", GameDescription.FF_8);
			Game finalFantasyIII = new Game("Final Fantasy III", "31/12/1999", "https://th.bing.com/th/id/OIP.Pcp_rJhq2R0aQk7sPB8WVAHaF8?pid=ImgDet&rs=1", "Playstation", GameDescription.FF_8);
			Game finalFantasyIV = new Game("Final Fantasy IV", "31/12/1999", "https://th.bing.com/th/id/OIP.Pcp_rJhq2R0aQk7sPB8WVAHaF8?pid=ImgDet&rs=1", "Playstation", GameDescription.FF_8);
			Game finalFantasyV = new Game("Final Fantasy V", "31/12/1999", "https://th.bing.com/th/id/OIP.Pcp_rJhq2R0aQk7sPB8WVAHaF8?pid=ImgDet&rs=1", "Playstation", GameDescription.FF_8);
			Game finalFantasyVI = new Game("Final Fantasy VI", "31/12/1999", "https://th.bing.com/th/id/OIP.Pcp_rJhq2R0aQk7sPB8WVAHaF8?pid=ImgDet&rs=1", "Playstation", GameDescription.FF_8);
			Game finalFantasyVII = new Game("Final Fantasy VII", "31/12/1999", "https://th.bing.com/th/id/OIP.Pcp_rJhq2R0aQk7sPB8WVAHaF8?pid=ImgDet&rs=1", "Playstation", GameDescription.FF_8);
			Game finalFantasyVIII = new Game("Final Fantasy VIII", "31/12/1999", "https://th.bing.com/th/id/OIP.Pcp_rJhq2R0aQk7sPB8WVAHaF8?pid=ImgDet&rs=1", "Playstation", GameDescription.FF_8 );
			Game finalFantasyIX = new Game("Final Fantasy IX", "31/12/1999", "https://th.bing.com/th/id/OIP.Pcp_rJhq2R0aQk7sPB8WVAHaF8?pid=ImgDet&rs=1", "Playstation", GameDescription.FF_8);
			Game finalFantasyX = new Game("Final Fantasy X", "31/12/1999", "https://th.bing.com/th/id/OIP.Pcp_rJhq2R0aQk7sPB8WVAHaF8?pid=ImgDet&rs=1", "Playstation", GameDescription.FF_8);
			Game finalFantasyX2 = new Game("Final Fantasy X-2", "31/12/1999", "https://th.bing.com/th/id/OIP.Pcp_rJhq2R0aQk7sPB8WVAHaF8?pid=ImgDet&rs=1", "Playstation", GameDescription.FF_8);
			Game finalFantasyXII = new Game("Final Fantasy XII", "31/12/1999", "https://th.bing.com/th/id/OIP.Pcp_rJhq2R0aQk7sPB8WVAHaF8?pid=ImgDet&rs=1", "Playstation", GameDescription.FF_8);
			Game finalFantasyXIII = new Game("Final Fantasy XIII", "31/12/1999", "https://th.bing.com/th/id/OIP.Pcp_rJhq2R0aQk7sPB8WVAHaF8?pid=ImgDet&rs=1", "Playstation", GameDescription.FF_8);
			Game finalFantasyXV = new Game("Final Fantasy XV", "31/12/1999", "https://th.bing.com/th/id/OIP.Pcp_rJhq2R0aQk7sPB8WVAHaF8?pid=ImgDet&rs=1", "Playstation", GameDescription.FF_8);
			Game finalFantasyDissidia = new Game("Final Fantasy Dissidia", "1/2/2017", "https://static.wikia.nocookie.net/finalfantasy/images/b/b6/Dissidia_Logo.jpg", "Playstation", GameDescription.FF_DISSIDIA);

			List<Game> games = Arrays.asList(finalFantasyI, finalFantasyII, finalFantasyIII, finalFantasyIV, finalFantasyV, finalFantasyVI, finalFantasyVII, finalFantasyVIII, finalFantasyIX, finalFantasyX, finalFantasyX2, finalFantasyXII, finalFantasyXIII, finalFantasyXV, finalFantasyDissidia);

			for(Game game : games){
				gameRepository.save(game);
			}

	// SUMMON - FINAL FANTASY 8 -----------------------//
			Summon ifrit = new Summon("Ifrit", GameEdition.FINAL_FANTASY_VIII, SummonType.FIRE);
			summonRepository.save(ifrit);

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
			GameSummon ifritFF8 = new GameSummon(finalFantasyVIII, ifrit);

			List<GameSummon> gameSummonsFF8 = Arrays.asList(ifritFF8);

			for (GameSummon gameSummon : gameSummonsFF8){
				 gameSummonRepository.save(gameSummon);
			}

		};

	}
}
