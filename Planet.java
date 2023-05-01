/*
Abby Cicone
Programming Assignment 2: RPG
CPSC 1060: Section 003
4/7/23
*/

import java.util.ArrayList;

public class Planet {

    // Variables
    private String name;
    private String description;
    private ArrayList<String> exits;
    private ArrayList<Item> items;
    private ArrayList<Person> people;

    // Intializes room
    public Planet(String name, String description) {
        this.name = name;
        this.description = description;
        exits = new ArrayList<>();
        items = new ArrayList<>();
        people = new ArrayList<>();
    }

    // Getters and setters for names and descriptions of planet
    public void setPlanetName () {
        this.name = name;
    }

    public String getPlanetName () {
        return this.name;
    }

    public void setPlanetDesc () {
        this.description = description;
    }

    public String getPlanetDesc () {
        return this.description;
    }

    // Adds exit to the planet
    public void addExit (String exit) {
        exits.add(exit);
    }

    // Adds people to the planet
    public void addPerson (Person person) {
        people.add(person);
    }

    // Adds items to the planet
    public void addItem (Item item) {
        items.add(item);
    }

    // Get all people
    public ArrayList<Person> getPeople () {
        return people;
    }

    // Get all items
    public ArrayList<Item> getItems () {
        return items;
    }

    // Returns string form of lists
    public String listExits() {
        String allExits = "Exits: \n";
        for (String exit: exits) {
            allExits += exit + "\n";
        }
        return allExits;
    }

    public String listItems () {
        String allItems = "These are the items you can see: \n";
        for (Item item: items) {
            allItems += item.getItemName() + "\n";
        }
        return allItems;
    }

    public String listPeople () {
        String allPeople = "These are the people around you: \n";
        for (Person person: people) {
            allPeople += person.getPersonName() + "\n";
        }
        return allPeople;
    }

    // Returns the string form of the planet name and planet description
    public String toString () {
        return getPlanetName() + ": " + getPlanetDesc();
    }

    public void removeItem (Item item) {
        if (items.contains(item)) {
            items.remove(item);
        }
        else {
            System.out.println("This item is not available.");
        }
    }

}