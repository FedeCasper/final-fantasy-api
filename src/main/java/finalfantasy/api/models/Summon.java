package finalfantasy.api.models;

import finalfantasy.api.enums.GameEdition;
import finalfantasy.api.enums.SummonType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Summon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private String name;
    private GameEdition origin;
    private SummonType type;

    public Summon() {}

    public Summon(String name, GameEdition origin, SummonType type) {
        this.name = name;
        this.origin = origin;
        this.type = type;
    }
}
