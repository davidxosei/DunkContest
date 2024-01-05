import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HardDunk implements Dunk {
    private final String difficulty = "hard";
    private final List<Integer> successNumbers;
    private boolean missedDunk;

    public HardDunk() {
        successNumbers = new ArrayList<>();
        generateSuccessNumbers(2);
    }

    private void generateSuccessNumbers(int count) {
        Random random = new Random();
        while (successNumbers.size() < count) {
            int number = random.nextInt(10) + 1;
            if (!successNumbers.contains(number)) {
                successNumbers.add(number);
            }
        }
    }

    @Override
    public void performDunk(int chosenNumber) {
        if (successNumbers.contains(chosenNumber)) {
            System.out.println("Successful dunk!");
            missedDunk = false;
        } else {
            System.out.println("Missed the dunk!");
            missedDunk = true;
        }
    }

    @Override
    public String getDifficulty() {
        return difficulty;
    }
    public boolean didPlayerMissDunk() {
        return missedDunk;
    }
}