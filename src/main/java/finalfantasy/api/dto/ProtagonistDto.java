package finalfantasy.api.dto;

import finalfantasy.api.enums.GameEdition;
import finalfantasy.api.models.Protagonist;
import lombok.Getter;

import javax.persistence.*;

@Getter
public class ProtagonistDto {

    private long id;
    private String name;
    private String lastName;
    private String gender;
    private String job;
    @Column(length = 1000)
    private String description;
    private String race;
    private String imageUrl;


    public ProtagonistDto(){}

    public ProtagonistDto(Protagonist protagonist) {
        this.id = protagonist.getId();
        this.name = protagonist.getName();
        this.lastName = protagonist.getLastName();
        this.gender = protagonist.getGender();
        this.job = protagonist.getJob();
        this.description = protagonist.getDescription();
        this.race = protagonist.getRace();
        this.imageUrl = protagonist.getImageUrl();
    }

    public void setId(Protagonist protagonist) {
        this.id = protagonist.getId();
    }
}
