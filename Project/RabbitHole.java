//import
import java.util.ArrayList;

/**
 * Represents the rabbit hole 
 * @param character Character representing the user
 * @param inHole Boolean for whether the character is in the rabbit hole
 * @param readBook Boolean for whether the book has been read
 * @param spreadJam Boolean for whether jam was spread
 * @param changeFloors Boolean for whether floor or index in array list changed
 * @param doorLock Boolean for whether the door is locked
 * @param byTaboret Boolean for whether the character is by the taboret
 * @param events array list for the different events as you fall down the rabbit hole
 * @param index int for the current index in events
 * @param numTea int for the number of cups of tea 
 * @param numScone int for the number of scones
 * @param book string for first page of the book
 * @param bottom String describing the bottom level of the rabbit hole
 * @param taboret String describing on top of the taboret.
 * @param changeFloor boolean for whether the floor changed 
 */
public class RabbitHole {
    Character character;
    Boolean inHole;
    Boolean readBook;
    Boolean hasJam;
    Boolean changeFloor;
    Boolean doorLock;
    Boolean byTaboret;
    ArrayList<String> events;
    int index;
    int numTea;
    int numScone;
    String book;
    String bottom;
    String taboret;

    /**
     * Constructs rabbit hole.
     * @param character the character playing the game
     */
    public RabbitHole(Character character){
        //Creates Character
        this.character = character;

        //Character Status extras for rabbit hole
        this.inHole = true;
        this.readBook = false;
        this.hasJam = false;
        this.changeFloor = true;
        this.doorLock = true;
        this.byTaboret = false;

        //Create list of events in the rabbit Hole
		ArrayList<String> eventsL = new ArrayList<String>();
        eventsL.add("As you fall a table floats by. You peer over to see a gingham table cloth set with three cups of tea and a plate of scones. A small knife sticks out of a pot of jam.");
        eventsL.add("A beautiful feather bed floats by you.");
        eventsL.add("You plop into an antique wingback chair and spin towards a desk with an open book.");
        this.events = eventsL;
        this.index = 0;

        //inventory for tea party
        this.numTea = 3;
        this.numScone = 5;

        //Special strings for specific places
        this.book = "\"Welcome to Wonderland!\"";
        this.bottom = "'Wonderland', you think, 'What on earth...' As you day dream the chair harshly crashes into the floor. You get up and walk around the sparse room with only one door and a very small taboret.";
        this.taboret = "On the taboret there is a small bottle of pills and a key.";

    }
    
    /**
     * Runs rabbit hole game loop.
     */
    public void play(){
        //prints opening sequence
        this.character.printSlow("In an effort to avoid the plague of daily life you decide to take a walk by the pond. To your surprise you see a white rabbit reach into his waist coat pocket and pull out a pocket watch.");
        this.character.printSlow("    \"Excuse me Mr. Rabbit, may I ask...\", you call in confusion.");
        this.character.printSlow("    \"Can you not see I'm late!\", the rabbit proclaims as he hops away. A rabbit who talks, bizarre, you must go after him!");
        this.character.printSlow("    \"Wait for me Mr. Rabbit\", you call out as you chase him through the woods. As you round a bend you see the tip of his white tail disappear into a hole beneath some gnarly tree roots. Consumed by curiosity you go after him head first down the rabbit hole.");
        this.character.printSlow("The tunnel goes straight down towards the center of the earth. At first you fall quickly, but soon physics wanes and you slow to a downward float.");
        this.character.printSlow(" ");
        this.character.printSlow("Try a simple command to interact with your surroundings. EX: 'drink tea', or 'clue'");
        this.character.printSlow(" ");

        //Game loop
        while (this.inHole){

            while (this.changeFloor){
                this.character.printSlow(this.events.get(this.index));
                this.changeFloor = false;

            }
            String command = this.character.command();
            userAction(command);
    
        }
        
    }

    /**
     * Finds Action key word and calls the specific actions function.
     * @param command String for user input.
     */
    public void userAction(String command){

        if (command.contains("read")){
          actionRead(command);

        } else if (command.contains("drink")){
            actionDrink(command);

        } else if(command.contains("take") || command.contains("grab") ){
            actionTake(command);

        } else if (command.contains("get in")){
           this.character.actionGetIn(command, this.events.get(this.index));

        } else if (command.contains("sleep")){
            this.character.actionSleep();     

        } else if (command.contains("investigate") || command.contains("check out") || command.contains("go to")){
            actionInvestigate(command);

        }else if(command.contains("spread")){
           actionSpread(command);

        } else if (command.contains("eat")){
            actionEat(command);

        } else if(command.contains("down")){
            actionDown();
            
        } else if (command.contains("check")){
            this.character.actionCheck(command);

        } else if (command.contains("drop")){
            this.character.drop(command);

        } else if (command.contains("clue")) {
            actionClue();

        } else if (command.contains("open") || command.contains("unlock")||command.contains("enter")){
            actionOpen(command);

        } else if (command.contains("swallow") || command.contains("use")){
            this.character.actionPill(command);

        }else {
            this.character.printSlow("I don't know that command yet.");

        } 
        
    }

