package finalfantasy.api.controllers;

import finalfantasy.api.IntermediateTables.GameProtagonist;
import finalfantasy.api.dto.LocationDto;
import finalfantasy.api.dto.ProtagonistDto;
import finalfantasy.api.enums.CharacterType;
import finalfantasy.api.enums.GameEdition;
import finalfantasy.api.models.Game;
import finalfantasy.api.models.Location;
import finalfantasy.api.models.Protagonist;
import finalfantasy.api.repositories.GameProtagonistRepository;
import finalfantasy.api.repositories.GameRepository;
import finalfantasy.api.repositories.ProtagonistRepository;
import org.springframework.beans.BeanUtils;
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
            @RequestParam String name,
            @RequestParam String lastName,
            @RequestParam String description,
            @RequestParam String gender,
            @RequestParam String race,
            @RequestParam String url,
            @RequestParam CharacterType characterType,
            @RequestParam String home,
            @RequestParam String occupation
    ){
        protagonistRepository.save(
                new Protagonist(
                        name,
                        lastName,
                        description,
                        gender,
                        race,
                        url,
                        characterType,
                        home,
                        occupation
                )
        );
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
                    protagonist.getDescription(),
                    protagonist.getGender(),
                    protagonist.getImageUrl(),
                    protagonist.getRace(),
                    protagonist.getCharacterType(),
                    protagonist.getHome(),
                    protagonist.getOccupation()
            );
                    protagonistRepository.save(newProtagonist
                    );


            for(Game game : gameList){
                boolean match = game.getAvailableProtagonistList().contains(newProtagonist.getName());
                Set<GameProtagonist> setGameProtagonist = new HashSet<>();
                if(match){
                   GameProtagonist newGameProtagonist = new GameProtagonist(game, newProtagonist, "empty", "empty");
                   gameProtagonistRepository.save( newGameProtagonist );
                   setGameProtagonist.add(newGameProtagonist);
                   game.setGameProtagonists(setGameProtagonist);
                   gameRepository.save(game);
                }
            }

        }
        return new ResponseEntity<>(protagonistList.size() + " protagonists has benn created", HttpStatus.OK);
    }

    @PatchMapping("/updateProtagonist/{protagonistId}")
    public ResponseEntity<Object> updateLocation(@PathVariable Long protagonistId, @RequestBody ProtagonistDto protagonistDto){
        Protagonist originalProtagonist = protagonistRepository.findById(protagonistId).orElse(null);
        if(originalProtagonist != null){
            protagonistDto.setId(originalProtagonist);
            BeanUtils.copyProperties(protagonistDto, originalProtagonist);
            protagonistRepository.save(originalProtagonist);
            return new ResponseEntity<Object>("El personaje ha sido editado", HttpStatus.OK);
        }else{
            return new ResponseEntity<Object>("El personaje a editar no existe", HttpStatus.NOT_FOUND);
        }
    }
}
