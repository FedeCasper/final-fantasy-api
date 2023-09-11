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
    //private String occupation;
    @Column(length = 1000)
    private String description;
    private String race;
    private String imageUrl;
    //private String ultimate_limit;
    //private String ultimate_weapon;


    public ProtagonistDto(){}

    public ProtagonistDto(Protagonist protagonist) {
        this.id = protagonist.getId();
        this.name = protagonist.getName();
        this.lastName = protagonist.getLastName();
        this.gender = protagonist.getGender();
        //this.occupation = protagonist.getOccupation();
        this.description = protagonist.getDescription();
        this.race = protagonist.getRace();
        this.imageUrl = protagonist.getImageUrl();
        //this.ultimate_limit = protagonist.getUltimate_limit();
        //this.ultimate_weapon = protagonist.getUltimate_weapon();
    }

    public void setId(Protagonist protagonist) {
        this.id = protagonist.getId();
    }
}
