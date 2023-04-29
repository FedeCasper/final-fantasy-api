package finalfantasy.api.dto;

import finalfantasy.api.IntermediateTables.GameProtagonist;
import finalfantasy.api.models.Game;
import finalfantasy.api.models.Protagonist;
import lombok.Getter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
public class GameProtagonistDto {

    private long id;
    private Game game;
    private Protagonist protagonist;

    public GameProtagonistDto() {
    }

    public GameProtagonistDto(GameProtagonist gameProtagonist) {
        this.game = gameProtagonist.getGame();
        this.protagonist = gameProtagonist.getProtagonist();
    }

}
