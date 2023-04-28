package finalfantasy.api;

import finalfantasy.api.enums.GameEdition;
import finalfantasy.api.models.Protagonist;
import finalfantasy.api.models.ProtagonistDescription;
import finalfantasy.api.repositories.ProtagonistRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(ProtagonistRepository protagonistRepository){
		return (args) -> {

			System.out.println("------------------");
			System.out.println("Magic has started!");
			System.out.println("------------------");

			Protagonist Squall = new Protagonist("Squall Leonheart", "Male", "Soldier", ProtagonistDescription.SQUALL, "Human", GameEdition.FINAL_FANTASY_VIII, "https://static.wikia.nocookie.net/finalfantasy/images/d/d2/Ff8-squall.jpg/revision/latest?cb=20100603174959");
			Protagonist Rinoa = new Protagonist("Rinoa Heartilly","Female","Strategist",ProtagonistDescription.RINOA,"Human",GameEdition.FINAL_FANTASY_VIII, "https://static.wikia.nocookie.net/finalfantasy/images/0/09/Ff8-rinoa.jpg/revision/latest?cb=20100603174143");
			Protagonist Irvine = new Protagonist("Irvine Kinneas","Male", "Mercenary", ProtagonistDescription.IRVINE,"Human", GameEdition.FINAL_FANTASY_VIII, "https://static.wikia.nocookie.net/finalfantasy/images/1/18/Ff8-irvine.jpg/revision/latest?cb=20100603174532");
			Protagonist Zell = new Protagonist("Zell Dincht","Male","Mercenary", ProtagonistDescription.ZELL, "Human", GameEdition.FINAL_FANTASY_VIII, "https://static.wikia.nocookie.net/finalfantasy/images/7/75/Ff8-zell.jpg/revision/latest?cb=20100603174414");
			Protagonist Selphie = new Protagonist("Selphie Tilmitt","Female","Mercenary", ProtagonistDescription.SELPHIE, "Human", GameEdition.FINAL_FANTASY_VIII, "https://static.wikia.nocookie.net/finalfantasy/images/c/cd/Ff8-selphie.jpg/revision/latest?cb=20100603174301");
			Protagonist Quistis = new Protagonist("Quistis Trepe","Female","Instructor", ProtagonistDescription.QUISTIS, "Human", GameEdition.FINAL_FANTASY_VIII, "https://static.wikia.nocookie.net/finalfantasy/images/9/92/Ff8-quistis.jpg/revision/latest?cb=20100603174004");
			Protagonist Seifer = new Protagonist("Seifer Almasy","Male", "Mercenary" , ProtagonistDescription.SEIFER, "Human", GameEdition.FINAL_FANTASY_VIII, "https://static.wikia.nocookie.net/finalfantasy/images/f/f7/Ff8-seifer.jpg/revision/latest?cb=20100603174847");
			Protagonist Edea = new Protagonist("Edea Kramer", "Female","Ambassador", ProtagonistDescription.EDEA, "Human", GameEdition.FINAL_FANTASY_VIII, "https://static.wikia.nocookie.net/finalfantasy/images/7/7f/Ff8-edea.jpg/revision/latest?cb=20100603175032");
			Protagonist Laguna = new Protagonist("Laguna Loire","Male", "President of Esthar", ProtagonistDescription.LAGUNA, "Human", GameEdition.FINAL_FANTASY_VIII, "https://static.wikia.nocookie.net/finalfantasy/images/d/dc/Ff8-laguna.jpg/revision/latest?cb=20130303065543");
			Protagonist Kiros = new Protagonist("Kiros Seagill","Male", "Soldier", ProtagonistDescription.KIROS, "Human", GameEdition.FINAL_FANTASY_VIII, "https://static.wikia.nocookie.net/finalfantasy/images/9/95/Kiros2.jpg/revision/latest?cb=20100603174718");
			Protagonist Ward = new Protagonist("Ward Zabac","Male","Soldier", ProtagonistDescription.WARD, "Human", GameEdition.FINAL_FANTASY_VIII, "https://static.wikia.nocookie.net/finalfantasy/images/9/93/Ward.jpg/revision/latest?cb=20100603174811");

			Protagonist[] arrayProtagonist = {Squall, Rinoa, Irvine, Zell, Selphie, Quistis, Seifer, Edea, Laguna, Kiros, Ward};

			for(int i = 0 ; i < arrayProtagonist.length ; i++){
				protagonistRepository.save(arrayProtagonist[i]);
			}

		};

	}
}
