package finalfantasy.api.models;

import com.fasterxml.jackson.annotation.JsonValue;
import finalfantasy.api.IntermediateTables.GameProtagonist;
import finalfantasy.api.enums.GameEdition;
import finalfantasy.api.enums.Gender;
import finalfantasy.api.enums.ProtagonistDescription;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Protagonist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator( name = "native", strategy = "native")
    private long id;
    private String name;
    private String lastName;
    private String gender;
    private String job;
    @Column(length = 1000)
    private ProtagonistDescription description;
    private String race;
    @Enumerated(EnumType.STRING)
    private GameEdition origin;
    private String imageUrl;

    @OneToMany(mappedBy = "protagonist", fetch = FetchType.EAGER)
    private Set<GameProtagonist> gameProtagonists = new HashSet<>();

    public Protagonist(){}

    public Protagonist(String name, String lastName, String gender, String job, ProtagonistDescription description, String race, GameEdition origin, String imageUrl) {
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
        this.job = job;
        this.description = description;
        this.race = race;
        this.origin = origin;
        this.imageUrl = imageUrl;
    }


}
