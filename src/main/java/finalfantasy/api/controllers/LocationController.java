package finalfantasy.api.controllers;

import finalfantasy.api.dto.LocationDto;
import finalfantasy.api.models.Game;
import finalfantasy.api.models.Location;
import finalfantasy.api.models.Protagonist;
import finalfantasy.api.repositories.GameRepository;
import finalfantasy.api.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class LocationController {

    @Autowired
    GameRepository gameRepository;

    @Autowired
    LocationRepository locationRepository;

    @GetMapping("/locations")
    public List<LocationDto> getAllLocations(){
        return locationRepository.findAll().stream().map(location -> new LocationDto(location)).collect(Collectors.toList());
    }

    @PostMapping("/newLocations")
    public ResponseEntity<Object> createLocations(@RequestBody List<Location> locationList){

        List<Game> gameList = gameRepository.findAll();

        for(Game game : gameList){
            for(Location location : locationList){

                if(game.getAvailableLocationsList().contains(location.getName())){

                    Location newLocation = new Location(location.getName(), location.getOrigin(), location.getDescription(),location.getLocationImageSet(), game);
                    locationRepository.save(newLocation);
                }

            }
        }

        return new ResponseEntity<>(locationList.size() + " locations has benn created", HttpStatus.OK);
    }
}
