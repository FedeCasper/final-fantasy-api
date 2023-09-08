package finalfantasy.api.dto;

import finalfantasy.api.enums.GameEdition;
import finalfantasy.api.models.Location;
import lombok.Getter;

import java.util.Set;

@Getter
public class LocationDto {

    private long id;
    private String name;
    private GameEdition origin;
    private String description;
    private Set<String> locationImageSet;

    public LocationDto() {
    }

    public LocationDto(Location location) {
        this.id = location.getId();
        this.name = location.getName();
        this.origin = location.getOrigin();
        this.description = location.getDescription();
        this.locationImageSet = location.getLocationImageSet();
    }

    public void setId(Location location) {
        this.id = location.getId();
    }
}
