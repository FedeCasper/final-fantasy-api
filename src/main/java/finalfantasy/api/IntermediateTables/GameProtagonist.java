package finalfantasy.api.IntermediateTables;

import finalfantasy.api.enums.GameEdition;
import finalfantasy.api.models.Game;
import finalfantasy.api.models.Protagonist;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class GameProtagonist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    private String name;
    private String gameEdition;
    private String home;
    private String occupation;
    private String ultimate_limit;
    private String ultimate_weapon;

    @ManyToOne(fetch = FetchType.EAGER)
    private Game game;
    @ManyToOne(fetch = FetchType.EAGER)
    private Protagonist protagonist;

    public GameProtagonist() {
    }

    public GameProtagonist(Game game, Protagonist protagonist, String ultimate_limit, String ultimate_weapon) {
        this.name = protagonist.getName();
        this.gameEdition = game.getTitle();
        this.home = protagonist.getHome();
        this.occupation = protagonist.getOccupation();
        this.ultimate_limit = ultimate_limit;
        this.ultimate_weapon = ultimate_weapon;
        this.game = game;
        this.protagonist = protagonist;
    }

}
