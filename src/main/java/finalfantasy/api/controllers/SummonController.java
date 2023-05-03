package finalfantasy.api.controllers;

import finalfantasy.api.IntermediateTables.GameSummon;
import finalfantasy.api.dto.GameSummonDto;
import finalfantasy.api.dto.SummonDto;
import finalfantasy.api.enums.SummonType;
import finalfantasy.api.models.Summon;
import finalfantasy.api.repositories.SummonRepository;
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
    SummonRepository summonRepository;

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
    public ResponseEntity<Object> createSummons (@RequestBody GameSummonDto[] array) {
        for(GameSummonDto gameSummonDto : array){
            summonRepository.save(new Summon(gameSummonDto.getName(), gameSummonDto.getType())) ;
        }
        return new ResponseEntity<>(array.length + " summons has benn created", HttpStatus.OK);
    }
}
