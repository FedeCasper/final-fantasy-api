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

    private String name;
    private String edition;

    public GameProtagonistDto() {}

    public GameProtagonistDto(GameProtagonist gameProtagonist) {
        this.name = gameProtagonist.getName();
        this.edition = gameProtagonist.getGameEdition();
    }

}
