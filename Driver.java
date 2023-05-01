/*
Abby Cicone
Programming Assignment 2: RPG
CPSC 1060: Section 003
4/7/23
*/

import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Driver {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        GalaxyMap map = new GalaxyMap();
        Inventory inv = new Inventory();
        boolean search = true;
        String input = "";
        int move = 0;
        int trophy = 0;
        int score = 0;

        // Opening menu
        System.out.println("THE SEARCH FOR LUKE SKYWALKER");
        System.out.println("-----------------------------");
        System.out.println("          ENTER START        ");
        System.out.println("-----------------------------");
        System.out.println("");
        String start = scnr.next();

        // Intialize planet
        Planet Tatooine = new Planet("Tatooine", "A desolate desert planet located on the outer rims. It is home to a wide array of scum and villany. If you wish to make it off the planet alive, make sure to have a trusty blaster by your side.");
        Planet Naboo = new Planet("Naboo","A lush planet with a diverse amount of flora and fauna. Here on Naboo, humans and gungans live in harmony. Lucky travlers are able to pick up wandering gungans who loyal, albiet annoying, companions.");
        Planet Dagobah = new Planet("Dagobah", "A swampy planet covered in a thick sheet of fog. If you're afraid of creepy crawly creatures, it would be best to stay clear of this planet.");
        Planet Hoth = new Planet("Hoth", "BRRR, this icy planet is cold and unforgiving. You must tread carefully or else meet your end in the hands of a hungry wampa.");
        Planet Endor = new Planet("Endor", "Home to the Ewoks and the forests they call home. Don't get their bad side or you'll turn into an afternoon snack. Look closely and you may find the final resting place of the sith lord Darth Vader");
        Planet Coruscant = new Planet("Coruscant", "A city covered in metal skyscrapers, Coruscant is the political center of the galaxy and at one point the home of the Jedi Temple, the Senate, and Dex's Diner.");
        Planet Yavin4 = new Planet("Yavin 4","Home to the first Rebel base, Yavin 4 is made of mostly jungle and remnants of an ancient species of alien. From this planet, the Rebels made a final desparate attempt to destroy Death Star I");
        Planet Kashyyyk = new Planet("Kashyyyk", "What about the droid attack on the wookies? Kashyyyk is much like Endor, covered in forests and home to furry creatures. In this case, the furry creatures are seven feet tall and can rip off your arms.");
        Planet Mustafar = new Planet("Mustafar", "A tiny fiery planet, Mustafar is the perfect place to mine valuable minerals or have a brutal and lengthy duel with your former jedi master");
        Planet Jakku = new Planet("Jakku", "Another desolate desert planet, Jakku is even smaller and less populated. Most of the population make their living scavenging the towering spacecraft that have crashed on its surface.");
        Planet AhchTo = new Planet("Ahch-To","An ocean planet sparsely covered in island, it is the perfect place for one to disapper. It is also the birthplace of the Jedi Order, and the location first Jedi Temple");
        
        // Initialize person
        Person Jedi = new Person ("Luke_Skywalker", "Leave me alone."); // Ahch To
        Person Wookie = new Person("Tarfful","I don't know of any jedi, they all died a long time ago. The last jedi I knew went to Dagobah."); // Kashyyyk
        Person BountyHunter = new Person("Bossk","Mind you own business, fleshy thing."); // Mustafar
        Person Dex = new Person("Dexter_Jester","Ah yes, the Jedi. Their HQ of sorts was located here but after Order 66, they all scattered. Try checking in the outer rim."); // Coruscant
        Person PodRacer = new Person("Sebulba","If you're looking for a jedi, you won't find them here. Those stuck up poodos live on Coruscant."); // Tatooine
        Person Smuggler = new Person("Crimson_Corsair","I heard about a jedi living in the ruins of Yavin 4. But you didn't hear that from me."); // Naboo
        Person Scavenger = new Person("Lor_San_Tekka", "When I was a much younger man, I read about the first Jedi temple, located on Ahch To. Skywalker may have gone there.");  // Jakku
        Person Astromech = new Person("R5-D4","There aren't any jedi here, friend. After the first Death Star exploded, the Rebels relocated to Hoth. You might find some jedi there."); // Yavin 4
        Person Ewok = new Person("Wicket_W._Warrick", "A jedi arrived with the golden god but he left long ago."); // Endor

        // Intialize item
        Item Lightsaber = new Item ("Lightsaber","An elegant weapon for a more civilized age."); // Dagobah
        Item Blaster = new Item ("DL-18_Blaster","Hokey religions and ancient weapons are no match for a good blaster."); // Yavin 4
        Item Helmet = new Item("Rebel_Trooper_Helmet","This green colored helmet was used by the rebel soldiers during the Battle of Endor"); // Endor
        Item Motivator = new Item("Hyperdrive_Motivator","This hyperdrive motivator broke a long time ago and now wastes away in this junkyward."); // Tatooine
        Item Jetpack = new Item("Jetpack","They fly now?! They fly now!"); // Naboo
        Item Holocron = new Item("Holocron","Palm sized glowing polyhedrons used by both the jedi and sith to store information."); // Coruscant
        Item Bowcaster = new Item("Bowcaster","This powerful weapon is fit only for the massive wookies."); // Kashyyyk
        Item Droid = new Item("Probe_Droid","The remains of an Imperial age probe droid."); // Hoth
        Item Hand = new Item("Metal_Hand","This metal right hand has been disconnected from the main body."); // Mustafar
        Item Porg = new Item("Porg","*Porg noises*"); // Ahch To
        Item Translator = new Item ("Translator", "A helpful tool that allows you to understand most aliens you speak to.");


        // Add planet to map
        map.addPlanet(Tatooine);
        map.addPlanet(Naboo);
        map.addPlanet(Dagobah);
        map.addPlanet(Hoth);
        map.addPlanet(Endor);
        map.addPlanet(Coruscant);
        map.addPlanet(Yavin4);
        map.addPlanet(Kashyyyk);
        map.addPlanet(Mustafar);
        map.addPlanet(Jakku);
        map.addPlanet(AhchTo);

        // Add exits to each planet
         // Tatooine exits
        Tatooine.addExit("Naboo");
        Tatooine.addExit("Coruscant");
        Tatooine.addExit("Hoth");
        // Coruscant exits
        Coruscant.addExit("Jakku");
        Coruscant.addExit("Mustafar");
        Coruscant.addExit("Kashyyyk");
        Coruscant.addExit("Tatooine");
        // Kashyyyk exits
        Kashyyyk.addExit("Mustafar");
        Kashyyyk.addExit("Coruscant");
        // Jakku exits
        Jakku.addExit("Coruscant");
        // Naboo exits
        Naboo.addExit("Endor");
        Naboo.addExit("Hoth");
        Naboo.addExit("Yavin4");
        Naboo.addExit("Tatooine");
        // Hoth exits
        Hoth.addExit("Dagobah");
        Hoth.addExit("Tatooine");
        Hoth.addExit("Naboo");
        // Yavin 4 exits
        Yavin4.addExit("Naboo");
        Yavin4.addExit("Dagobah");
        // Dagobah exits
        Dagobah.addExit("Yavin-4");
        Dagobah.addExit("Hoth");
        // Endor exits
        Endor.addExit("Naboo");
        Endor.addExit("Ahch-To");
        // Ahch to exits
        AhchTo.addExit("Endor");
        // Mustafar Exits
        Mustafar.addExit("Kashyyyk");
        Mustafar.addExit("Coruscant");

        // Add items and people to each planet
        // Tatooine
        Tatooine.addItem(Motivator);
        Tatooine.addPerson(PodRacer);
        //Coruscant
        Coruscant.addItem(Holocron);
        Coruscant.addPerson(Dex);
        // Kashyyyk
        Kashyyyk.addItem(Bowcaster);
        Kashyyyk.addPerson(Wookie);
        // Naboo
        Naboo.addItem(Jetpack);
        Naboo.addPerson(Smuggler);
        // Hoth
        Hoth.addItem(Droid);
        // Yavin 4
        Yavin4.addItem(Blaster);
        Yavin4.addPerson(Astromech);
        // Dagobah
        Dagobah.addItem(Lightsaber);
        // Endor
        Endor.addPerson(Ewok);
        Endor.addItem(Helmet);
        // AhchTo
        AhchTo.addPerson(Jedi);
        AhchTo.addItem(Porg);
        // Jakku
        Jakku.addPerson(Scavenger);
        // Mustafar
        Mustafar.addPerson(BountyHunter);
        Mustafar.addItem(Hand);
        

        // Start game
        if (start.equalsIgnoreCase("start")) {
            System.out.println("Welcome to the Search for Luke Skywalker. You are a rebel spy tasked with searching for the fabled Luke Skywalker.");
            System.out.println("Fly to planets around the galaxy in your trusty ship, to collect clues from helpful aliens.");
            System.out.println("Additionally, there are a total of 11 trophies to be found.");
            System.out.println("If you're having issues with certain commands, type help.");
            System.out.println("Type end to pass the search on to another rebel spy.");
            System.out.println("-----------------------------");
            Planet planet = Tatooine;
            inv.addItem(Translator);

            while (search) {
                System.out.println(planet);
                try {
                    System.out.println("Please enter an action:");
                    input = scnr.next().toLowerCase();
                }
                catch (InputMismatchException e) {
                    System.out.println("This isn't the command you're looking for.");
                    System.out.println("-----------------------------"); 
                }

                if (input.equalsIgnoreCase("help")) { // help
                    System.out.println("Here is a list of useful commands");
                    System.out.printf("\t- Look: looks at present people or items on the planet.\n");
                    System.out.printf("\t- Leave: Leaves the planet you are currently on.\n");
                    System.out.printf("\t- Take: Adds item to inventory.\n");
                    System.out.printf("\t- Inventory: View inventory\n");
                    System.out.printf("\t- Speak: Speaks to people on planet.\n");
                    System.out.printf("\t- End: Ends game\n");
                    System.out.println("-----------------------------");
                    continue;
                }

                else if (input.equalsIgnoreCase("look")) { // list people on planet
                    System.out.println("What would you like to look at, people or items?");
                    String look = scnr.next();
                    if (look.equalsIgnoreCase("people")) { // no people
                        if (planet.getPeople().size() == 0) {
                            System.out.println("There seems to be no evidence of intelligent life anywhere.");
                            System.out.println("-----------------------------");
                        }
                        else {
                            System.out.println(planet.listPeople());
                        }
                    }
                    else if (look.equalsIgnoreCase("items")) {
                        if (planet.getItems().size() == 0) { // no items
                            System.out.println("No items available.");
                            System.out.println("-----------------------------");
                        }
                        else {
                            System.out.println(planet.listItems());
                        }    
                    }
                    // validates that user inputed people or items
                    while (!look.equalsIgnoreCase("people") && !look.equalsIgnoreCase("items")) {
                        System.out.println("The dark side has clouded you vision and you cannot see this.");
                        System.out.println("-----------------------------");
                        System.out.println("What would you like to look at, people or items?");
                        look = scnr.next();
                    }

                continue;
                }
                else if (input.equalsIgnoreCase("leave")) { // players leaves planet and chooses exit
                    System.out.println("Please choose a planet.");
                    System.out.println(planet.listExits());
                    String direction = scnr.next().toLowerCase();

                    // Validate direction
                    while (!planet.listExits().toLowerCase().contains(direction)) {
                        System.out.println("I hate to say it, but it looks like the planet you're searching for doesn't exist.");
                        System.out.println("Please choose a planet.");
                        direction = scnr.next().toLowerCase();
                        planet.listExits().toLowerCase().contains(direction);
                    } 
                    move ++;
                    planet = map.getPlanet(direction);
                    continue;
                }

                else if (input.equalsIgnoreCase("take")) { // take item
                    if (planet.getItems().size() == 0) { 
                        System.out.println("No items available");
                    }
                    else {
                        System.out.println("Please select an item you would like to take");
                        System.out.println(planet.listItems());
                        String take = scnr.next().toLowerCase();

                        // Validate item
                        while (!planet.listItems().toLowerCase().contains(take)) {
                            System.out.println("You cannot take this item.");
                            System.out.println("Please select an item you would like to take");
                            take = scnr.next().toLowerCase();
                            planet.listItems().toLowerCase().contains(take);
                        } 
                        // Adds item to inventory and removes it from planet
                        for (Item i : planet.getItems()) {
                            if (i.getItemName().equalsIgnoreCase(take)) {
                                inv.addItem(i);
                                planet.removeItem(i);
                                trophy ++;
                                break;
                            }
                        }
                    }
                    continue;
                }

                else if (input.equalsIgnoreCase("speak")) { // user wishes to speak to someone
                    if (planet.getPeople().size() == 0) {
                            System.out.println("There seems to be no evidence of intelligent life anywhere.");
                            System.out.println("-----------------------------");
                    }
                    else {
                        System.out.println("Who would you like to speak to?");
                        System.out.println(planet.listPeople());
                        String talk = scnr.next().toLowerCase();

                        // validates the person
                        while (!planet.listPeople().toLowerCase().contains(talk)) {
                                System.out.println("You cannot speak to this person.");
                                System.out.println("Please select a person you would like to speak to");
                                talk = scnr.next().toLowerCase();
                                planet.listPeople().toLowerCase().contains(talk);
                            } 
                        // Gets dialogue
                        for (Person p: planet.getPeople()) {
                            if (p.getPersonName().equalsIgnoreCase(talk)) {
                                System.out.println(p.getPersonName() + ": " + p.getPersonDialogue());
                                System.out.println("-----------------------------");
                            }
                            // User has won and found Luke Skywalker
                            if (p.getPersonName().equalsIgnoreCase("Luke_Skywalker")) {
                                System.out.println("You have found Luke Skywalker! But he doesn't seem very happy to see you.");
                                System.out.println("Score: " + move); // score is based on total moves
                                System.out.println("Trophys Found: "+ trophy);
                                System.out.println("-----------------------------");
                                System.out.println("Would you like to play again?");
                                String again = scnr.next();
                                    if (again.equalsIgnoreCase("Yes")){
                                        search = true;
                                        planet = Tatooine;
                                    }
                                    else if (again.equalsIgnoreCase("No")) {
                                        System.out.println("Thanks for playing");
                                        search = false;
                                    }
                            }
                        }
                    }
                    continue;
                }
                // User wants to see inventory
                else if (input.equalsIgnoreCase("inventory")) {
                    inv.listItems();
                    System.out.println("-----------------------------");
                    continue;
                }
                // Ends game prematurely
                else if (input.equalsIgnoreCase("end")) {
                    System.out.println("Goodbye");
                    search = false;
                }
                // User inputs wrong command
                else {
                    System.out.println("This isn't the command you're looking for.");
                    System.out.println("-----------------------------"); 
                    continue;
                }
            }
        } 
        // Start is not entered
        else {
            System.out.println("Power Off");
        }
    }
}