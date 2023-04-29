package finalfantasy.api;

import finalfantasy.api.enums.GameEdition;
import finalfantasy.api.enums.Gender;
import finalfantasy.api.models.Game;
import finalfantasy.api.models.GameDescription;
import finalfantasy.api.models.Protagonist;
import finalfantasy.api.models.ProtagonistDescription;
import finalfantasy.api.repositories.GameRepository;
import finalfantasy.api.repositories.ProtagonistRepository;
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
	public CommandLineRunner initData(ProtagonistRepository protagonistRepository, GameRepository gameRepository){
		return (args) -> {

			System.out.println("------------------");
			System.out.println("Magic has started!");
			System.out.println("------------------");


			Game finalFantasyVIII = new Game("Final Fantasy VIII", "31/12/1999", "https://th.bing.com/th/id/OIP.Pcp_rJhq2R0aQk7sPB8WVAHaF8?pid=ImgDet&rs=1", "Playstation", GameDescription.FF8 );
			gameRepository.save(finalFantasyVIII);


			// FINAL FANTASY 7 -----------------------//
			/*Protagonist Cloud = new Protagonist("Cloud Strife", Gender.MALE, "Ex Soldier", ProtagonistDescription.CLOUD, "Human", GameEdition.FINAL_FANTASY_VIII, "https://static.wikia.nocookie.net/finalfantasy/images/e/ef/Cloud_Strife_from_FFVII_Remake_bust_render.png", Game.);*/

			// FINAL FANTASY 8 -----------------------//
			Protagonist Squall = new Protagonist("Squall Leonheart", Gender.MALE, "Soldier", ProtagonistDescription.SQUALL, "Human", GameEdition.FINAL_FANTASY_VIII, "https://static.wikia.nocookie.net/finalfantasy/images/d/d2/Ff8-squall.jpg", finalFantasyVIII);
			Protagonist Rinoa = new Protagonist("Rinoa Heartilly",Gender.FEMALE,"Strategist",ProtagonistDescription.RINOA,"Human",GameEdition.FINAL_FANTASY_VIII, "https://static.wikia.nocookie.net/finalfantasy/images/0/09/Ff8-rinoa.jpg", finalFantasyVIII);
			Protagonist Irvine = new Protagonist("Irvine Kinneas",Gender.MALE, "Mercenary", ProtagonistDescription.IRVINE,"Human", GameEdition.FINAL_FANTASY_VIII, "https://static.wikia.nocookie.net/finalfantasy/images/1/18/Ff8-irvine.jpg", finalFantasyVIII);
			Protagonist Zell = new Protagonist("Zell Dincht",Gender.MALE,"Mercenary", ProtagonistDescription.ZELL, "Human", GameEdition.FINAL_FANTASY_VIII, "https://static.wikia.nocookie.net/finalfantasy/images/7/75/Ff8-zell.jpg", finalFantasyVIII);
			Protagonist Selphie = new Protagonist("Selphie Tilmitt",Gender.FEMALE,"Mercenary", ProtagonistDescription.SELPHIE, "Human", GameEdition.FINAL_FANTASY_VIII, "https://static.wikia.nocookie.net/finalfantasy/images/c/cd/Ff8-selphie.jpg", finalFantasyVIII);
			Protagonist Quistis = new Protagonist("Quistis Trepe",Gender.FEMALE,"Instructor", ProtagonistDescription.QUISTIS, "Human", GameEdition.FINAL_FANTASY_VIII, "https://static.wikia.nocookie.net/finalfantasy/images/9/92/Ff8-quistis.jpg", finalFantasyVIII);
			Protagonist Seifer = new Protagonist("Seifer Almasy",Gender.MALE, "Mercenary" , ProtagonistDescription.SEIFER, "Human", GameEdition.FINAL_FANTASY_VIII, "https://static.wikia.nocookie.net/finalfantasy/images/f/f7/Ff8-seifer.jpg", finalFantasyVIII);
			Protagonist Edea = new Protagonist("Edea Kramer", Gender.FEMALE,"Ambassador", ProtagonistDescription.EDEA, "Human", GameEdition.FINAL_FANTASY_VIII, "https://static.wikia.nocookie.net/finalfantasy/images/7/7f/Ff8-edea.jpg", finalFantasyVIII);
			Protagonist Laguna = new Protagonist("Laguna Loire",Gender.MALE, "President of Esthar", ProtagonistDescription.LAGUNA, "Human", GameEdition.FINAL_FANTASY_VIII, "https://static.wikia.nocookie.net/finalfantasy/images/d/dc/Ff8-laguna.jpg", finalFantasyVIII);
			Protagonist Kiros = new Protagonist("Kiros Seagill",Gender.MALE, "Soldier", ProtagonistDescription.KIROS, "Human", GameEdition.FINAL_FANTASY_VIII, "https://static.wikia.nocookie.net/finalfantasy/images/9/95/Kiros2.jpg", finalFantasyVIII);
			Protagonist Ward = new Protagonist("Ward Zabac",Gender.MALE,"Soldier", ProtagonistDescription.WARD, "Human", GameEdition.FINAL_FANTASY_VIII, "https://static.wikia.nocookie.net/finalfantasy/images/9/93/Ward.jpg", finalFantasyVIII);
			Protagonist Adel = new Protagonist("Adel", Gender.FEMALE, "Sorceress", ProtagonistDescription.ADEL, "Human", GameEdition.FINAL_FANTASY_VIII, "https://vignette.wikia.nocookie.net/finalfantasy/images/a/af/Adel2.jpg", finalFantasyVIII);
			Protagonist Ultimecia = new Protagonist("Ultimecia", Gender.FEMALE, "Sorceress", ProtagonistDescription.ULTIMECIA, "Human", GameEdition.FINAL_FANTASY_VIII, "https://www.heypoorplayer.com/wp-content/uploads/2017/08/Face_of_Sorceress_Ultimecia.jpg", finalFantasyVIII);

			List<Protagonist> protagonists = Arrays.asList(Squall, Zell, Irvine, Seifer, Laguna, Ward, Kiros, Rinoa, Selphie, Edea, Adel, Ultimecia, Quistis);

			for (Protagonist protagonist : protagonists){
				protagonistRepository.save(protagonist);
			}

		};

	}
}
