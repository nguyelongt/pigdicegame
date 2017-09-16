package app.pigdice.presentation;
import app.pigdice.business.Console;
import app.pigdice.database.PigDiceDB;

public class PigDiceApp {

    public static void main(String[] args) {
        int runXTimes = 0;
        Console.printLine("Welcome to the PigDice App!\n");
        String choice = "";
        while (!choice.equalsIgnoreCase("exit")) {
            Console.printLine("\nCOMMAND:");
            Console.printLine("Play\t- Play the Game");
            Console.printLine("Exit\t- Exit the Game");
            choice = Console.getString("Command: ");
            if (choice!=null) {
                if (choice.equalsIgnoreCase("play")) {
                    runXTimes = Console.getInt("How many times would you like to play? ");
                    PigDiceDB.playPigDice(runXTimes);
                    Console.printLine("--------------------------------------------------");
                    Console.printLine("\t \t \t \t \t SUMMARY \t \t \t");
                    Console.printLine("--------------------------------------------------");
                    Console.printLine("Total Dice Rolls Per Game" + "|" + "Total Dice Sum Per Game");
                    Console.printLine("--------------------------------------------------");
                    PigDiceDB.gameSummary();
                    Console.printLine("--------------------------------------------------");
                    PigDiceDB.highestScore();
                    PigDiceDB.averagePerGame();
                    Console.printLine("--------------------------------------------------");
                    PigDiceDB.gamesPlayed();
                } else if (choice.equalsIgnoreCase("exit")) {
                    Console.printLine("Closing game...");
                } else {
                    Console.printLine("Invalid command. Please try again.");
                }
            }
        }
    }
}
