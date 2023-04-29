package finalfantasy.api.models;

import finalfantasy.api.IntermediateTables.GameProtagonist;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

@Entity
@Getter
@Setter
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")

    private long id;
    private String title;
    private String releaseDate;
    private String image;
    private String plataform;
    @Column(length = 1000)
    private String story;

    @OneToMany(mappedBy = "game", fetch = FetchType.EAGER)
    private Set<GameProtagonist> gameProtagonists = new HashSet<>();

    public Game (){};

    public Game(String title, String releaseDate, String image, String plataform, String story) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.image = image;
        this.plataform = plataform;
        this.story = story;
    }


}
