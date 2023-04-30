package finalfantasy.api.dto;

import finalfantasy.api.IntermediateTables.GameSummon;
import finalfantasy.api.enums.GameDescription;
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
    private GameDescription description;

    private List<ProtagonistDto> protagonistsDto;
    private Set<GameProtagonistDto> gameProtagonistDtoSet;
    private Set<GameSummonDto> gameSummonDtoSet;

    public GameDto (){};

    public GameDto(Game game) {
        this.title = game.getTitle();
        this.releaseDate = game.getReleaseDate();
        this.image = game.getImage();
        this.plataform = game.getPlataform();
        this.description = game.getDescription();
        this.gameProtagonistDtoSet = game.getGameProtagonists().stream().map( gameProtagonist -> new GameProtagonistDto(gameProtagonist)).collect(Collectors.toSet());
        this.gameSummonDtoSet = game.getGameSummons().stream().map(gameSummon -> new GameSummonDto(gameSummon)).collect(Collectors.toSet());
    }

}
