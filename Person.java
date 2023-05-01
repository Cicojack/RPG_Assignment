/*
Abby Cicone
Programming Assignment 2: RPG
CPSC 1060: Section 003
4/7/23
*/

public class Person {

    private String dialogue;
    private String name;

    // Initializes the person's dialogue and if they speak basic
    public Person (String name, String dialogue) {
        this.name = name;
        this.dialogue = dialogue;
    }

    // Getter and setter for dialogue and if they speak basic
    public String getPersonDialogue () {
        return dialogue;
    }

    public void setPersonDialogue () {
        this.dialogue = dialogue;
    }

    public String getPersonName () {
        return name;
    }

    public void setPersonName () {
        this.name = name;
    }
}