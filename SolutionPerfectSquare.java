
public class SolutionPerfectSquare {

	static int min;
	static int[] dp;

	public static int numSquares(int n) {
		min = Integer.MAX_VALUE;
		dp = new int[n + 1];
		return minNumber(n);
	}

	static int minNumber(int sum) {

		if (sum <= 3)
			return sum;

		double sqRoot = Math.sqrt(sum);

		if (dp[sum] != 0) {
			return dp[sum];
		}

		int count = sum;
		if (sqRoot % 1 == 0) {
			// count += 1;
			dp[sum] = 1;
			return 1;
		}
		sqRoot = (int) sqRoot;
		for (int i = 1; i <= sqRoot; i++) {
			count = Math.min(1 + minNumber(sum - (i * i)), count);
		}
		dp[sum] = count;
		return count;
	}

	// leetcode best solution
	protected boolean isSquare(int n) {
		int sq = (int) Math.sqrt(n);
		return n == sq * sq;
	}

	int numSquares2(int n) {
		// four-square and three-square theorems.
		while (n % 4 == 0)
			n /= 4;
		if (n % 8 == 7)
			return 4;

		if (this.isSquare(n))
			return 1;
		// enumeration to check if the number can be decomposed into sum of two squares.
		for (int i = 1; i * i <= n; ++i) {
			if (this.isSquare(n - i * i))
				return 2;
		}
		// bottom case of three-square theorem.
		return 3;
	}

	public static void main(String[] args) {
		int out = SolutionPerfectSquare.numSquares(12);
		System.out.println(out);

	}

}
