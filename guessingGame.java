import java.util.*;

class GameConfig{
	private final int MIN=1;
	private final int MAX=100;
	private final int MAX_ATTEMPTS=7;
	private final int MAX_HINTS=3;
	
	
	int targetNumber;
	
	public GameConfig() {
		
		Random random=new Random();
		this.targetNumber=random.nextInt(MAX-MIN+1)+MIN;
		
		
	}
	
	public int getTargetNumber(){ return targetNumber;}
	
	public int getMaxAttempts() {return MAX_ATTEMPTS;}
	
	public int getMaxHints() {return MAX_HINTS;}
	
	public void showRules(){
		System.out.println("Guess a number between "+MIN+" and "+MAX);
		System.out.println("You have "+ MAX_ATTEMPTS+" attempts.");
		System.out.println("Hints will be provieded after wrong guesses.");
		
	}
}

/**
* GuessingApp -Use Case 1: Game Intialization
* This class serves as the application entry point.
* It initializes the game configuration and displays game rules.
* No user input or gameplay logic is implemented at this stage.
* @author Dhruv
* @version 1.0
*/

public class guessingGame{
	public static void main(String[] args){
		System.out.println("Welcome to the Guessing App");
		
		GameConfig config = new GameConfig();
		config.showRules();
		
		Scanner scanner=new Scanner(System.in);
		int attempts=0;
		
		while (attempts< config.getMaxAttempts()){
			System.out.print("Enter your guess: ");
			int guess=scanner.nextInt();
			attempts++;
			
			String result =GuessValidator.validateGuess(guess, config.getTargetNumber());
			System.out.println(result);
			
			
			if ("Correct".equals(result)){
				break;
			}
				
		}
	}
}