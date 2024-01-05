import java.util.Scanner;

public class HumanPlayer implements Player {
    private final Scanner scanner;
    private int totalPoints;
    private int attempts;
    private boolean missedDunk;
    private String name;

    public HumanPlayer(String name) {
        scanner = new Scanner(System.in);
        totalPoints = 0;
        this.name = name;
    }

    @Override
    public Dunk chooseDunk(DunkOptions dunkOptions) {
        int choice;
        while (true) {
            System.out.println("Choose the dunk difficulty (1: Easy (70% chance of success), 2: Medium (50% chance of success), 3: Hard (20% chance of success), or type 'quit' to exit): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("quit")) {
                System.out.println("Exiting the program...");
                System.exit(0); // Exit the program
            }

            try {
                choice = Integer.parseInt(input);
                if (choice < 1 || choice > 3) {
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number or type 'quit' to exit.");
            }
        }

        switch (choice) {
            case 1:
                return new EasyDunk();
            case 2:
                return new MediumDunk();
            case 3:
                return new HardDunk();
            default:
                // This should not be reached due to the validation above, but providing a default return to avoid errors
                System.out.println("Invalid choice. Choosing an easy dunk by default.");
                return new EasyDunk(); // Default to an easy dunk
        }
    }

    @Override
    public int chooseNumber() {
        int number;
        while (true) {
            System.out.print("Enter a number between 1-10 (or type 'quit' to exit): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("quit")) {
                System.out.println("Exiting the program...");
                System.exit(0); // Exit the program
            }

            try {
                number = Integer.parseInt(input);
                if (number < 1 || number > 10) {
                    System.out.println("Invalid number. Please enter a number between 1 and 10.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number or type 'quit' to exit.");
            }
        }

        return number;
    }

    @Override
    public int getAttempts() {
        if (missedDunk) {
            attempts++;
            missedDunk = false; // Reset missedDunk for next attempt
        }
        return attempts;
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
    public void addAttempts() {
        this.attempts++;
    }

    @Override
    public void resetAttempts() {
        attempts = 0;
    }

    public String getName() {
        return name;
    }
}
