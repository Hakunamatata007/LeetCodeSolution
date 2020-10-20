package october.week3;

import java.util.Arrays;
import java.util.stream.Stream;

public class SolutionArrayRotation {
	public void rotate(int[] nums, int k) {

		if (nums.length == 0 || k == 0)
			return;
		k %= nums.length;
		int remLen = nums.length - k;
		rev(nums, 0, remLen - 1);
		rev(nums, remLen, nums.length - 1);
		rev(nums, 0, nums.length - 1);
	}

	private void rev(int[] nums, int start, int end) {

		while (start < end) {
			swap(nums, start++, end--);
		}
	}

	private void swap(int[] nums, int x, int y) {
		nums[x] = nums[x] ^ nums[y];
		nums[y] = nums[x] ^ nums[y];
		nums[x] = nums[x] ^ nums[y];
	}

	public static void main(String[] args) {
		SolutionArrayRotation sol = new SolutionArrayRotation();
		int[] arr = new int[] { -1, -100, 3, 99 };
		sol.rotate(arr, 2);
		System.out.println(Arrays.toString(arr));
	}
	// 1,2,3,4,5,6,7 -> rev(4,3,2,1,5,6,7) -> rev(4,3,2,1,7,6,5) -> rev(complete)
	// 7,6,5,4,3,2,1
	// 5,6,7,1,2,3,4
}
