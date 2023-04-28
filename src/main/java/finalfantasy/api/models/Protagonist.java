package finalfantasy.api.models;

import finalfantasy.api.enums.GameEdition;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Protagonist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator( name = "native", strategy = "native")
    @Getter
    private long id;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private String gender;
    @Getter @Setter
    private String job;
    @Getter @Setter
    @Column(length = 1000)
    private String description;
    @Getter @Setter
    private String race;
    @Getter @Setter
    private GameEdition origin;
    @Getter @Setter
    private String imageUrl;

    public Protagonist(){}

    public Protagonist(String name, String gender, String job, String description, String race, GameEdition origin, String imageUrl) {
        this.name = name;
        this.gender = gender;
        this.job = job;
        this.description = description;
        this.race = race;
        this.origin = origin;
        this.imageUrl = imageUrl;
    }


}
