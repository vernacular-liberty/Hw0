//import
import java.util.Random;

public class Location extends Character{
    String[][] map;
    String currentStory;
    Boolean changeLocation;
    RabbitHole rabbitHole;
    int locationC;
    int locationR;

    public Location(int locationC, int locationR){
        Random random = new Random();
        this.locationC = random.nextInt(5);
        this.locationR = random.nextInt(5);

        this.map = new String[][]{{"You have reached the edge of Wonderland. The sky and sea melt together into one grey plain.", "You walk along the beach to find a bottle of pills washed up on the shore.", "You have reached the light house at the endless sea... ", "After a long trek through the mountains you have reached the top of Mont Jubjub! You can see anything from here", "The far castle!"}, 
        {"You have entered the croquet grounds. An intense game is taking place between Tweedledee and Tweedledum.","You have reached the grandest Castle in all the land, the castle of the queen of hearts.", "Court House", "You have reached the royal rose gardens.", "You are at the base of the mountains of division."}, 
        {"You have reached the Mad Hatters house. It appear there is a tea party in session!", "You have reached the duchesses manner.", "You emerge from the woods into a meadow surrounding a small gabled house. You enter the house on the table is a container of pills.", "You enter a grove of massive mushrooms. Your eyes meet those of caterpillar who ignores you and takes a drag of a long hookah.", "Chilled to the bone you hurry on through the woods in the hopes of finding shelter."}, 
        {"Welcome to the dismal mire...","You found a river. Should you drink the water? It could be dangerous...Strange things happen in Wonderland...", "Giant dragonflies swarm through the sky over your head squabbling over potential perches.","The trees around you begin to morph into oversized mushrooms. You are pleased pick some fungi and arrange them into a bouquet. Your stomach growls...", "You sense someone is watching you in the darkness! Move faster"}, 
        {"You cross the water to find a small door.","You reach the edge of a calm pond. Thirsty, you cup the water to your lips only to spit out a mouthful of tears.","","The forrest thicken. A sign points east saying, 'Enter at your own peril!'", "You wander down another one of the Tulgey woods winding purple roads. Will you ever escape?"}};
        
        this.currentStory = this.map[this.locationC][this.locationR];

        this.changeLocation = true;

        RabbitHole this.rabbitHole = new RabbitHole();
        this.rabbitHole = rabbitHole;

    }
    /**
     * Finds the direction the user wants to go.
     * @param command
     */
    public void walkDirection(String command){
        if (command.contains("north")){
            walkNorth(command);

        } else if (command.contains("south")){
            walkSouth(command);

        } else if(command.contains("west")){
            walkWest(command);

        } else if (command.contains("east")){
            walkEast(command);

        } else{
            printSlow("Please enter a valid direction: north, south, east or west.");

        }
    }

    /**
     * Moves up one column in the map. 
     * @param command user command.
     */
    public void walkNorth(String command){
        if (this.locationC == 0){
            throw new RuntimeException("You have reached the North most edge of Wonderland. Please try a different direction.");

        } else {
            this.locationC-=1;
        }
        
    }

    /**
     * Moves down one one column in the map.
     * @param command user command.
     */
    public void walkSouth(String command){
        if (this.locationC == 5){
            throw new RuntimeException("You have reached the North most edge of Wonderland. Please try a different direction.");

        } else {
            this.locationC+=1;
        }
    }

    /**
     * Moves user one row to the left in the map.
     * @param command user command.
     */
    public void walkWest(String command){
        if (command.contains("west") || command.contains("West")){
            if (this.locationR == 0){
                throw new RuntimeException("You have reached the North most edge of Wonderland. Please try a different direction.");

            } else {
                this.locationR -= 1;

            }
        }
    }

    /**
     * Moves user one row to the right in the map.
     * @param command user command.
     */
    public void walkEast(String command){
        if (command.contains("east") || command.contains("East")){
            if (this.locationR == 5){
                throw new RuntimeException("You have reached the North most edge of Wonderland. Please try a different direction.");

            } else {
                this.locationR += 1;

            }
        }
    }

}