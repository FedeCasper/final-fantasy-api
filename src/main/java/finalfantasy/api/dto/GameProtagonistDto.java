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
    private GameEdition gameEdition;
    private String job;

    public GameProtagonistDto() {}

    public GameProtagonistDto(GameProtagonist gameProtagonist) {
        this.id = gameProtagonist.getId();
        this.name = gameProtagonist.getName();
        this.gameEdition = gameProtagonist.getGameEdition();
    }

}
