package finalfantasy.api;

import finalfantasy.api.IntermediateTables.GameProtagonist;
import finalfantasy.api.IntermediateTables.GameSummon;
import finalfantasy.api.dto.GameDto;
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

			ArrayList<String> miArrayList = new ArrayList<>();
			miArrayList.add("Jo");
			ArrayList<String> miArrayList2 = new ArrayList<>();
			miArrayList2.add("Jo");

			Game game1 = new Game("FF1", "FF2", "FF", "ss", "s", miArrayList, miArrayList2);
			Protagonist protagonist = new Protagonist("j", "s", "s","f","d","d", GameEdition.FINAL_FANTASY_I, "s");
			Summon summon = new Summon("p", SummonType.EARTH);

			GameDto gameDto = new GameDto(game1);

			System.out.println(gameDto);

		};

	}
}
