package july_week5;

public class SolutionClimbStairs {

	public int climbStairs(int n) {

		int[] dp = new int[n + 1];
		return climbStairs(n, 0, n, dp);

	}

	public int climbStairs(int n, int step, int totalSteps, int[] dp) {

		if (n < 0) {
			return 0;
		}

		if (dp[n] != 0)
			return dp[n];

		if (step == totalSteps)
			return 1;
		int stepAs1 = climbStairs(n - 1, step + 1, totalSteps, dp);
		int stepAs2 = climbStairs(n - 2, step + 2, totalSteps, dp);
		int count = stepAs1 + stepAs2;
		dp[n] = count;
		return count;

	}

	public static void main(String[] args) {
		SolutionClimbStairs sol = new SolutionClimbStairs();
		int steps = sol.climbStairs(3);
		System.out.println(steps);
	}

}
