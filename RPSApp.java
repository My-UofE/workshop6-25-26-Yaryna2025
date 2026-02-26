import java.util.Scanner;
import java.util.Random;

/**
 * RPSApp demonstrates a Rock-Paper-Scissors game against the computer.
 *
 * QA Notes:
 * - HandSign enum provides type safety for ROCK, PAPER, SCISSORS moves.
 * - getComputerMove() uses Random.nextInt(3) to select a move randomly.
 * - getPlayerMove() validates input: r/p/s/q only; returns null if quitting.
 * - whoWins() applies standard rules: 0=tie, 1=player wins, -1=computer wins.
 * - Main loop tracks scores and prints round results until player quits.
 * - Only essential comments are included inline for clarity and readability.
 */
enum HandSign {
    ROCK, 
    PAPER,
    SCISSORS 
}

public class RPSApp {

    public static HandSign getComputerMove(){
        Random rd = new Random();
        int n = rd.nextInt(3); // random 0,1,2
        switch(n){
            case 0: return HandSign.ROCK;
            case 1: return HandSign.PAPER;
            case 2: return HandSign.SCISSORS;
        }
        return null; // safety
    }

    public static HandSign getPlayerMove(){
        Scanner in = new Scanner(System.in);
        boolean validInput = false;
        HandSign playerHandSign = null;

        do {
            System.out.println("Enter your move: r=ROCK, p=PAPER, s=SCISSORS, q=QUIT");
            char inChar = in.next().toLowerCase().charAt(0);

            switch(inChar){
                case 'r': playerHandSign = HandSign.ROCK; validInput = true; break;
                case 'p': playerHandSign = HandSign.PAPER; validInput = true; break;
                case 's': playerHandSign = HandSign.SCISSORS; validInput = true; break;
                case 'q': validInput = true; playerHandSign = null; break; // quit
                default: System.out.println("Invalid input! Please enter r, p, s, or q."); validInput = false;
            }

        } while(!validInput);

        return playerHandSign;
    }

    public static int whoWins(HandSign h1, HandSign h2){
        if(h1 == h2) return 0; // tie
        switch(h1){
            case ROCK: return (h2 == HandSign.SCISSORS) ? 1 : -1;
            case PAPER: return (h2 == HandSign.ROCK) ? 1 : -1;
            case SCISSORS: return (h2 == HandSign.PAPER) ? 1 : -1;
        }
        return 0; // safety
    }

    public static void main(String[] args){
        int playerScore = 0;
        int computerScore = 0;
        boolean gameOver = false;

        System.out.println("Welcome to Rock-Paper-Scissors!");

        while(!gameOver){
            // Step1: Get the player move
            HandSign playerMove = getPlayerMove();
            if(playerMove == null){ // player chose to quit
                gameOver = true;
                System.out.println("You quit the game.");
                break;
            }

            // Step2: Get the computer’s move
            HandSign computerMove = getComputerMove();

            // Step3: Check who wins
            int result = whoWins(playerMove, computerMove);

            // Step4: Output moves and round result
            System.out.println("You played: " + playerMove);
            System.out.println("Computer played: " + computerMove);
            switch(result){
                case 0: System.out.println("Round result: TIE"); break;
                case 1: System.out.println("Round result: YOU WIN!"); playerScore++; break;
                case -1: System.out.println("Round result: COMPUTER WINS!"); computerScore++; break;
            }

            // Step5: Update and print scores
            System.out.println("Score => You: " + playerScore + " | Computer: " + computerScore);
            System.out.println("-----------------------------");
        }

        System.out.println("Final Score => You: " + playerScore + " | Computer: " + computerScore);
        System.out.println("Thanks for playing!");
    }
}