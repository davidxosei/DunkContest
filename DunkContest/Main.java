public class Main {
    public static void main(String[] args) {
        DunkContest dunkContest = new DunkContest();
        DunkOptions dunkOptions = new DunkOptions();
        dunkContest.startContest(dunkOptions);
       
    }
}
//Factory --> creation of dunks
//Singleton --> Contest statistics
//Strategy --> each judge uses a strategy to give players a score based on the dunk difficulty and the number of attempts they've had