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
* GuessingApp -Use Case 5: Game Result Storage
* This class serves as the application entry point.
* It initializes the game configuration and displays game rules.
* User input has been setup.
* It saves the players scores in a text file.
* This class coordinated the complete game flow.
* @author Dhruv
* @version 5.0
*/

public class guessingGame{
	public static void main(String[] args) throws InvalidInputException {
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("===========================");
		System.out.println("Welcome to the Guessing App");
		System.out.println("===========================");
		System.out.println("Enter Your Name: ");
		String player = scanner.nextLine();
		
		GameConfig config = new GameConfig();
		config.showRules();
		
		int attempts=0;
		boolean win = false;
		
		
		
		while (attempts< config.getMaxAttempts()){
			System.out.print("Enter your guess: ");
			
			attempts++;
			int hintCount=0;
			int guess = ValidationService.validateInput(scanner.nextLine());
			String result =GuessValidator.validateGuess(guess, config.getTargetNumber());
			String hint=HintService.generateHint(config.getTargetNumber(),hintCount);
			hintCount++;
			
			boolean hintFlag=true;
			
			if ("Correct".equals(result)){
				System.out.println("CORRECT");
				win=true;
				break;
			}
			
			if(hintFlag) System.out.println(hint);
			
			if (hint.equals("No more hints available")) {
				hintFlag=false;
				
			};
			/*
			
			if (!"Correct".equals(result) && hintCount< config.getMaxHints()) {
				hintCount++;
				System.out.println( HintService.generateHint(config.getTargetNumber(), hintCount));
				
		}; */
	System.out.println(result);
	
	if("Correct".equals(result)){
		break;
	}
	}
	StorageService.saveResult(player,attempts,win);
}
}