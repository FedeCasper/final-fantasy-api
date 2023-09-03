package finalfantasy.api.models;

import finalfantasy.api.IntermediateTables.GameProtagonist;
import finalfantasy.api.IntermediateTables.GameSummon;
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
    private String platform;
    @Column(length = 1000)
    private String description;
    private ArrayList<String> availableProtagonistList;
    private ArrayList<String> availableSummonsList;

    @OneToMany(mappedBy = "game", fetch = FetchType.EAGER)
    private Set<GameProtagonist> gameProtagonists = new HashSet<>();

    @OneToMany(mappedBy = "game", fetch = FetchType.EAGER)
    private Set<GameSummon> gameSummons = new HashSet<>();

    @OneToMany(mappedBy = "game", fetch = FetchType.EAGER)
    private Set<Location> locations = new HashSet<>();


    public Game (){};

    public Game(String title, String releaseDate, String image, String platform, String description, ArrayList<String> availableProtagonistList, ArrayList<String> availableSummonsList) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.image = image;
        this.platform = platform;
        this.description = description;
        this.availableProtagonistList = availableProtagonistList;
        this.availableSummonsList = availableSummonsList;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", image='" + image + '\'' +
                ", platform='" + platform + '\'' +
                ", description='" + description + '\'' +
                ", availableProtagonistList=" + availableProtagonistList +
                ", availableSummonsList=" + availableSummonsList +
                ", gameProtagonists=" + gameProtagonists +
                ", gameSummons=" + gameSummons +
                ", locations=" + locations +
                '}';
    }
}
