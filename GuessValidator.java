/* Use Case 2: User Guess Submission
* 
* This class is responsible for comparing
* the user's guess with the target number.
* 
* It does NOT handle input or output.
*
*/


class GuessValidator {
	public static String validateGuess(int guess, int target){
		
		if (guess == target){
			return "Correct";
			
		}
		// if guess is less than target then low gets printed
		// if LOW then Target is greater
		else if (guess<target){     
			return "Your guess is lower than the target";
	}
	return "Your guess is higher than the target";
}
}

