package finalfantasy.api.controllers;

import finalfantasy.api.dto.GameDto;
import finalfantasy.api.models.Game;
import finalfantasy.api.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class GameController {

    @Autowired
    GameRepository gameRepository;

    @GetMapping("/games")
    public List<GameDto> getAllGames (){
        return gameRepository.findAll().stream().map( game -> new GameDto(game)).collect(Collectors.toList());
    }

    @PostMapping("/newGame")
    public ResponseEntity<Object> createNewGame(
            @RequestParam String title,
            @RequestParam String releaseDate,
            @RequestParam String image,
            @RequestParam String platform,
            @RequestParam String gameDescription,
            @RequestParam ArrayList<String> availableProtagonistList,
            @RequestParam ArrayList<String> availableSummonList,
            @RequestParam ArrayList<String> availableLocationsList
            ){
            gameRepository.save(
                    new Game(title, releaseDate, image, platform, gameDescription, availableProtagonistList, availableSummonList, availableLocationsList)
            );
            return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/newGames")
    public ResponseEntity<Object> createGames (@RequestBody List<GameDto> gameDtoList) {

        if(gameDtoList.size() < 1){
            return new ResponseEntity<>("The array length in the POST petition can't be 0", HttpStatus.BAD_REQUEST);
        }

        for(GameDto gameDto : gameDtoList){
            gameRepository.save(new Game( gameDto.getTitle(), gameDto.getReleaseDate(),gameDto.getImage(),
                    gameDto.getPlatform(), gameDto.getDescription(), gameDto.getAvailableProtagonistList(), gameDto.getAvailableSummonList(), gameDto.getAvailableLocationsList() )
            ) ;
        }
        return new ResponseEntity<>(gameDtoList.size() + " games has benn created", HttpStatus.OK);
    }

}
