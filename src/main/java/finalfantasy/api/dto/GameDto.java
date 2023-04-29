package finalfantasy.api.dto;

import finalfantasy.api.models.Game;
import lombok.Getter;

import javax.persistence.Column;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
public class GameDto {

    private long id;
    private String title;
    private String releaseDate;
    private String image;
    private String plataform;
    @Column(length = 1000)
    private String story;

    private List<ProtagonistDto> protagonistsDto;
    private Set<GameProtagonistDto> gameProtagonistDtoSet;

    public GameDto (){};

    public GameDto(Game game) {
        this.title = game.getTitle();
        this.releaseDate = game.getReleaseDate();
        this.image = game.getImage();
        this.plataform = game.getPlataform();
        this.story = game.getStory();
        this.gameProtagonistDtoSet = game.getGameProtagonists().stream().map( gameProtagonist -> new GameProtagonistDto(gameProtagonist)).collect(Collectors.toSet());
    }

}
