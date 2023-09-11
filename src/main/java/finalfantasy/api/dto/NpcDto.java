package finalfantasy.api.dto;

import finalfantasy.api.enums.CharacterType;
import finalfantasy.api.models.Npc;
import lombok.Getter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
public class NpcDto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator( name = "native", strategy = "native")
    private long id;

    // Personal data
    private String name;
    private String lastName;
    private String description;
    // Physical description
    private String gender;
    private String race;
    // Portraits
    private String imageUrl;
    // Gameplay details
    private CharacterType characterType;

    public NpcDto() {
    }

    public NpcDto(Npc npc) {
        this.name = npc.getName();
        this.lastName = npc.getLastName();
        this.description = npc.getDescription();
        this.gender = npc.getGender();
        this.race = npc.getRace();
        this.imageUrl = npc.getImageUrl();
        this.characterType = npc.getCharacterType();
    }
}
