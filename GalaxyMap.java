/*
Abby Cicone
Programming Assignment 2: RPG
CPSC 1060: Section 003
4/7/23
*/

import java.util.HashMap;

public class GalaxyMap {
    
    HashMap<String, Planet> map;

    // Initialize galaxy map
    public GalaxyMap() {
        map = new HashMap<>();
    }

    // Adds planet to map
    public void addPlanet (Planet planet) {
        map.put(planet.getPlanetName().toLowerCase(), planet);
    }

    // Gets planet from map
    public Planet getPlanet (String planetName) {
        return map.get(planetName);
    }


}