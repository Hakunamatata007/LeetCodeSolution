public class SolutionCoins2 {
	public static int change(int amount, int[] coins) {
		int m = coins.length;
		int[][] dp = new int[m + 1][amount + 1];
		long out = countWays(coins, m, amount);
		System.out.println(out);
		return (int) out;
		// return dp[m][amount ];
	}

	static long countWays(int S[], int m, int n) {
		// Time complexity of this function: O(mn)
		// Space Complexity of this function: O(n)

		// table[i] will be storing the number of solutions
		// for value i. We need n+1 rows as the table is
		// constructed in bottom up manner using the base
		// case (n = 0)
		long[] table = new long[n + 1];

		// Initialize all table values as 0
		// Arrays.fill(table, 0); //O(n)

		// Base case (If given value is 0)
		table[0] = 1;

		// Pick all coins one by one and update the table[]
		// values after the index greater than or equal to
		// the value of the picked coin
		for (int i = 0; i < m; i++)
			for (int j = S[i]; j <= n; j++)
				table[j] += table[j - S[i]];

		return table[n];
	}

	public static int count(int S[], int m, int n, int[][] dp) {

		// If n is 0 then there is 1 solution
		// (do not include any coin)
		if (n == 0)
			return 1;

		// If n is less than 0 then no
		// solution exists
		if (n < 0)
			return 0;

		// If there are no coins and n
		// is greater than 0, then no
		// solution exist
		if (m <= 0 && n >= 1)
			return 0;

		if (dp[m][n] != 0)
			return dp[m][n];

		// count is sum of solutions (i)
		// including S[m-1] (ii) excluding S[m-1]
		int sum = count(S, m - 1, n, dp) + count(S, m, n - S[m - 1], dp);
		dp[m][n] = sum;
		return sum;

	}

	static boolean powerOfTwo(int x) {
		boolean val = ((x & (x - 1)) == 0);
		return val;
	}

	public static int searchInsert(int[] nums, int target) {

		// if (target > nums[nums.length - 1]) {
		// return nums.length;
		// }
		//
		// int l = 0;
		// int r = nums.length - 1;
		//
		// while (l < r) {
		// int m = l + (r - l) / 2;
		// if (target > nums[m]) {
		// l = m + 1;
		// } else {
		// r = m;
		// }
		// }
		// System.out.println(l);
		// return l;

		int start = 0;
		int end = nums.length - 1;
		int mid = 0;
		while (start < end) {
			mid = start + (end - 1) / 2;
			if (target > nums[mid]) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		return start;
		//
		// int start = 0;
		// int end = nums.length - 1;
		// boolean flag = true;
		// int temp = 0;
		// int mid = 0;
		// while (start < end) {
		// mid = (start + end) / 2;
		// if (target == nums[mid]) {
		// return mid;
		// }
		// if (mid == nums.length)
		// return start;
		// if (mid == 0) {
		// return end;
		// }
		// if (target > nums[mid]) {
		// start = mid + 1;
		// temp = start;
		// } else {
		// end = mid;
		// }
		// }
		// if(start == end)
		// return start + 1;
		// return start;
	}

	public static void main(String[] args) {

		int[] arr = { 1, 3, 5, 6 };
		// SolutionCoins2.change(5, arr);
		// SolutionCoins2.powerOfTwo(4);
		SolutionCoins2.searchInsert(arr, 5);
	}
}
