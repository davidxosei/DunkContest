This project is a simulation of a dunk contest. Players are given 3 attempts to complete a dunk. There will also only be a total of 3 rounds. If you miss a dunk on all 3 attempts you are given a score of 0 for that round. If you do complete a dunk, the 3 different judges will score you based on the difficulty of the dunk and how many attempts you took to complete a dunk. Here are the steps to run the program and play the game. *Please also note you can quit the program at any time by typing in quit (except for the part where you enter your name)*

**Step 1**

Compile the program by typing javac *.java then press enter. 
Run the program by typing java Main then press enter.

**Step 2**

The program will welcome you to the dunk contest and it will ask you if you would like to play solo.
By typing in yes, you will face two other computers. You will then be prompted to enter your name. (Please skip Step 2a and read Step 3)
By typing in no, you will be asked how many players in total will be playing on your local device (Please read Step 2a)
Step 2a
You can enter as many players as you want (this number must be greater than 0)
You will then enter a name for each player (you cannot have duplicate names)

**Step 3**

For each player’s turn, they will first be asked whether they’d like to do an easy, medium, or hard dunk.
They will then be asked to pick a number between 1-10
For Easy Dunks 7 numbers will result in a successful dunk you must try to pick one of them
For Medium Dunks 5 numbers will result in a successful dunk
For Hard Dunks 2 numbers will result in a successful dunk
If you miss a dunk you can always pick a dunk of a different difficulty on a different attempt

**Step 4**

If you miss a dunk on all 3 attempts you will get a score of 0
Otherwise, the judges will judge you based on the difficulty of the dunk you completed and the number of attempts you took

**Step 5**

After the 3rd round is over the program lists the players in first, second, and third place
That is the end of the program

**Design Patterns**


1. **Strategy Pattern**: The Strategy pattern is used for the judging system in the dunk contest. Each judge follows a different strategy for evaluating a dunk based on its difficulty and the number of attempts made by the player. By using the Strategy pattern, the judging behavior is encapsulated in separate classes (`LenientJudge`, `FairJudge`, `StrictJudge`), allowing easy extension and modification of judging strategies without altering the player or dunk classes.

2. **Factory Method Pattern**: The Factory Method pattern is implemented to create instances of different dunk types based on their difficulty level (Easy, Medium, Hard). The `Dunk` interface is a common type, and three concrete classes (`EasyDunk`, `MediumDunk`, `HardDunk`) are created using the Factory Method. It enables the `DunkContest` class to create the appropriate instance of a dunk based on the selected difficulty, ensuring that the creation logic is encapsulated in separate classes.

3. **Singleton Pattern**: The Singleton pattern is applied to the `ContestStatistics` class, ensuring there is only one instance of this class throughout the application's runtime. This Singleton manages the overall contest statistics, specifically the total points scored by all contestants. It provides a single, global point of access to these statistics, enabling easy tracking and aggregation of overall contest performance.


**Technologies Used**
Java

Design Patterns (Strategy, Factory Method, Singleton)

**Project Structure**

The project comprises various classes modeling players, judges, dunks, and scoring systems. It follows an object-oriented approach and incorporates design patterns to ensure modularity and extensibility.
