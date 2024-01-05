// class implementing Judge interface for the fair judge strategy
import java.util.Random;

public class FairJudge implements Judge {
    Random random = new Random();
    @Override
    public int evaluateDunk(String difficulty, int attempts) {
        int initialScore = getInitialScore(difficulty);
        return Math.max(initialScore - attempts - 1, 1); // Score can't be less than 1
    }

    private int getInitialScore(String difficulty) {
        switch (difficulty) {
            case "easy":
                return random.nextInt(3)+3;
            case "medium":
                return random.nextInt(4)+5;
            case "hard":
                return 10;
            default:
                return 0;
        }
    }
}

