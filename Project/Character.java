//import
import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

/**
 * Represents a character
 * @param name String for the user chosen name
 * @param canWalk Boolean for whether the character can walk
 * @param canSleep Boolean for whether the character can sleep
 * @param canFly Boolean for whether the character can fly
 * @param changeLocation Boolean for whether the character changed location
 * @param health double for the health of the character
 * @param size double for the size
 * @param originalSize final variable for original size
 * @param bag set array list for the characters bag
 * @param map 2d array for the map of wonderland
 * @param locationC int for characters column number in the 2d array
 * @param locationR int for characters row number in the 2d array
 * @param scan Scanner
 * @param pill String describing pill size
 */

class Character{
    String name;
    Boolean canWalk;
    Boolean canFly;
    Boolean canSleep;
    Boolean changeLocation;
    double health;
    double size;
    final double originalSize;
    ArrayList<String> bag;
    String[][] map = new String[5][5];
    int locationC;
    int locationR;
    Scanner scan;
    String pill;

    /**
     * Constructs a wonderland character.
     * @param name string that stores the characters name.
     * @param locationC the location of the character column on the map.    
     * @param locationR the location of the character row on the map.
     */
    public Character(){
        //Creates the characters physical status and abilities
        this.canWalk = true;
        this.canFly = false;
        this.canSleep = false;
        this.changeLocation = true;
        this.health = 50;
        
        //Creates a mutable and immutable version of character's random size with in a range.
        int s = ThreadLocalRandom.current().nextInt(36, 84 + 1);
        this.size = s;
        this.originalSize = s;

        //Creates Characters bag with set amount of space.
        ArrayList<String> bag = new ArrayList<String>(10);
        this.bag = bag;
    

        //Assigns Random location
        Random random = new Random();
        this.locationC = random.nextInt(5);
        this.locationR = random.nextInt(5);

        //creates place
        this.map = new String[][]{{"You have reached the edge of Wonderland. The sky and sea melt together into one grey plain.", "You walk along the beach to find a bottle of pills washed up on the shore.", "You have reached the light house at the endless sea... ", "After a long trek through the mountains you have reached the top of Mont Jubjub! You can see anything from here", "The far castle!"}, 
        {"You have entered the croquet grounds. An intense game is taking place between Tweedledee and Tweedledum.","You have reached the grandest Castle in all the land, the castle of the queen of hearts.", "Court House", "You have reached the royal rose gardens.", "You are at the base of the mountains of division."}, 
        {"You have reached the Mad Hatters house. It appear there is a tea party in session!", "You have reached the duchesses manner.", "You emerge from the woods into a meadow surrounding a small gabled house. You enter the house on the table is a container of pills.", "You enter a grove of massive mushrooms. Your eyes meet those of caterpillar who ignores you and takes a drag of a long hookah.", "Chilled to the bone you hurry on through the woods in the hopes of finding shelter."}, 
        {"Welcome to the dismal mire...","You found a river. Should you drink the water? It could be dangerous...Strange things happen in Wonderland...", "Giant dragonflies swarm through the sky over your head squabbling over potential perches.","The trees around you begin to morph into oversized mushrooms. You are pleased pick some fungi and arrange them into a bouquet. Your stomach growls...", "You sense someone is watching you in the darkness! Move faster"}, 
        {"You cross the water to find a small door.","You reach the edge of a calm pond. Thirsty, you cup the water to your lips only to spit out a mouthful of tears.","","The forrest thicken. A sign points east saying, 'Enter at your own peril!'", "You wander down another one of the Tulgey woods winding purple roads. Will you ever escape?"}};
        
        //Creates the Scanner for all Character input
        Scanner scan = new Scanner(System.in);
        this.scan = scan;

        //String for pill size
        this.pill = "small";

    }

    /**
     * Runs the play loop for character
     */
    public void play(){
        printSlow("Chose your character!!");
        printSlow("***********************");

        printSlow("Enter your characters name: ");
        String name = scan.nextLine();

        this.name = name;

    }

    /**
     * Creates scanner to take in any user command
     * @return command that the user inputted in lower case
     */
    public String command(){
        printSlow("***********************");
        String command = "Not command";

        if(this.scan.hasNextLine()){
            command = this.scan.nextLine();

        }
        return command.toLowerCase();

    }

    /**
     * Prints statements our slowly using a sleeper function
     * @param text String for the text to be printed
     */
    public void printSlow(String text){
        try {

            char[] textArray = text. toCharArray();

            for (int i = 0; i < textArray.length; i++) {
                //Pause for 4 seconds
                Thread.sleep(30);
                //Print a message
                if (i < textArray.length-1){
                    System.out.print(textArray[i]);

                } else {
                    System.out.println(textArray[i]);

                }
            }
        } catch (Exception e){

        }
    }

