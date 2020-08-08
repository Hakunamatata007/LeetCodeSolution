import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionLargestDivisibleSubset {

	static List<Integer> largestDivisibleSubset(int[] nums) {

		int maxIndex = 0;
		List<Integer> res = new ArrayList<>();
		int count[] = new int[nums.length];
		Arrays.fill(count, 1);
		Arrays.sort(nums);

		for (int i = 1; i < nums.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (nums[i] % nums[j] == 0) {
					count[i] = Math.max(count[i], count[j] + 1);
					// j = -1;
				}
			}
		}

		for (int i = 0; i < count.length; i++) {
			maxIndex = count[i] > count[maxIndex] ? i : maxIndex;
		}

		int temp = nums[maxIndex];
		int currentCount = count[maxIndex];
		for (int i = maxIndex; i >= 0 && currentCount > 0; i--) {
			if (temp % nums[i] == 0 && currentCount == count[i]) {
				res.add(nums[i]);
				temp = nums[i];
				currentCount--;
			}
		}

		res.forEach(value -> System.out.print(value));
		return res;
	}

	////////////// Second Solution

	static int maxV;
	static int maxL;
	static int cs;
	static int next[];
	static int len[];

	static List<Integer> largestDivisibleSubset2(int[] nums) {

		if (nums.length == 0)
			return new ArrayList<>();

		next = new int[nums.length];
		len = new int[nums.length];

		Arrays.sort(nums);
		maxV = nums[nums.length - 1];

		for (int j = 0; j < nums.length; j++) {
			dp(1, j, nums);

		}

		List<Integer> list = new ArrayList<>();
		int i = cs;
		while (i != -1) {
			list.add(nums[i]);
			i = next[i];
		}
		return list;

	}

	private static void dp(int cL, int start, int[] nums) {

		if (len[start] == 0) {
			len[start] = 1;
			next[start] = -1;
		}
		if (len[start] > maxL) {
			maxL = len[start];
			cs = start;
		}

		int limit = maxV >> Math.max(maxL - cL, 0);
		int max = 0;
		for (int j = start + 1; j < nums.length && nums[j] <= limit; j++) {

			if (nums[j] % nums[start] == 0) {

				if (len[j] == 0) {
					dp(cL + 1, j, nums);
				}

				if (len[j] > max) {
					max = len[j];
					next[start] = j;
					len[start] = len[j] + 1;
					if (len[start] > maxL) {
						maxL = len[start];
						cs = start;
						limit = maxV >> Math.max(0, maxL - cL);
					}

				}

			}

		}

	}

	public static void main(String[] args) {

		SolutionLargestDivisibleSubset.largestDivisibleSubset2(new int[] { 4, 8, 10, 240 });
	}

}
