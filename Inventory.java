/*
Abby Cicone
Programming Assignment 2: RPG
CPSC 1060: Section 003
4/7/23
*/

import java.util.ArrayList;

public class Inventory {
    
    private ArrayList<Item> inventory;

    public Inventory() {
        inventory = new ArrayList<>();
    }

    public void addItem(Item item) {
        inventory.add(item);
        System.out.println(item.getItemName() + " added to inventory.");
        System.out.println("-----------------------------");
    }

    public void listItems() {
        if (inventory.size() == 0) {
            System.out.println("Inventory is empty.");
        } else {
            System.out.println("Items in inventory:");
            for (Item item : inventory) {
                System.out.println(item.getItemName());
            }
        }
}
}