package july_week3;

public class SolutionPower {

	static double myPow(double x, int y) {

		double temp;
		if (y == 0)
			return 1;
		temp = myPow(x, y / 2);

		if (y % 2 == 0)
			return temp * temp;
		else { // y is odd
			if (y > 0)
				return x * temp * temp;
			else
				return (temp * temp) / x;
		}

	}

	static double myPow2(double x, int n) {
		long N = n;
		if (N < 0) {
			x = 1 / x;
			N = -N;
		}
		return helper(x, N);
	}

	private static double helper(double x, long n) {
		if (n == 0)
			return 1;
		return (n % 2 == 0) ? helper(x * x, n / 2) : x * helper(x * x, n / 2);
	}

	public static void main(String[] args) {
		SolutionPower.myPow2(2, -4);
	}

}
