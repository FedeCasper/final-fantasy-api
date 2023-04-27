package finalfantasy.api.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
    private String description;
    @Getter @Setter
    private String race;
    @Getter @Setter
    private String origin;

    public Protagonist(){}

    public Protagonist(String name, String gender, String job, String description, String race, String origin) {
        this.name = name;
        this.gender = gender;
        this.job = job;
        this.description = description;
        this.race = race;
        this.origin = origin;
    }


}
