package september.week4;

import java.util.Arrays;

public class SolutionNumSubarrayProductLessThanK {

	public int numSubarrayProductLessThanK(int[] nums, int k) {

		int prod = 1;
		int count = 0;
		int start = 0;
		int end = 0;
		for (int i = 0; end < nums.length; i++) {
			prod = 1;
			for (int j = i; j < nums.length; j++) {
				prod *= nums[j];
				if (prod < k) {
					count += end++ - start + 1;
				} else {

					break;
				}
			}
		}

		return count;

	}

	public static void main(String[] args) {
		SolutionNumSubarrayProductLessThanK sol = new SolutionNumSubarrayProductLessThanK();
		System.out.println(sol.numSubarrayProductLessThanK(new int[] { 10, 5, 2, 6 }, 100));
	}

}
