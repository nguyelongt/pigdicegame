package app.pigdice.database;
import app.pigdice.business.Console;
import java.util.ArrayList;

public class PigDiceDB {

    private static int runXTimes;
    private static ArrayList<Integer> diceArraySum = new ArrayList<>();
    private static ArrayList<Integer> diceRollArray = new ArrayList<>();


    public static void playPigDice(int runXTime) {
        do {
            runXTimes++;
            ArrayList<Integer> diceArray = new ArrayList<>();
            int diceValue;
            int perDiceRollCounter = 0;
            do {
                diceValue = Console.generateRandomNumber();
                if (diceValue != 1) {
                    diceArray.add(diceValue);
                    perDiceRollCounter++;
                }
            } while (diceValue != 1);
            diceArraySum.add(arraySum(diceArray));
            diceRollArray.add(perDiceRollCounter);
        } while (runXTimes != runXTime);
    }

    private static int arraySum(ArrayList<Integer> diceArray) {
        int arraySum = 0;

        for (Integer aDiceArray : diceArray) {
            arraySum += aDiceArray;
        }
        return arraySum;
    }

    public static void gameSummary() {
        for (int i = 0; i < diceRollArray.size(); i++) {
            Console.printLine("\t\tGame " + (i + 1) + ": " + diceRollArray.get(i)
                    + "\t\t\t\tGame " + (i + 1) + ": " + diceArraySum.get(i));
        }
    }

    public static void highestScore() {
        int highestScoreIndex = 0;
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < diceArraySum.size(); i++) {
            if (diceArraySum.get(i) > largest) {
                largest = diceArraySum.get(i);
                highestScoreIndex = i;
            }
        }
        Console.printLine("\tHighest Rolls: " + diceRollArray.get(highestScoreIndex)
                + "\t\tHighest Score: " + diceArraySum.get(highestScoreIndex));
    }

    public static void averagePerGame() {
        int averageRolls = arraySum(diceRollArray) / diceRollArray.size();
        int totalRolls = arraySum(diceRollArray);
        int averageScore = arraySum(diceArraySum) / diceArraySum.size();
        int totalScores = arraySum(diceArraySum);
        Console.printLine("\tRolls Average: " + averageRolls
                + "\t\tScores Average: " + averageScore
                + "\n\tRolls Total: " + totalRolls
                + "\t\t\tScores Total: " + totalScores);
    }

    public static void gamesPlayed() {
        Console.printLine("\t\t\tYou played " + runXTimes + " games...");
    }
}
