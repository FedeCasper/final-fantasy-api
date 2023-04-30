package finalfantasy.api.IntermediateTables;

import finalfantasy.api.models.Game;
import finalfantasy.api.models.Protagonist;
import finalfantasy.api.models.Summon;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class GameSummon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Game game;
    @ManyToOne(fetch = FetchType.EAGER)
    private Summon summon;



    public GameSummon() {}

    public GameSummon(Game game, Summon summon) {
        this.game = game;
        this.summon = summon;
    }
}
