package finalfantasy.api.models;

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
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")

    private long id;
    private String title;
    private String releaseDate;
    private String image;
    private String plataform;
    private GameDescription story;

    public Game (){};

    public Game(String title, String releaseDate, String image, String plataform, GameDescription story) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.image = image;
        this.plataform = plataform;
        this.story = story;
    }
}
