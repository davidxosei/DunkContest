import java.util.ArrayList;
import java.util.List;

public class DunkOptions {
    private List<String> easyDunks;
    private List<String> mediumDunks;
    private List<String> hardDunks;
//this was supposed to be a list of different dunks for different  difficulties
//but i was having trouble implementing this so i did not add this feature
    public DunkOptions() {
        easyDunks = new ArrayList<>();
        easyDunks.add("Simple Dunk 1");
        easyDunks.add("Simple Dunk 2");
        easyDunks.add("Simple Dunk 3");
        easyDunks.add("Simple Dunk 4");
        easyDunks.add("Simple Dunk 5");

        mediumDunks = new ArrayList<>();
        mediumDunks.add("Medium Dunk 1");
        mediumDunks.add("Medium Dunk 2");
        mediumDunks.add("Medium Dunk 3");
        mediumDunks.add("Medium Dunk 4");
        mediumDunks.add("Medium Dunk 5");

        hardDunks = new ArrayList<>();
        hardDunks.add("Challenging Dunk 1");
        hardDunks.add("Challenging Dunk 2");
        hardDunks.add("Challenging Dunk 3");
        hardDunks.add("Challenging Dunk 4");
        hardDunks.add("Challenging Dunk 5");
    }

    public List<String> getEasyDunks() {
        return easyDunks;
    }

    public List<String> getMediumDunks() {
        return mediumDunks;
    }

    public List<String> getHardDunks() {
        return hardDunks;
    }
}

