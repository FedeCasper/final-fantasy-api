package finalfantasy.api.controllers;

import finalfantasy.api.dto.NpcDto;
import finalfantasy.api.dto.ProtagonistDto;
import finalfantasy.api.models.Npc;
import finalfantasy.api.repositories.NpcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class NpcController {

    @Autowired
    NpcRepository npcRepository;

    @GetMapping("/npc")
    public List<NpcDto> getAllNpc (){
        return npcRepository.findAll().stream().map( npc -> new NpcDto(npc)).collect(Collectors.toList());
    }

    @PostMapping("/newNpc")
    public ResponseEntity<Object> createNpc (@RequestBody NpcDto npcDto){
        Npc newNpc = new Npc(
                npcDto.getName(),
                npcDto.getLastName(),
                npcDto.getDescription(),
                npcDto.getGender(),
                npcDto.getRace(),
                npcDto.getImageUrl(),
                npcDto.getCharacterType()
        );
        npcRepository.save(newNpc);
        return new ResponseEntity<>("A new NPC has been created!", HttpStatus.CREATED);
    }

}
