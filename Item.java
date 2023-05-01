/*
Abby Cicone
Programming Assignment 2: RPG
CPSC 1060: Section 003
4/7/23
*/

public class Item {

    private String name;
    private String description;
    

    // Intialize planet name and description
    public Item (String name, String description) {
        this.name = name;
        this.description = description;
    }

    // Setter and getters for planet name and description
    public void setItemName (String name) {
        this.name = name;
    }

    public String getItemName() {
        return this.name;
    }

    public void setItemDesc (String description) {
        this.description = description;
    }

    public String getItemDesc () {
        return this.description;
    }

}