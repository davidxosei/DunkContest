import java.util.Random;

public class ComputerPlayer implements Player {
    private final Random random;
    private int totalPoints;
    private boolean missedDunk;
    private int attempts;
    private String name;

    public ComputerPlayer(String name) {
        random = new Random();
        totalPoints = 0;
        this.name = name;
    }

    @Override
    public Dunk chooseDunk(DunkOptions dunkOptions) {
        System.out.println("Choose the dunk difficulty (1: Easy, 2: Medium, 3: Hard)");
        try {
            Thread.sleep(1000);
        }
        catch(InterruptedException e) {
            System.out.println("Please wait");
        }
        int choice = random.nextInt(3) + 1; 
        
        switch (choice) {
            case 1:
                System.out.println("You selected an Easy Dunk");
                try {
                    Thread.sleep(1500);
                }
                catch(InterruptedException e) {
                    System.out.println("Please wait");
                }
                return new EasyDunk();
            case 2:
                System.out.println("You selected a Medium Dunk");
                try {
                    Thread.sleep(1500);
                }
                catch(InterruptedException e) {
                    System.out.println("Please wait");
                }
                return new MediumDunk();
            case 3:
                System.out.println("You selected a Hard Dunk");
                try {
                    Thread.sleep(1500);
                }
                catch(InterruptedException e) {
                    System.out.println("Please wait");
                }
                return new HardDunk();
            default:
                System.out.println("You selected an Easy Dunk");
                try {
                    Thread.sleep(500);
                }
                catch(InterruptedException e) {
                    System.out.println("Please wait");
                }
                return new EasyDunk();
        }
    }

    @Override
    public int chooseNumber() {
        return random.nextInt(10) + 1;
    }

    @Override
    public int getAttempts() {
        if (missedDunk) {
            attempts++;
            missedDunk = false;
        }
        return attempts;
    }

    @Override
    public void addAttempts() {
        this.attempts++;
    }

    @Override
    public void addPoints(int points) {
        totalPoints += points;
    }

    @Override
    public int getTotalPoints() {
        return totalPoints;
    }

    @Override
    public void resetAttempts() {
        attempts = 0;
    }

    public String getName() {
        return name;
    }
}

