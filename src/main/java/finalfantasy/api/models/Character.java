package finalfantasy.api.models;

import finalfantasy.api.enums.CharacterType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@MappedSuperclass
@Getter
@Setter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator( name = "native", strategy = "native")
    private long id;

    // Personal data
    private String name;
    private String lastName;
    private String description;
    // Biographical information
    private String home;
    private String occupation;
    // Physical description
    private String gender;
    private String race;
    // Portraits
    private String imageUrl;
    // Gameplay details
    private CharacterType characterType;


    public Character() {
    }

    public Character(String name, String lastName, String description, String home, String occupation, String gender, String race, String imageUrl, CharacterType characterType) {
        this.name = name;
        this.lastName = lastName;
        this.description = description;
        this.home = home;
        this.occupation = occupation;
        this.gender = gender;
        this.race = race;
        this.imageUrl = imageUrl;
        this.characterType = characterType;
    }
}
