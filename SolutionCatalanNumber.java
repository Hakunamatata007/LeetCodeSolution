
public class SolutionCatalanNumber {

	static int catalan(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		recur(n, dp);
		int out = dp[n];
		return out;
	}

	static int recur(int n, int[] dp) {

		if (dp[n] != 0)
			return dp[n];

		int sum = 0;
		int i = 1;
		while (i <= n / 2) {
			int right = recur(n - i, dp);
			int left = recur(i - 1, dp);
			sum += right * left;
			i++;
		}
		sum *= 2;
		sum += n % 2 != 0 ? recur(n - i, dp) * recur(i - 1, dp) : 0;
		dp[n] = sum;
		return sum;
	}

	public static void main(String[] args) {
		SolutionCatalanNumber.catalan(2);
	}

}
