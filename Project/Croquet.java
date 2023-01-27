//imports
import java.util.Random;

// import java.util.ArrayList;

public class Croquet {
 
  int health;
  int size;
  String flamingo;
  String hedgehog;
  int score;
  Character character;
  Object distance;

  public Croquet(Character character) {
    this.character = character;
    this.score = 0;

  }

  /**
   * Randomly decides who will have the first turn
   * @param <Turn>
   * @param Turn
   * @return whosTurn
   */
  public void firstTurn() {
    Random rand = new Random();
    int result = rand.nextInt(2); // Generate a random number between 0 and 1

    if (result == 0) {
      System.out.println("You start! Show me what you can do.");
    } else {
      System.out.println("ME FIRST!");
    }
  }

  /**
   * Changes health status when user plays croquet based on size.
   * @return 
   */
  // Method for playing a game of croquet
  
    public void play() {
        // Print a message to the console asking the player if they want to play
        System.out.println("The queen demands that you play a game of croquet with her. Answer yes or no.");
      
        // Read the user's input
        String command = this.character.command();
      
        // Print a message to the console based on the user's response
        if (command.equalsIgnoreCase("yes")) {
          System.out.println("POSITIONS!");
        } else if (command.equalsIgnoreCase("no")) {
          System.out.println("Too bad! You play or you die!!");
        } else {
          System.out.println("I have no clue what you're saying we're playing croquet..GRAB A FLAMINGO!");
      }

      // Close the Scanner object
    //   scan.close();
      
    while (true) {
      if (size<= 30.0){
        this.character.health -= this.character.health/2;
        System.out.println("You are too small to be a player, so the Queen decided you would be more useful as a ball. After the game your health is: " + this.character.health + ".");
        break;
        
    } else if (size >= 100){
        this.character.health -= this.character.health / 8;
        System.out.println("You play a few games. Although, you could use a rest due to your massive size the physical excertion is now too taxing. After the game your health is: " + this.character.health + ".");
        
    } else {
        this.character.health -= this.character.health / 4;
        System.out.println("You play a few games to keep your head. After the games your health is: " + this.character.health + ".");
    }
        firstTurn();
      // Begin the game loop
     
        // Prompt the player for a command
        System.out.println("Enter a command to play your turn (e.g. hit ball, move ball, etc.)");
        String playerCommand = this.character.command();

        // Handle the player's turn
        if (playerCommand.equalsIgnoreCase("hit ball")) {
          // Simulate the ball being hit by generating a random distance
          Random rand = new Random();
          int distance = rand.nextInt(10) + 1; // Generate a random number between 1 and 10
          System.out.println("You hit the hedgehog " + distance + " feet!");

          // Update the ball's position on the court based on the distance it was hit
          // ...
        }
        // Other possible commands

        // Update the player's score based on their actions
        score += 10;

        // Print the player's current score
        System.out.println("Your score: " + score);

        // End the game if the player reaches a certain score
        if (score >= 50) {
          System.out.println("You win! Congratulations!");
          break;
        }

        // Handle the queen's turn
        Random rand = new Random();
        distance = rand.nextInt(10) + 1; // Generate a random number between 1 and 10
        System.out.println("The queen hit the hedgehog " + distance + " feet!");

        // Update the ball's position on the court based on the distance it was hit
        // ...

        // Update the queen's score based on its actions
        score += 10;

        // Print the queen's current score
        System.out.println("The queen's score: " + score);

        // End the game if the queen reaches a certain score
        if (score >= 50){
            System.out.println("OFF WITH YOUR HEAD");
            System.out.println("GAME OVER");
            break;
        }
    }
}
    
public static void main(String[] args) {
    Character c = new Character();
    Croquet game = new Croquet(c);
    game.play();
  }
}