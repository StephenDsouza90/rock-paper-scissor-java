import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {

    static void printInstructions() {
        System.out.println(
                "To play the game, select one of the following: \n 1 for Rock \n 2 for Paper \n 3 for Scissor \n");
    }

    public static String playGame(String firstPlayerSelection, String secondPlayerSelection) {
        String winner;

        String rock = "Rock";
        String paper = "Paper";
        String scissor = "Scissor";

        if (firstPlayerSelection == secondPlayerSelection) {
            winner = "Tie";
        } else if (firstPlayerSelection == rock) {
            if (secondPlayerSelection == paper) {
                winner = "Second Player Won";
            } else {
                winner = "First Player Won";
            }
        } else if (firstPlayerSelection == scissor) {
            if (secondPlayerSelection == paper) {
                winner = "First Player Won";
            } else {
                winner = "Second Player Won";
            }
        } else if (firstPlayerSelection == paper) {
            if (secondPlayerSelection == rock) {
                winner = "First Player Won";
            } else {
                winner = "Second Player Won";
            }
        } else {
            winner = "...";
        }
        return winner;
    }

    public static String computerSelection() {
        String rock = "Rock";
        String paper = "Paper";
        String scissor = "Scissor";

        Random random = new Random();
        int computerInput = random.nextInt(3) + 1;

        String computerSelection;

        if (computerInput == 1) {
            computerSelection = rock;
        } else if (computerInput == 2) {
            computerSelection = paper;
        } else {
            computerSelection = scissor;
        }

        return computerSelection;
    }

    public static String playerSelection() {
        String rock = "Rock";
        String paper = "Paper";
        String scissor = "Scissor";

        Random random = new Random();
        int playerInput = random.nextInt(3) + 1;

        String playerSelection;

        if (playerInput == 1) {
            playerSelection = rock;
        } else if (playerInput == 2) {
            playerSelection = paper;
        } else {
            playerSelection = scissor;
        }

        return playerSelection;
    }

    public static HashMap<Integer, HashMap<String, String>> playMultipleRounds(int numberOfRounds) {
        HashMap<Integer, HashMap<String, String>> gameSummary = new HashMap<>();

        for (int i = 1; i <= numberOfRounds; i++) {

            String computerSelection = computerSelection();
            String playerSelection = playerSelection();

            String winner = playGame(computerSelection, playerSelection);

            HashMap<String, String> round = new HashMap<String, String>();
            round.put("player 1", computerSelection);
            round.put("player 2", playerSelection);
            round.put("winner", winner);

            gameSummary.put(i, round);
        }
        return gameSummary;
    }

    public static void printAndAnalyzeGameSummary(HashMap<Integer, HashMap<String, String>> gameSummary) {
        int player1Wins = 0;
        int player2Wins = 0;

        for (Map.Entry<Integer, HashMap<String, String>> roundEntry : gameSummary.entrySet()) {
            HashMap<String, String> roundData = roundEntry.getValue();
            String winner = roundData.get("winner");

            if ("First Player Won".equals(winner)) {
                player1Wins++;
            } else if ("Second Player Won".equals(winner)) {
                player2Wins++;
            }
        }

        //  System.out.println(gameSummary);
        System.out.println("Player 1 wins: " + player1Wins);
        System.out.println("Player 2 wins: " + player2Wins);

    }

    public static void main(String[] args) {
        printInstructions();
        HashMap<Integer, HashMap<String, String>> gameSummary = playMultipleRounds(5);
        printAndAnalyzeGameSummary(gameSummary);
    }
}