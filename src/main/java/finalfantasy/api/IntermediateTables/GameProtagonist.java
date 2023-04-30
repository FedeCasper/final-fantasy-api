package finalfantasy.api.IntermediateTables;

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

    @ManyToOne(fetch = FetchType.EAGER)
    private Game game;
    @ManyToOne(fetch = FetchType.EAGER)
    private Protagonist protagonist;

    public GameProtagonist() {
    }

    public GameProtagonist(Game game, Protagonist protagonist) {
        this.name = protagonist.getName() + " " + (protagonist.getLastName().equals("Unknown") ? "" : protagonist.getLastName()) + " de " + game.getTitle();
        this.game = game;
        this.protagonist = protagonist;
    }

}
