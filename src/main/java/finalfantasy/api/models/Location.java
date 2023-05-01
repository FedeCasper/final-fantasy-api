package finalfantasy.api.models;

import finalfantasy.api.enums.GameEdition;
import finalfantasy.api.enums.LocationDescription;
import finalfantasy.api.enums.LocationImage;
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
    private LocationDescription description;
    @ElementCollection
    private Set<LocationImage> locationImageSet = new HashSet<>();
    @ManyToOne(fetch = FetchType.EAGER)
    private Game game;

    public Location() {
    }

    public Location(String name, GameEdition origin, LocationDescription description, Set<LocationImage> locationImageSet, Game game) {
        this.name = name;
        this.origin = origin;
        this.description = description;
        this.locationImageSet = locationImageSet;
        this.game = game;
    }
}
