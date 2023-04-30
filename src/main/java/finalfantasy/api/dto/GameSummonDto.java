package finalfantasy.api.dto;

import finalfantasy.api.IntermediateTables.GameSummon;
import finalfantasy.api.enums.GameEdition;
import lombok.Getter;


@Getter
public class GameSummonDto {

    private long id;
    private String name;
    private GameEdition origin;
    private GameSummon gameSummon;

    public GameSummonDto() {
    }

    public GameSummonDto(GameSummon gameSummon) {
        this.name = gameSummon.getSummon().getName();
        this.origin = gameSummon.getSummon().getOrigin();
    }
}
