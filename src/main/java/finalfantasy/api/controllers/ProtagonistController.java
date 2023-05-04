package finalfantasy.api.controllers;

import finalfantasy.api.dto.ProtagonistDto;
import finalfantasy.api.enums.GameEdition;
import finalfantasy.api.models.Protagonist;
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
            @RequestParam String protagonistDescription, @RequestParam String race,@RequestParam GameEdition gameEdition, @RequestParam String url){
        protagonistRepository.save(new Protagonist(name, lastName, gender, job, protagonistDescription , race,gameEdition, url)) ;
        return new ResponseEntity<>("A new Protagonist has been Created", HttpStatus.OK);
    }

    @PostMapping("/newProtagonists")
    public ResponseEntity<Object> createProtagonists (@RequestBody List<ProtagonistDto> protagonistDtoList) {
        for(ProtagonistDto protagonistDto : protagonistDtoList){

            protagonistRepository.save(new Protagonist(
                    protagonistDto.getName(), protagonistDto.getLastName(),protagonistDto.getGender(),
                    protagonistDto.getJob(), protagonistDto.getDescription(), protagonistDto.getRace(),
                    protagonistDto.getOrigin(), protagonistDto.getImageUrl()
                    )

            ) ;

        }

        return new ResponseEntity<>(protagonistRepository.count() + " protagonists has benn created", HttpStatus.OK);

    }

}
