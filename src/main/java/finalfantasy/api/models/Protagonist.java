package finalfantasy.api.models;

import finalfantasy.api.IntermediateTables.GameProtagonist;
import finalfantasy.api.enums.CharacterType;
import finalfantasy.api.enums.GameEdition;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Protagonist extends Character{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator( name = "native", strategy = "native")
    private long id;

    // Biographical information
    private String home;
    private String occupation;

    @OneToMany(mappedBy = "protagonist", fetch = FetchType.EAGER)
    private Set<GameProtagonist> gameProtagonists = new HashSet<>();

    public Protagonist(){}

    public Protagonist(String name, String lastName, String description, String gender, String race, String imageUrl, CharacterType characterType, String home, String occupation) {
        super(name, lastName, description, gender, race, imageUrl, characterType);
        this.home = home;
        this.occupation = occupation;
    }
}
