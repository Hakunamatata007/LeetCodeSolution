import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionTwoSum {

	static List<List<Integer>> twoSum(int[] nums, int sum) {
		List<List<Integer>> out = new ArrayList<>();
		int left = 0;
		int right = nums.length - 1;
		Arrays.sort(nums);
		while (left < right) {
			if (nums[left] + nums[right] > sum) {
				right--;
			} else if (nums[left] + nums[right] < sum) {
				left++;
			} else {
				out.add(Arrays.asList(nums[left], nums[right]));
				while (left < right && nums[left] == nums[left + 1]) {
					left++;
				}
				while (right > left && nums[right] == nums[right - 1]) {
					right--;
				}
				left++;
				right--;
			}
		}
		for (List<Integer> l : out) {
			System.out.println(l);
		}
		return out;
	}

	public static void main(String[] args) {
		SolutionTwoSum.twoSum(new int[] { 1, -1, -1, 0 }, 1);
	}

}
