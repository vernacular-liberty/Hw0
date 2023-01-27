//imports
import java.util.ArrayList;

/**
 * Represents march manor
 * @param floors array list of strings for the story on each floor
 * @param character the users character
 * @param inHouse whether the character is in the house
 * @param newRoom whether the character is in a new room
 * @param index int for the floor the character is on
 * @param kitchen string describing the kitchen
 * @param inKitchen Boolean for the fire being on
 * @param fire boolean for if there is a fire
 * @param pill string for the pill size
 * @param numCake int for amount of cake slices
 */
public class MarchManor {
    ArrayList<String> floors;
    Character character;
    Boolean inHouse;
    Boolean newRoom;
    Boolean inKitchen;
    Boolean fire;
    int index;
    String kitchen;
    String pill;
    int numCake;

    /**
     * Constructs a two story house many features.
     * @param character Character representing the users character.
     */
    public MarchManor(Character character){

        this.character = character;

        //construct array list for the floors
        ArrayList<String> floors = new ArrayList<String>();
        floors.add("Behind the door is a quaint room complete with a fireplace and a simple kitchen along the far wall. Strangely you cannot find a staircase, you swore it was a two story house when you entered.");
        floors.add("You enter a small attic bed room. On the desk sits a small blue bottle of pills.");
        this.floors = floors;

        //Strings describing kitchen and pill
        String kitchen = "On the kitchen counter is a decadent carrot cake, a fork and a bucket of water.";
        String pill = "big";
        this.kitchen = kitchen;
        this.pill = pill;

        // variables describing character location and area status
        this.inHouse = false;
        this.newRoom = true;
        this.inKitchen = false;
        this.fire = true;
        this.index = 0;
        this.numCake = 6;

    }

    /**
     * Game loop for the manor class
     */
    public void play(){
        this.character.printSlow("Type \"enter\" if you want to go into the house.");

        String start = this.character.command();
        userAction(start);

        String command;

        if (start.contains("enter")){

            while (this.inHouse){

                if (this.newRoom == true){
                    this.newRoom = false;

                    System.out.println(this.floors.get(this.index));
                }
                command = this.character.command();
                userAction(command);

            }

            this.character.printSlow("You learned your less: do not go through other peoples things.");

        }

    }

    /**
     * Finds the action key word in the command
     * @param command string for user input
     */
    public void userAction(String command){
        if (command.contains("enter")){
            actionEnter();

        } else if (command.contains("investigate") || command.contains("check out") || command.contains("go to")){
            actionInvestigate(command);

        } else if (command.contains("take") || command.contains("grab")){
            actionTake(command);

        } else if (command.contains("eat")){
            actionEat(command);

        } else if (command.contains("drink")){
            this.character.actionDrink(command);

        }else if (command.contains("put out fire")){
            actionFire(command);

        } else if (command.contains("climb") || command.contains("go down") || command.contains("go up")){
            actionClimb(command);

        } else if (command.contains("get in")){
            this.character.actionGetIn(command, this.floors.get(this.index));

        } else if (command.contains("sleep")){
            this.character.actionSleep();

        } else if (command.contains("swallow") || command.contains("use")){
            this.character.actionPill(command);

        } else if (command.contains("exit") || command.contains("go outside") || command.contains("unlock") || command.contains("open")){
            actionExit(command);

        } else if (command.contains("check")){
            this.character.actionCheck(command);
            
        } else if (command.contains("drop")){
            this.character.drop(command);
            
        } else if (command.contains("clue")){
            printCommand();
        }else {
            this.character.printSlow("I don't know that command yet.");
        }

    }

    /**
     * Changes boolean for in house to true
     */
    public void actionEnter(){
        this.inHouse = true;

    }

    /**
     * Exits the house if there is a door in the location.
     * @param command String describing user input
     */
    public void actionExit(String command){
        if (this.floors.get(this.index).contains("door") && command.contains("door")){
            this.inHouse = false;

        } else {
            this.character.printSlow("How are you trying to exit?");

        }

    }

    /**
     * If the user goes to the kitchen prints out kitchen description.
     * @param command string describing user input.
     */
    public void actionInvestigate(String command){
        if (this.floors.get(this.index).contains("kitchen") && command.contains("kitchen")){
            this.inKitchen = true;
            this.character.printSlow(this.kitchen);

        } else if (this.floors.get(this.index).contains("fireplace") && command.contains("fireplace")){
            this.character.printSlow("The fire is burning hot.");
        }
    }

    /**
     * Takes objects and adds them to the characters bag.
     * @param command String for user command.
     */
    public void actionTake(String command){

        if (command.contains("fork") == false && command.contains("pill") == false && command.contains("bucket") == false && command.contains("water") == false){
            this.character.printSlow("What are you attempting to take?");

        } else if (command.contains("fork") && this.inKitchen){
            this.character.bag.add("fork");

        } else if ((command.contains("bucket") || command.contains("water")) && this.inKitchen){
            this.character.bag.add("bucket");

        } else if (command.contains("pill") && this.floors.get(this.index).contains("pill")){
            this.character.bag.add("pill");
            this.character.printSlow("Use the use or swallow command to take the pill.");
             
        } else if ((command.contains("cake")) && this.inKitchen){
            this.character.bag.add("cake");
            this.character.printSlow("Yummy 🍰 ");
        }
       
    }

    /**
     * If the user wants to eat cake and there is cake adds health.
     * @param command String for user input.
     */
    public void actionEat(String command){
        if (command.contains("cake")){
            if (this.numCake >= 1){
                if(this.character.bag.contains("fork")|| this.inKitchen){
                    this.character.health += this.character.health/4;
                    this.numCake -= 1;
    
                } else{
                    this.numCake = 0;
                    this.character.health = 100;
                }
                this.character.printSlow(this.character.name +"'s health is "+ this.character.health);

            }

        } else {
            this.character.printSlow("What do you want to eat?");
        }
    }

    /**
     * Puts out fire if the user has a bucket of water.
     * @param command string describing user input.
     */
    public void actionFire(String command){
        if (this.character.bag.contains("bucket")){
            this.fire = false;
            this.character.printSlow("You look up the chimney and see a narrow ladder.");

        } else {
            this.character.printSlow("You cannot put out the fire because you do not have a bucket.");
        }
    }

    /**
     * Climbs the lader up or down if the character can fit through the chimney.
     * @param command string describing user input.
     */
    public void actionClimb(String command){
        if (this.fire == false){
            if ( this.character.size <= 80){
                if (this.index == 0){
                    this.index += 1;
                    this.character.health -= 5;

                } else if (this.index == 1){
                    this.index -= 1;
                    this.character.health -= 5;
                }
                this.newRoom = true;

            } else{
                this.character.printSlow("You are too big to go through the chimney.");

            }

        } else{
            this.character.printSlow("The fire is still burning!");

        }
    }

    /**
     * Prints out some clues for commands to try.
     */
    public void printCommand(){
        this.character.printSlow("+--------------------------------+");
        this.character.printSlow("|   Some Commands to try:        |");
        this.character.printSlow("|   - 'take'                     |");
        this.character.printSlow("|   - 'drop'                     |");
        this.character.printSlow("|   - 'sleep'                    |");
        this.character.printSlow("|   - 'swallow'                  |");
        this.character.printSlow("+--------------------------------+");

    }

    public static void main(String[] args){
        Character a = new Character();
        MarchManor m = new MarchManor(a);
        m.play();
    }
}
