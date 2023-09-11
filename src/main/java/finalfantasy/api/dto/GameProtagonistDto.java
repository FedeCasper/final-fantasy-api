package finalfantasy.api.dto;

import finalfantasy.api.IntermediateTables.GameProtagonist;
import finalfantasy.api.enums.GameEdition;
import finalfantasy.api.models.Game;
import finalfantasy.api.models.Protagonist;
import lombok.Getter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
public class GameProtagonistDto {

    private long id;
    private String name;
    private String gameEdition;
    private String home;
    private String occupation;
    private String ultimate_limit;
    private String ultimate_weapon;

    public GameProtagonistDto() {}

    public GameProtagonistDto(GameProtagonist gameProtagonist) {
        this.id = gameProtagonist.getId();
        this.name = gameProtagonist.getName();
        this.home = gameProtagonist.getHome();
        this.occupation = gameProtagonist.getOccupation();
        this.ultimate_limit = gameProtagonist.getUltimate_limit();
        this.ultimate_weapon = gameProtagonist.getUltimate_weapon();
        this.gameEdition = gameProtagonist.getGameEdition();
    }

}
