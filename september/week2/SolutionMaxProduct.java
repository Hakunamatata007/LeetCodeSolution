package september.week2;

public class SolutionMaxProduct {

	public int maxProduct(int[] nums) {

		int currMax = nums[0];
		int currMin = nums[0];
		int result = nums[0];
		for (int i = 1; i < nums.length; i++) {
			int prevMax = currMax;
			currMax = Math.max(nums[i], Math.max(currMax * nums[i], currMin * nums[i]));
			currMin = Math.min(nums[i], Math.min(prevMax * nums[i], currMin * nums[i]));
			result = Math.max(currMax, result);
		}

		return result;

	}

	public static void main(String[] args) {
		SolutionMaxProduct sol = new SolutionMaxProduct();
		System.out.println(sol.maxProduct(new int[] { 2, 3, -2, 4 }));
	}

}
