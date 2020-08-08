package july_week4;

public class SolutionAddDigit {

	public int addDigits(int num) {

		return num % 9 == 0 ? 0 : num % 9;
	}

	public static void main(String[] args) {
		SolutionAddDigit sol = new SolutionAddDigit();
		sol.addDigits(21);
	}

}
