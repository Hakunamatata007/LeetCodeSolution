package october.week2;

import java.util.Arrays;

public class SolutionHouseRobber2 {

	public int rob(int[] nums) {
		if (nums.length == 1)
			return nums[0];
		int[] dp = new int[nums.length];
		Arrays.fill(dp, -1);
		int max1 = rob(nums, 0, dp, nums.length - 1);
		Arrays.fill(dp, -1);
		int max2 = rob(nums, 1, dp, nums.length);
		return Math.max(max1, max2);
	}

	// 2,3,2
	private int rob(int[] nums, int i, int[] dp, int maxIndex) {
		if (i >= maxIndex)
			return 0;
		if (dp[i] != 0)
			return dp[i];
		int consider = nums[i] + rob(nums, i + 2, dp, maxIndex);
		int notConsider = rob(nums, i + 1, dp, maxIndex);
		int max = Math.max(consider, notConsider);
		dp[i] = max;
		return max;
	}

	public static void main(String[] args) {
		SolutionHouseRobber2 sol = new SolutionHouseRobber2();
		System.out.println(sol.rob(new int[] { 1, 2 }));
	}

}
