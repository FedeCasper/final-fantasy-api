package finalfantasy.api.models;

import finalfantasy.api.IntermediateTables.GameSummon;
import finalfantasy.api.enums.GameEdition;
import finalfantasy.api.enums.SummonType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Summon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private SummonType type;

    @OneToMany(mappedBy = "summon" , fetch = FetchType.EAGER)
    private Set<GameSummon> gameSummons = new HashSet<>();

    public Summon() {}

    public Summon(String name, SummonType type) {
        this.name = name;
        this.type = type;
    }
}