    /**
     * Completes user action for take command.
     * @param command String for user command
     */
    public void actionTake(String command){
        if (command.contains("knife") && this.events.get(this.index).contains("knife")){
            this.character.bag.add("knife");
            this.character.printSlow("You now have a knife. What do you want to do with it?");
    
        } else if (command.contains("scone") && this.events.get(this.index).contains("scone") && this.numScone>=1){
            this.character.bag.add("scone");
            this.numScone-=1;
            this.character.printSlow("You now have a scone. What do you want to do with it?");

        } else if (command.contains("key") && this.byTaboret){
            this.character.bag.add("key");

        } else if (command.contains("pill") && this.byTaboret){
            this.character.bag.add("pill");

        }else {
            this.character.printSlow("What do you want to take?");
    
        }
    }

    /**
     * Completes user action for spread command.
     * @param command String for user command,
     */
    public void actionSpread(String command){
        if (this.character.bag.contains("knife")){
            if (command.contains("jam")){
                if (this.events.get(this.index).contains(" jam" )){
                    this.hasJam = true;
                    this.character.printSlow("Mmmm, what do you want to do now?");
                    
                } else {
                    this.character.printSlow("There is no jam here.");
                
                }
    
            } else{
                this.character.printSlow("What do you want to spread? ");

            }

        } else {
            this.character.printSlow("You need a knife!");

        }
       
    }

    /**
     * Completes user action for eat command.
     * @param command String for user command.
     */
    public void actionEat(String command){

        if (command.contains("scone")){

            if (this.character.bag.contains("scone")){

                if (this.hasJam){
                    if(this.character.health <= 92){
                        this.character.health +=8;
            
                    } else if(this.character.health > 92 ){
                        this.character.health = 100;
            
                    }

                    this.hasJam = false;

                } else {
                    if (this.character.health <= 95 ){
                        this.character.health += 5;
            
                    } else if (this.character.health > 95){
                        this.character.health =100;

                    }

                }

                this.character.drop("scone");


            } else {
                this.character.printSlow("You do not have a scone in your inventory.");

            }

        } else {
            this.character.printSlow("What do you want to eat?");

        }
    }



    /**
     * Completes user action for drink command and subtracts tea from total tea
     * @param command String for user command.
     */
    public void actionDrink(String command){
        if (command.contains("tea") && this.events.get(this.index).contains("tea") && numTea >= 1 && this.character.health <= 95){
            this.character.health +=5;
            this.numTea -= 1;

        } else {
            this.character.printSlow("What do you want to drink?");

        }
    }

    /**
     * Completes user action for read command and changes readBook to true to indicate that the user can access the level on the bottom floor.
     * @param command String for user command.
     */
    public void actionRead(String command){
        if (this.events.get(this.index).contains("book")){
            if (command.contains("book")){
                this.character.printSlow("You open the book, on the first page it says: " + this.book);
                this.readBook = true;
                this.character.printSlow(this.bottom);
    
            } else {
                this.character.printSlow("What do you want to read?");
    
            }

        } else{
            this.character.printSlow("There is nothing to read here");

        }
        
    }    

    /**
     * Opens the door if the user is big enough lets them through.
     * @param command String for user input.
     */
    public void actionOpen(String command){
        if (command.contains("door")){
            if (this.readBook){
                if (this.character.bag.contains("key")){
                    if (this.character.size <= 30){
                        this.inHole = false;
            
                    } else {
                        this.character.printSlow("You successfully unlock the door, but you are too big to get through...");
        
                    }

                } else {
                    this.character.printSlow("You cannot unlock the door.");
                }
                
            } else {
                this.character.printSlow("There is no door for you too open here.");

            }
        }
        
        
    }

    /**
     * Moves the user down to the next level
     */
    public void actionDown(){
        if (this.index < 2){
            this.index += 1;
            this.changeFloor = true;

        } else {
            this.character.printSlow("You cannot go down any furthers");
        }
    }

    /**
     * Allows the user to investigate a selected area
     * @param command String for user input.
     */
    public void actionInvestigate(String command){
        if (command.contains("taboret") && this.readBook){
            if (this.readBook){
                this.byTaboret = true;
                this.character.printSlow(this.taboret);

            } else {
                this.character.printSlow("You are not on the same level as the taboret.");

            }

        } else {
            this.character.printSlow("What are you trying to investigate?");
        }
    }

    /**
     * Prints out clues for possible key words.
     */
    public void actionClue(){
        this.character.printSlow("+--------------------------------+");
        this.character.printSlow("|   Some Commands to try:        |");
        this.character.printSlow("|   - 'take'                     |");
        this.character.printSlow("|   - 'drop'                     |");
        this.character.printSlow("|   - 'sleep'                    |");
        this.character.printSlow("|   - 'eat'                      |");
        this.character.printSlow("|   - 'spread'                   |");
        this.character.printSlow("+--------------------------------+");

    }

    public static void main(String[] args){
        Character a = new Character();
        RabbitHole r = new RabbitHole(a);
        r.play();
        
    }
}
