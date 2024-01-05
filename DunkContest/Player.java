public interface Player {
    Dunk chooseDunk(DunkOptions dunkOptions);
    int chooseNumber();
    int getAttempts();
    void addPoints(int points);
    int getTotalPoints();
    void resetAttempts();
    void addAttempts();
    String getName();
}


