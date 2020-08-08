import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionThreeSum {

	static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> out = new ArrayList<>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			if (i == 0 || nums[i - 1] != nums[i]) {
				twoSum(nums, -nums[i], i, out);
			}
		}
		for (List<Integer> l : out) {
			System.out.println(l);
		}
		return out;
	}

	static void twoSum(int[] nums, int sum, int start, List<List<Integer>> out) {
		int left = start + 1;
		int right = nums.length - 1;
		while (left < right) {
			if (nums[left] + nums[right] > sum) {
				right--;
			} else if (nums[left] + nums[right] < sum) {
				left++;
			} else {
				out.add(Arrays.asList(nums[start], nums[left], nums[right]));
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
	}

	// static int recur(int[] nums, int sum, int count, int i, List<Integer> list) {
	//
	// if (count == 0 && sum == 0) {
	// List<Integer> l = new ArrayList<>();
	// l.addAll(list);
	// out.add(l);
	// // list.remove(list.size() - 1);
	// return 1;
	// }
	// if (i < 0 || count == 0) {
	// // list.clear();
	// return 0;
	// }
	// int c2 = recur(nums, sum, count, i - 1, list);
	// list.add(nums[i]);
	// int c1 = recur(nums, sum + nums[i], count - 1, i - 1, list);
	// return c1 + c2;
	// }

	public static void main(String[] args) {
		SolutionThreeSum.threeSum(new int[] { -4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6 });
	}
}

// List<Integer> l = new ArrayList<>();
// l.addAll(list);
// out.add(l);
// list.clear();