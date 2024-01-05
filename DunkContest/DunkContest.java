import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class DunkContest {
    private final Player[] players;
    private final Judge lenientJudge;
    private final Judge fairJudge;
    private final Judge strictJudge;
    private final ContestStatistics contestStatistics;

public DunkContest() {
        Scanner scan = new Scanner(System.in);
        boolean isSolo = false;
        String playerName = ""; // Initialize playerName

        while (true) {
            System.out.println("Welcome to the BC Dunk Contest!");
            System.out.println("Are you playing solo? (yes/no, or type 'quit' to exit)");
            String response = scan.nextLine().toLowerCase();

            if (response.equals("yes")) {
                isSolo = true;
                break;
            } else if (response.equals("no")) {
                isSolo = false;
                break;
            } else if (response.equalsIgnoreCase("quit")) {
                System.out.println("Exiting the program...");
                System.exit(0); // Exit the program gracefully
            } else {
                System.out.println("Invalid input. Please enter 'yes', 'no', or 'quit' to exit.");
            }
        }

        if (isSolo) {
            System.out.println("Enter your name:");
            playerName = scan.nextLine(); // Store player's name for solo play
            players = new Player[]{
                    new HumanPlayer(playerName), // Create HumanPlayer with provided name
                    new ComputerPlayer("Computer 1"), // Computer player 1
                    new ComputerPlayer("Computer 2") // Computer player 2
            };
        } else {
            int numberOfPlayers = 0;

            while (numberOfPlayers <= 0) {
                System.out.println("How many people are playing? (Enter a number, or type 'quit' to exit)");
                String input = scan.nextLine();

                if (input.equalsIgnoreCase("quit")) {
                    System.out.println("Exiting the program...");
                    System.exit(0); // Exit the program
                }

                try {
                    numberOfPlayers = Integer.parseInt(input);
                    if (numberOfPlayers <= 0) {
                        System.out.println("Please enter a number greater than zero.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number or type 'quit' to exit.");
                }
            }

            players = new Player[numberOfPlayers];
            Set<String> usedNames = new HashSet<>();
            for (int i = 0; i < numberOfPlayers; i++) {
                while (true) {
                    System.out.println("Enter player " + (i + 1) + "'s name:");
                    playerName = scan.nextLine();
                    if (!usedNames.contains(playerName)) {
                        usedNames.add(playerName);
                        players[i] = new HumanPlayer(playerName);
                        break;
                    } else {
                        System.out.println("Name already taken. Please enter a different name.");
                    }
                }
            }
        }

        lenientJudge = new LenientJudge();
        fairJudge = new FairJudge();
        strictJudge = new StrictJudge();
        contestStatistics = ContestStatistics.getInstance();
    }
    public void startContest(DunkOptions dunkOptions) {
        for (int round = 1; round <= 3; round++) {
            System.out.println("Round " + round + " begins!");
            for (Player player : players) {
                System.out.println(player.getName()+"'s turn!");
                // Player chooses a dunk based on difficulty
                try {
                    Thread.sleep(500);
                }
                catch(InterruptedException e) {
                    System.out.println("Please wait");
                }
                while(player.getAttempts() < 3) {
                    Dunk dunk = player.chooseDunk(dunkOptions);
                    int chosenNumber = player.chooseNumber();
                    dunk.performDunk(chosenNumber);
                    if (dunk.didPlayerMissDunk()) {
                        player.addAttempts();
                    }
                    else {
                        int lenientScore = lenientJudge.evaluateDunk(dunk.getDifficulty(), player.getAttempts());
                        int fairScore = fairJudge.evaluateDunk(dunk.getDifficulty(), player.getAttempts());
                        int strictScore = strictJudge.evaluateDunk(dunk.getDifficulty(), player.getAttempts());

                        // Calculate total score for the player
                        int totalScore = lenientScore + fairScore + strictScore;
                        player.addPoints(totalScore);
                        contestStatistics.addToTotalPoints(player.getName(), totalScore);
                        System.out.println("Let's see what the judges have to say");
                        try {
                            Thread.sleep(1500);
                        }
                        catch(InterruptedException e) {
                            System.out.println("Please wait");
                        }
                        System.out.println("Judge 1 gives you a score of "+lenientScore);
                        try {
                            Thread.sleep(1500);
                        }
                        catch(InterruptedException e) {
                            System.out.println("Please wait");
                        }
                        System.out.println("Judge 2 gives you a score of "+fairScore);
                        try {
                            Thread.sleep(1500);
                        }
                        catch(InterruptedException e) {
                            System.out.println("Please wait");
                        }
                        System.out.println("Judge 3 gives you a score of "+strictScore);
                        try {
                            Thread.sleep(500);
                        }
                        catch(InterruptedException e) {
                            System.out.println("Please wait");
                        }
                        System.out.println("Total Score for " + player.getName() + ": " + totalScore);
                        System.out.println();
                        player.resetAttempts();
                        
                        break;
                    }
                }
                if (player.getAttempts() == 3) {
                    System.out.println("Total Score for " + player.getName() + ": " + 0);
                    System.out.println();
                    player.resetAttempts();
                }
                
            }
        }
        contestStatistics.declareWinner();
    }  
}
