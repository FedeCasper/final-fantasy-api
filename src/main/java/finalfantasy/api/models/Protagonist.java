package finalfantasy.api.models;

import finalfantasy.api.enums.GameEdition;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Protagonist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator( name = "native", strategy = "native")
    private long id;
    private String name;
    private String gender;
    private String job;
    @Column(length = 1000)
    private String description;
    private String race;
    private GameEdition origin;
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

    @Override
    public String toString() {
        return "Protagonist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", job='" + job + '\'' +
                ", description='" + description + '\'' +
                ", race='" + race + '\'' +
                ", origin=" + origin +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
