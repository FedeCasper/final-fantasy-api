package finalfantasy.api.IntermediateTables;

import finalfantasy.api.enums.SummonImage;
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

    private String name;
    private String summonVersion;
    @ManyToOne(fetch = FetchType.EAGER)
    private Game game;
    @ManyToOne(fetch = FetchType.EAGER)
    private Summon summon;
    private SummonImage image;

    public GameSummon() {}

    public GameSummon(Game game, Summon summon) {
        this.name = summon.getName();
        this.game = game;
        this.summon = summon;
        this.summonVersion = summon.getName() + "_" + game.getTitle();
    }
}
