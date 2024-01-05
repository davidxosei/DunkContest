//class implementing Judge interface for the lenient judge strategy
import java.util.Random;
public class LenientJudge implements Judge {
    Random random = new Random();
    @Override
    public int evaluateDunk(String difficulty, int attempts) {
        int initialScore = getInitialScore(difficulty);
        return Math.max(initialScore - attempts, 1); // Score can't be less than 1
    }

    private int getInitialScore(String difficulty) {
        switch (difficulty) {
            case "easy":
                return random.nextInt(3)+6;
            case "medium":
                return random.nextInt(4)+7;
            case "hard":
                return 10;
            default:
                return 0;
        }
    }
}

