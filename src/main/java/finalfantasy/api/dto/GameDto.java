package finalfantasy.api.dto;

import finalfantasy.api.enums.GameDescription;
import finalfantasy.api.models.Game;
import lombok.Getter;

import javax.persistence.Column;
import java.util.ArrayList;
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
    private GameDescription description;
    private ArrayList<String> availableProtagonistList;

    public GameDto (){};

    public GameDto(Game game) {
        this.title = game.getTitle();
        this.releaseDate = game.getReleaseDate();
        this.image = game.getImage();
        this.platform = game.getPlatform();
        this.description = game.getDescription();
        this.availableProtagonistList = game.getAvailableProtagonistList();
    }
}
