package finalfantasy.api.dto;

import finalfantasy.api.IntermediateTables.GameProtagonist;
import finalfantasy.api.IntermediateTables.GameSummon;
import finalfantasy.api.models.Game;
import finalfantasy.api.models.Location;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
public class GameDto {

    private long id;
    private String title;
    private String releaseDate;
    private String image;
    private String platform;
    @Column(length = 1000)
    private String description;
    private ArrayList<String> availableProtagonistList;
    private ArrayList<String> availableSummonList;


    private Set<GameProtagonist> gameProtagonists = new HashSet<>();
    private Set<GameSummonDto> gameSummons = new HashSet<>();
    //private Set<Location> locations = new HashSet<>();

    public GameDto (){};

    public GameDto(Game game) {
        this.title = game.getTitle();
        this.releaseDate = game.getReleaseDate();
        this.image = game.getImage();
        this.platform = game.getPlatform();
        this.description = game.getDescription();
        this.availableProtagonistList = game.getAvailableProtagonistList();
        this.availableSummonList = game.getAvailableSummonsList();
        this.gameSummons = game.getGameSummons().stream().map(gameSummon -> new GameSummonDto(gameSummon.getName(), gameSummon.getType())).collect(Collectors.toSet());
    }

    @Override
    public String toString() {
        return "GameDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", image='" + image + '\'' +
                ", platform='" + platform + '\'' +
                ", description='" + description + '\'' +
                ", availableProtagonistList=" + availableProtagonistList +
                ", availableSummonList=" + availableSummonList +
                ", gameProtagonists=" + gameProtagonists +
                ", gameSummons=" + gameSummons +
                '}';
    }
}