    /**
     * Picks up item to add the item to the bag if the place actually has the item.
     * @param command String describing the user input.
     */
    public void grab(String command){
        int openSpots = 0;

        for(String item: bag){
            if (item == null){
                openSpots ++;
            }
        }
        if (openSpots >= 1){

            if (this.map[this.locationC][this.locationR].contains("pill")){
                this.bag.add("pill");

            } else if (this.map[this.locationC][this.locationR].contains("fungi")){
                this.bag.add("fungi");

            }else{
                printSlow("You cannot grab that item.");
            }
        } else {
           printSlow("You are out of space in your bag. Try using the drop function.");
        }
    }

    /**
     * Drops a selected item from the bag.
     * @param command string describing user input.
     */
    public void drop(String command){
        if (command.contains("knife")){
            this.bag.remove("knife");

       } else if (command.contains("fork")){
            this.bag.remove("fork");

       } else if (command.contains("bucket")){
            this.bag.remove("bucket");

       } else if (command.contains("pill")){
            this.bag.remove("pill");

       } else if (command.contains("cake")){
            this.bag.remove("cake");

       } else if (command.contains("scone")){
            this.bag.remove("scone");
       }
    }

    /**
     * Allows user to eat an item
     * @param command String describing the user input.
     */
    public void actionEat(String command){
        if (command.contains("scone")){
            this.bag.remove("scone");
            this.health += 5;

        } if (command.contains("slice of cake")){
            this.bag.remove("cake");
            this.health += 8;
        }
    }

     /**
     * Allows user to drink water
     * @param command String describing the user input.
     */
    public void actionDrink(String command){
        if (command.contains("water")){
            if (this.bag.contains("bucket")){
                this.health += 5;

            }else{
                this.printSlow("You don't have any water to drink.");

            }

        } else if (this.map[this.locationC][this.locationR].contains("water")){
            this.health += 5;

        }else{
            this.printSlow("What do you want to drink?");

        }
        
    }

    /**
     * If the character is in bed function adds 10 points to health or makes health 100.
     */
    public void actionSleep(){

        if (this.health <= 90 && this.canSleep){
            this.health += 10;
            printSlow("💤💤💤");

        } else if (this.health > 90){
            this.health = 100;
            
        } else {
            printSlow("You have to be in bed to sleep silly. ");

        }

    }

    /**
     * Takes pill every other pill is big or small.
     * @param command string describing user input.
     */
    public void actionPill(String command){

        if (command.contains("pill") && this.bag.contains("pill")){
            if (this.pill == "small"){
                this.size /=2;
                printSlow("You begin to shrink. Your size is now " + this.size + "inches tall.");
                this.pill = "big";

            } else if(this.pill == "big"){
                this.size *=2;
                this.printSlow("You begin to grow and grow until you reach " + this.size + "inches tall.");
                this.pill = "small";
            }
            this.bag.remove("pill");

        } else {
            this.printSlow("You may not have what you want to take.");
        
        }     

    } 

     /**
     * Completes action for get in command.
     * @param command String user command.
     */
    public void actionGetIn(String command, String place){
        if (command.contains("bed") && place.contains("bed")){
            this.canSleep = true;
            printSlow("Maybe you should try to sleep before your journey...");

        } else{
            printSlow("What do you want to get in?");

        }
    }

     /**
     * Checks inventory and checks health.
     * @param command string for user input.
     */
    public void actionCheck(String command){
        if (command.contains("inventory")){
            this.inventoryToString();

        } else if (command.contains("health")){
            this.healthToString();

        }
    }

    /**
     * Prints out user inventory.
     */
    public void inventoryToString(){
        int count = 0;

        printSlow("***********************");
        printSlow("Inventory: ");

        for (String item : this.bag){
            printSlow("- " + item);
            count+=1;
        }

        int spaceLeft = 10 - count;

        printSlow("Spaces left: " + spaceLeft);

    }

    /**
     * Prints out character health and an emoji to indicate low or high battery.
     */
    public void healthToString(){

        if (this.health>= 80){
            printSlow(this.name + "'s health is: " + this.health + " 🔋 ");

        } else if (this.health <= 20){
            printSlow(this.name + "'s health is: " + this.health + " 🪫 ");

        } else {
            printSlow(this.name + "'s health is: " + this.health);

        }
    }

   

    /**
     * Creates string to describe character.
     * @return String that describes the character.
     */
    public String toString(){
        String fly;

        if (this.canFly){
            fly = "can";
        } else {
            fly = "cannot";
        }
        return this.name + " is " + this.size + " inches tall. " + this.name + " is located at coordinates (" + this.locationR +", " + this.locationC + ") on the map of Wonderland. Currently alice " + fly + " fly. According to the map: " + this.map[this.locationC][this.locationR];
    }

    public static void main(String[] args){

    }
}

