package finalfantasy.api;

import finalfantasy.api.models.Protagonist;
import finalfantasy.api.repositories.ProtagonistRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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

			Protagonist protagonistSquall = new Protagonist("Squall Lionheart", "Man", "Soldier","lalala","Human","Final Fantasy VIII");
			protagonistRepository.save(protagonistSquall);

		};

	}
}
