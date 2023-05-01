default: Driver.java GalaxyMap.java Planet.java Inventory.java Item.java Person.java
	javac Driver.java GalaxyMap.java Planet.java Inventory.java Item.java Person.java

run: Driver.class GalaxyMap.class Planet.class Inventory.java Item.java Person.java
	java Driver

clean:
	rm -f *.class