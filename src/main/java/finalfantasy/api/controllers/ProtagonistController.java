package finalfantasy.api.controllers;

import finalfantasy.api.models.Protagonist;
import finalfantasy.api.repositories.ProtagonistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProtagonistController {

    @Autowired
    ProtagonistRepository protagonistRepository;

    @GetMapping("/protagonists")
    @ResponseBody
    public List<Protagonist> getAllProtagonist (){
        return protagonistRepository.findAll();
    }

}
