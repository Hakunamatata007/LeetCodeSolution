package september.week2;

public class SolutionRob {

	public int rob(int[] nums) {

		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);
		if (nums == null || nums.length == 0)
			return 0;

		if (nums.length == 1)
			return nums[0];

		for (int i = 2; i < nums.length; i++) {
			dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
		}

		return dp[nums.length - 1];
		// return recur(nums, 0);
	}

	public int recur(int[] nums, int i) {

		if (i >= nums.length)
			return 0;

		int selected = nums[i] + recur(nums, i + 2);
		int unSelected = recur(nums, i + 1);
		return Math.max(selected, unSelected);
	}

	public static void main(String[] args) {
		SolutionRob sol = new SolutionRob();
		System.out.println(sol.rob(new int[] { 1, 2, 3, 1 }));
	}

}
