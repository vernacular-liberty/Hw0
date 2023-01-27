//imports
// import java.util.ArrayList;
//import java.util.Random;
//import java.util.Scanner;

//Introduces Cheshire Cat
public class TulgeyWoods{
    // ArrayList<String> areas;
    int index;
    Character character;
    // String lantern;
    Boolean inForest;
    Boolean newArea;
    // String stick;

    /**
     * Constructs Tulgey Woods.
     * @param character the character playing the game
     */
    public TulgeyWoods(Character character){
        this.index = 0;
        this.character = character;
        // this.lantern = "lantern";
        // this.stick = "stick";

        // areas.add("After hours of wandering, you happen upon an abandoned shed in a small clearing.");
        // areas.add("After being without a path for hours, you wind up at a crossroads.");
        // areas.add("You decide to take the pink path. ");
        // areas.add("You decide to take the green path.");

    }

    /**
    * Executes the conversation
    * @param arguments
    */
    public void play(){
        System.out.println("After hours of wandering, you wind up at a crossroads.");
        System.out.println("Suddenly, you hear laughter coming from above. A striped cat appears in front of you, seemingly out of thin air.");
        System.out.println("This is the Cheshire Cat. He grins from ear to ear, and he speaks in a sing-song voice.");
        System.out.println("[FUN FACT: The Cheshire Cat is well-known around here. Even the Queen is scared of him!]");
        System.out.println("Maybe the Cheshire Cat knows the way out of here!");
        System.out.println("    \"What have I found here?\", asks the Cheshire Cat.");
        System.out.println("    \"Nobody. Do you know which way I should go?\", you respond.");
        System.out.println("    \"That depends on where you want to get to.\", he says.");
        System.out.println("    \"It really doesn't matter.\"");
        System.out.println("    \"Then I guess it doesn't matter which way you go!\", exclaims the Cheshire Cat.");

        System.out.print("You realize that the Cheshire Cat is right: It doesn't matter. You wander whichever way you please until you find the end of the woods.");
    }

        //System.out.println("Type \"enter\" if you want to enter the forest.");

    //     String start = this.character.command();
    //     userAction(start);

    //     String command;

    //     if (start.contains("enter")){

    //         while (this.inForest){

    //             if (this.newArea == true){
    //                 this.newArea = false;

    //                 System.out.println(this.areas.get(this.index));
    //             }
    //             command = this.character.command();
    //             userAction(command);
    //         }
    //         System.out.println("Where did the Cheshire Cat come from? And why is his smile so wide?");
    //     }

    // }

    // public void userAction(String command){

    // }

    public static void main(String[] args){
        Character a = new Character();
        TulgeyWoods t = new TulgeyWoods(a);
        t.play();
    }
}

