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
		else if (guess<target){
			return "Low";
	}
	return "High";
}
}

