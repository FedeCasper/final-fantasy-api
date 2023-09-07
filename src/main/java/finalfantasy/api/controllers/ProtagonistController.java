package finalfantasy.api.controllers;

import finalfantasy.api.IntermediateTables.GameProtagonist;
import finalfantasy.api.dto.ProtagonistDto;
import finalfantasy.api.enums.GameEdition;
import finalfantasy.api.models.Game;
import finalfantasy.api.models.Protagonist;
import finalfantasy.api.repositories.GameProtagonistRepository;
import finalfantasy.api.repositories.GameRepository;
import finalfantasy.api.repositories.ProtagonistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ProtagonistController {

    @Autowired
    ProtagonistRepository protagonistRepository;

    @Autowired
    GameProtagonistRepository gameProtagonistRepository;

    @Autowired
    GameRepository gameRepository;

    @GetMapping("/protagonists")
    public List<ProtagonistDto> getAllProtagonist (){
        return protagonistRepository.findAll().stream().map( protagonist -> new ProtagonistDto(protagonist)).collect(Collectors.toList());
    }

    @PostMapping("/newProtagonist")
    public ResponseEntity<Object> createProtagonist (
            @RequestParam String name, @RequestParam String lastName, @RequestParam String gender, @RequestParam String job,
            @RequestParam String protagonistDescription, @RequestParam String race,@RequestParam GameEdition gameEdition, @RequestParam String url){
        protagonistRepository.save(new Protagonist(name, lastName, gender, job, protagonistDescription , race, url)) ;
        return new ResponseEntity<>("A new Protagonist has been Created", HttpStatus.OK);
    }

    @PostMapping("/newProtagonists")
    public ResponseEntity<Object> createProtagonists (@RequestBody List<Protagonist> protagonistList) {

        List<Game> gameList = gameRepository.findAll();

        if(protagonistList.size() < 1){
            return new ResponseEntity<>("The array length in the POST petition can't be 0", HttpStatus.BAD_REQUEST);
        }

        for(Protagonist protagonist : protagonistList){
            Protagonist newProtagonist = new Protagonist(
                    protagonist.getName(),
                    protagonist.getLastName(),
                    protagonist.getGender(),
                    protagonist.getJob(),
                    protagonist.getDescription(),
                    protagonist.getRace(),
                    //protagonist.getGameEdition(),
                    protagonist.getImageUrl() );
                    protagonistRepository.save(newProtagonist
                    );


            for(Game game : gameList){
                boolean match = game.getAvailableProtagonistList().contains(newProtagonist.getName());
                Set<GameProtagonist> setGameProtagonist = new HashSet<>();
                if(match){
                   GameProtagonist newGameProtagonist = new GameProtagonist(game, newProtagonist);
                   gameProtagonistRepository.save( newGameProtagonist );
                   setGameProtagonist.add(newGameProtagonist);
                   game.setGameProtagonists(setGameProtagonist);
                   gameRepository.save(game);
                }
            }

        }
        return new ResponseEntity<>(protagonistList.size() + " protagonists has benn created", HttpStatus.OK);
    }

    /*@PostMapping("/newGameProtagonists")
    public ResponseEntity<Object> createGameProtagonists () {
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Pepe");
        ArrayList<String> lista2 = new ArrayList<>();
        lista.add("Ifrit");
        ArrayList<String> lista3 = new ArrayList<>();
        lista.add("Balamb");
        Game ff7 = new Game (GameEdition.FINAL_FANTASY_VII,"","", "PLAYSTATION_4", "FF_15_DESCRIPTION",lista, lista2, lista3);
        Protagonist cloud = new Protagonist();
        protagonistRepository.save(cloud);
        gameRepository.save(ff7);
        gameProtagonistRepository.save(new GameProtagonist( ff7 , cloud));
        return new ResponseEntity<>("GameProtagonist created" , HttpStatus.CREATED);
    }*/
}
