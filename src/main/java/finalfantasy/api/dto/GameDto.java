package finalfantasy.api.dto;

import finalfantasy.api.IntermediateTables.GameProtagonist;
import finalfantasy.api.IntermediateTables.GameSummon;
import finalfantasy.api.enums.GameEdition;
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
    private GameEdition title;
    private String releaseDate;
    private String image;
    private String platform;
    @Column(length = 1000)
    private String description;
    private ArrayList<String> availableProtagonistList;
    private ArrayList<String> availableSummonList;
    private ArrayList<String> availableLocationsList;
    private ArrayList<String> availableJobsList;


    private Set<GameProtagonistDto> gameProtagonists = new HashSet<>();
    private Set<GameSummonDto> gameSummons = new HashSet<>();
    private Set<LocationDto> locations = new HashSet<>();

    public GameDto (){};

    public GameDto(Game game) {
        this.id = game.getId();
        this.title = game.getTitle();
        this.releaseDate = game.getReleaseDate();
        this.image = game.getImage();
        this.platform = game.getPlatform();
        this.description = game.getDescription();
        this.availableProtagonistList = game.getAvailableProtagonistList();
        this.availableSummonList = game.getAvailableSummonsList();
        this.availableLocationsList = game.getAvailableLocationsList();
        this.availableJobsList = game.getAvailableJobsList();
        this.gameSummons = game.getGameSummons().stream().map(gameSummon -> new GameSummonDto(gameSummon)).collect(Collectors.toSet());
        this.gameProtagonists = game.getGameProtagonists().stream().map(gameProtagonist -> new GameProtagonistDto(gameProtagonist)).collect(Collectors.toSet());
        this.locations = game.getLocations().stream().map(location -> new LocationDto(location)).collect(Collectors.toSet());
    }

}
