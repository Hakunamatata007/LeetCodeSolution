package august.week1;

public class SolutionDetectCapital {

	public boolean detectCapitalUse(String word) {

		return word.matches("[a-z]+|[A-Z][a-z]*|[A-Z]+");
	}

	public static void main(String[] args) {
		SolutionDetectCapital sol = new SolutionDetectCapital();
		boolean flag = sol.detectCapitalUse("FlaG");
		System.out.println(flag);
	}

}
