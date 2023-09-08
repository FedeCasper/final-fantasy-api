package finalfantasy.api.controllers;

import finalfantasy.api.dto.GameDto;
import finalfantasy.api.enums.GameEdition;
import finalfantasy.api.models.Game;
import finalfantasy.api.repositories.GameRepository;
import org.springframework.beans.BeanUtils;
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
            @RequestParam ArrayList<String> availableLocationsList,
            @RequestParam ArrayList<String> availableJobsList
            ){
            Game newGameCreated = new Game(
                    title.toUpperCase().replaceAll(" ", "_"),
                    releaseDate,
                    image,
                    platform,
                    gameDescription,
                    availableProtagonistList,
                    availableSummonList,
                    availableLocationsList,
                    availableJobsList
            );
            gameRepository.save(newGameCreated);
            return new ResponseEntity<>("A new game " + newGameCreated.getTitle() + " has been created", HttpStatus.CREATED);
    }

    @PostMapping("/newGames")
    public ResponseEntity<Object> createGames (@RequestBody List<GameDto> gameDtoList) {
        if(gameDtoList.size() < 1){
            return new ResponseEntity<>("The array length in the POST petition can't be 0", HttpStatus.BAD_REQUEST);
        }
        for(GameDto gameDto : gameDtoList){
            gameRepository.save(
                    new Game(
                            gameDto.getTitle(),
                            gameDto.getReleaseDate(),
                            gameDto.getImage(),
                            gameDto.getPlatform(),
                            gameDto.getDescription(),
                            gameDto.getAvailableProtagonistList(),
                            gameDto.getAvailableSummonList(),
                            gameDto.getAvailableLocationsList(),
                            gameDto.getAvailableJobsList())
            ) ;
        }
        return new ResponseEntity<>(gameDtoList.size() + " games has benn created", HttpStatus.OK);
    }

    @PatchMapping("/updateGame/{gameId}")
    public ResponseEntity<Object> updateGame(@PathVariable Long gameId, @RequestBody GameDto gameDto){
        Game originalGame = gameRepository.findById(gameId).orElse(null);
        if(originalGame != null){
            gameDto.setId(originalGame);
            BeanUtils.copyProperties(gameDto, originalGame);
            gameRepository.save(originalGame);
            return new ResponseEntity<Object>("El juego ha sido editado", HttpStatus.OK);
        }else{
            return new ResponseEntity<Object>("El juego a editar no existe", HttpStatus.NOT_FOUND);
        }
    }
}
