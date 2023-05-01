package finalfantasy.api.dto;

import finalfantasy.api.enums.GameEdition;
import finalfantasy.api.enums.LocationDescription;
import finalfantasy.api.enums.LocationImage;
import finalfantasy.api.models.Game;
import finalfantasy.api.models.Location;
import lombok.Getter;

import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.util.HashSet;
import java.util.Set;

@Getter
public class LocationDto {

    private long id;
    private String name;
    private GameEdition origin;
    private LocationDescription description;
    private Set<LocationImage> locationImageSet;
    private Game game;

    public LocationDto() {
    }

    public LocationDto(Location location) {
        this.name = location.getName();
        this.origin = location.getOrigin();
        this.description = location.getDescription();
        this.locationImageSet = location.getLocationImageSet();
    }
}
