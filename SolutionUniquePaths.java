
public class SolutionUniquePaths {

	static int uniquePaths(int m, int n) {
		int dp[][] = new int[m][n];
		int out = recur(m - 1, n - 1, dp);
		System.out.println(out);
		return out;
	}

	static int recur(int m, int n, int[][] dp) {
		int paths = 0;
		if (m == 0 || n == 0)
			return 1;
		if (dp[m][n] != 0) {
			return dp[m][n];
		}
		paths = recur(m, n - 1, dp) + recur(m - 1, n, dp);
		dp[m][n] = paths;
		return paths;
	}

	public static void main(String[] args) {
		SolutionUniquePaths.uniquePaths(2, 2);

	}

}
