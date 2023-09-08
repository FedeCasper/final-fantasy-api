package finalfantasy.api.models;

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
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    private String name;
    private GameEdition origin;
    private String description;
    @ElementCollection
    private Set<String> locationImageSet = new HashSet<>();
    @ManyToOne(fetch = FetchType.EAGER)
    private Game game;

    public Location() {
    }

    public Location(String name, GameEdition origin, String description, Set<String> locationImageSet, Game game) {
        this.name = name;
        this.origin = origin;
        this.description = description;
        this.locationImageSet = locationImageSet;
        this.game = game;
    }
}
