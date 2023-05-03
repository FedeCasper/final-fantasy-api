package finalfantasy.api.controllers;

import finalfantasy.api.dto.GameSummonDto;
import finalfantasy.api.dto.ProtagonistDto;
import finalfantasy.api.dto.ProtagonistDtoReception;
import finalfantasy.api.enums.GameEdition;
import finalfantasy.api.enums.Gender;
import finalfantasy.api.enums.ProtagonistDescription;
import finalfantasy.api.enums.SummonType;
import finalfantasy.api.models.Protagonist;
import finalfantasy.api.models.Summon;
import finalfantasy.api.repositories.ProtagonistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ProtagonistController {

    @Autowired
    ProtagonistRepository protagonistRepository;

    @GetMapping("/protagonists")
    public List<ProtagonistDto> getAllProtagonist (){
        return protagonistRepository.findAll().stream().map( protagonist -> new ProtagonistDto(protagonist)).collect(Collectors.toList());
    }

    @PostMapping("/newProtagonist")
    public ResponseEntity<Object> createProtagonist (
            @RequestParam String name, @RequestParam String lastName, @RequestParam String gender, @RequestParam String job,
            @RequestParam ProtagonistDescription protagonistDescription, @RequestParam String race,@RequestParam GameEdition gameEdition, @RequestParam String url){
        protagonistRepository.save(new Protagonist(name, lastName, gender, job, protagonistDescription, race,gameEdition, url)) ;
        return new ResponseEntity<>("A new Protagonist has been Created", HttpStatus.OK);
    }

    @PostMapping("/newProtagonists")
    public ResponseEntity<Object> createProtagonists (@RequestBody ProtagonistDtoReception[] array) {
        for(ProtagonistDtoReception protagonistDtoReception : array){
            protagonistRepository.save(new Protagonist(
                    protagonistDtoReception.getName(), protagonistDtoReception.getLastName(),protagonistDtoReception.getGender(),
                    protagonistDtoReception.getJob(), protagonistDtoReception.getDescription(), protagonistDtoReception.getRace(),
                    protagonistDtoReception.getOrigin(), protagonistDtoReception.getImageUrl()
                    )
            ) ;
        }
        return new ResponseEntity<>(array.length + " protagonists has benn created", HttpStatus.OK);
    }

}
