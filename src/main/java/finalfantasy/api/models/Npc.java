package finalfantasy.api.models;

import finalfantasy.api.enums.CharacterType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Npc extends Character{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator( name = "native", strategy = "native")
    private long id;

    public Npc() {
    }

    public Npc(String name, String lastName, String description, String home, String occupation, String gender, String race, String imageUrl, CharacterType characterType) {
        super(name, lastName, description, home, occupation, gender, race, imageUrl, characterType);
    }
}
