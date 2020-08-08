package august.week1;

public class SolutionIsPowerOfFour {

	public boolean isPowerOfFour(int num) {

		if (num == 0) return false;
		double constant = Math.log(4.0);
		double ans = Math.log(num) / constant;

		System.out.println(constant + " " + ans);

		return Math.floor(ans) == ans;

	}

	public static void main(String[] args) {
		SolutionIsPowerOfFour sol = new SolutionIsPowerOfFour();
		System.out.println(sol.isPowerOfFour(0));
	}

}
