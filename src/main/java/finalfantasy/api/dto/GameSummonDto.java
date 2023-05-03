package finalfantasy.api.dto;

import finalfantasy.api.IntermediateTables.GameSummon;
import finalfantasy.api.enums.GameEdition;
import finalfantasy.api.enums.SummonType;
import lombok.Getter;

@Getter
public class GameSummonDto {

    private long id;
    private String name;
    private SummonType type;

    public GameSummonDto() {
    }

    public GameSummonDto(String name, SummonType summonType) {
        this.name = name;
        this.type = summonType;
    }
}
