package finalfantasy.api.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

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
    @OrderColumn
    private List<Protagonist> protagonists;

    public Game (){};

    public Game(String title, String releaseDate, String image, String plataform, String story, List<Protagonist> protagonists) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.image = image;
        this.plataform = plataform;
        this.story = story;
        this.protagonists = protagonists;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", image='" + image + '\'' +
                ", plataform='" + plataform + '\'' +
                ", story='" + story + '\'' +
                ", protagonists=" + Arrays.toString(protagonists) +
                '}';
    }
}
