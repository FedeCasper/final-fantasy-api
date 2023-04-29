package finalfantasy.api.dto;

import finalfantasy.api.IntermediateTables.GameProtagonist;
import finalfantasy.api.enums.GameEdition;
import finalfantasy.api.enums.Gender;
import finalfantasy.api.models.Game;
import finalfantasy.api.models.Protagonist;
import lombok.Getter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
public class ProtagonistDto {

    private long id;
    private String name;
    private Gender gender;
    private String job;
    @Column(length = 1000)
    private String description;
    private String race;
    private GameEdition origin;
    private String imageUrl;

    private Set<GameProtagonist> gameProtagonists = new HashSet<>();

    public ProtagonistDto(){}

    public ProtagonistDto(Protagonist protagonist) {
        this.name = protagonist.getName();
        this.gender = protagonist.getGender();
        this.job = protagonist.getJob();
        this.description = protagonist.getDescription();
        this.race = protagonist.getRace();
        this.origin = protagonist.getOrigin();
        this.imageUrl = protagonist.getImageUrl();
    }


}
