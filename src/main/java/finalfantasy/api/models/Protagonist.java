package finalfantasy.api.models;

import finalfantasy.api.IntermediateTables.GameProtagonist;
import finalfantasy.api.enums.GameEdition;
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
    private String description;
    private String race;
    private String imageUrl;

    @OneToMany(mappedBy = "protagonist", fetch = FetchType.EAGER)
    private Set<GameProtagonist> gameProtagonists = new HashSet<>();

    public Protagonist(){}

    public Protagonist(String name, String lastName, String gender, String job, String description, String race, String imageUrl) {
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
        this.job = job;
        this.description = description;
        this.race = race;
        this.imageUrl = imageUrl;
    }


}
