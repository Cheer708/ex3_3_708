import java.util.ArrayList;
import java.util.List;

// Observer interface
interface ScoreObserver {
    void update(String score);
}

// Subject class
class FootballMatch {
    private List<ScoreObserver> observers = new ArrayList<>();
    private String score;

    public void registerObserver(ScoreObserver observer) {
        observers.add(observer);
    }

    public void updateScore(String newScore) {
        score = newScore;
        notifyObservers();
    }

    private void notifyObservers() {
        for (ScoreObserver observer : observers) {
            observer.update(score);
        }
    }
}

// Concrete Observer
class FootballScoreDisplay implements ScoreObserver {
    private String name;

    public FootballScoreDisplay(String name) {
        this.name = name;
    }

    @Override
    public void update(String score) {
        System.out.println(name + " live result: " + score);
    }
}

public class Main {
    public static void main(String[] args) {
        FootballMatch match = new FootballMatch();
        
        FootballScoreDisplay observer1 = new FootballScoreDisplay("Observer 1");
        FootballScoreDisplay observer2 = new FootballScoreDisplay("Observer 2");

        match.registerObserver(observer1);
        match.registerObserver(observer2);

        // Simulate user input
        String userInput = "Thai 1-0 UAE";
        System.out.printf("Enter Score %s\n" , userInput);
        while (!userInput.isEmpty()) {
            match.updateScore(userInput);
            userInput = ""; // Simulate pressing Enter
        }
    }
}
