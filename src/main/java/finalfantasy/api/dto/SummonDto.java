package finalfantasy.api.dto;

import finalfantasy.api.IntermediateTables.GameSummon;
import finalfantasy.api.enums.SummonType;
import finalfantasy.api.models.Summon;
import lombok.Getter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
public class SummonDto {

    private long id;
    private String name;
    private SummonType type;

    public SummonDto() {}

    public SummonDto(Summon summon) {
        this.id = summon.getId();
        this.name = summon.getName();
        this.type = summon.getType();
    }

    public void setId(Summon summon) {
        this.id = summon.getId();
    }
}
