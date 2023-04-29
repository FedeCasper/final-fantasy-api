package finalfantasy.api.controllers;

import finalfantasy.api.dto.GameDto;
import finalfantasy.api.dto.ProtagonistDto;
import finalfantasy.api.repositories.GameRepository;
import finalfantasy.api.repositories.ProtagonistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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

}
