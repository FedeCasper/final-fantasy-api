package finalfantasy.api.controllers;

import finalfantasy.api.IntermediateTables.GameProtagonist;
import finalfantasy.api.IntermediateTables.GameSummon;
import finalfantasy.api.dto.GameSummonDto;
import finalfantasy.api.dto.ProtagonistDto;
import finalfantasy.api.dto.SummonDto;
import finalfantasy.api.enums.SummonType;
import finalfantasy.api.models.Game;
import finalfantasy.api.models.Protagonist;
import finalfantasy.api.models.Summon;
import finalfantasy.api.repositories.GameRepository;
import finalfantasy.api.repositories.GameSummonRepository;
import finalfantasy.api.repositories.SummonRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class SummonController {

    @Autowired
    GameRepository gameRepository;

    @Autowired
    SummonRepository summonRepository;

    @Autowired
    GameSummonRepository gameSummonRepository;


    @GetMapping("/summons")
    public List<SummonDto> getAllSummons (){
        return summonRepository.findAll().stream().map(summon -> new SummonDto(summon)).collect(Collectors.toList());
    }


    @PostMapping("/newSummon")
    public ResponseEntity<Object> createSummon (@RequestParam String name, @RequestParam SummonType summonType){
        summonRepository.save(new Summon(name, summonType)) ;
        return new ResponseEntity<>("A Summon has been Created", HttpStatus.OK);
    }


    @PostMapping("/newSummons")
    public ResponseEntity<Object> createSummons (@RequestBody List<Summon> summonList) {
        List<Game> gameList = gameRepository.findAll();
        if(summonList.size() < 1){
            return new ResponseEntity<>("The array length in the POST petition can't be 0", HttpStatus.BAD_REQUEST);
        }
        for(Summon summon : summonList){
            Summon newSummon = new Summon(
                    summon.getName(), summon.getType()
            );
            summonRepository.save(newSummon) ;
            for(Game game : gameList){
                boolean match = game.getAvailableSummonsList().contains(newSummon.getName());
                Set<GameSummon> newGameSummonsSet = new HashSet<>();
                if(match){
                    GameSummon newGameSummon = new GameSummon(game, newSummon);
                    gameSummonRepository.save(newGameSummon);
                    newGameSummonsSet.add(newGameSummon);
                    game.setGameSummons(newGameSummonsSet);
                    gameRepository.save(game);
                }
            }
        }
        return new ResponseEntity<>(summonList.size() + " summons has benn created", HttpStatus.OK);
    }


    @PatchMapping("/updateSummon/{summonId}")
    public ResponseEntity<Object> updateSummon(@PathVariable Long summonId, @RequestBody SummonDto summonDto){
        Summon originalSummon = summonRepository.findById(summonId).orElse(null);
        if(originalSummon != null){
            summonDto.setId(originalSummon);
            BeanUtils.copyProperties(summonDto, originalSummon);
            summonRepository.save(originalSummon);
            return new ResponseEntity<Object>("El personaje ha sido editado", HttpStatus.OK);
        }else{
            return new ResponseEntity<Object>("El personaje a editar no existe", HttpStatus.NOT_FOUND);
        }
    }

}

