import java.util.*;

public class ContestStatistics {
    private static ContestStatistics instance;
    private final Map<String, Integer> playerScores;

    private ContestStatistics() {
       
        playerScores = new HashMap<>();
    }

    public static synchronized ContestStatistics getInstance() {
        if (instance == null) {
            instance = new ContestStatistics();
        }
        return instance;
    }

    public void addToTotalPoints(String name, int points) {
        playerScores.put(name, playerScores.getOrDefault(name, 0) + points);
    }

    public int getTotalPoints() {
        return playerScores.values().stream().mapToInt(Integer::intValue).sum();
    }

    public void declareWinner() {
        List<Map.Entry<String, Integer>> sortedPlayers = new ArrayList<>(playerScores.entrySet());
    
     
        sortedPlayers.sort(Map.Entry.<String, Integer>comparingByValue().reversed());
    
        boolean firstPlaceFound = false;
        boolean secondPlaceFound = false;
        boolean thirdPlaceFound = false;
    
        for (Map.Entry<String, Integer> entry : sortedPlayers) {
            if (!firstPlaceFound) {
                System.out.println("And with " + entry.getValue() + " points...");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted");
                }
                System.out.println("The winner is...");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted");
                }
                System.out.println(entry.getKey() + "!");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted");
                }
                System.out.println();
                firstPlaceFound = true;
            } else if (!secondPlaceFound) {
                System.out.println("And with " + entry.getValue() + " points...");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted");
                }
                System.out.println("In second place...");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted");
                }
                System.out.println(entry.getKey() + "!");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted");
                }
                System.out.println();
                secondPlaceFound = true;
            } else if (!thirdPlaceFound) {
                System.out.println("And with " + entry.getValue() + " points...");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted");
                }
                System.out.println("In third place...");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted");
                }
                System.out.println(entry.getKey() + "!");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted");
                }
                System.out.println();
                thirdPlaceFound = true;
            } else {
                break;
            }
        }
    }
    
}
