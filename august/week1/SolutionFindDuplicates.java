package august.week1;

import java.util.ArrayList;
import java.util.List;

public class SolutionFindDuplicates {

	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> result = new ArrayList<>();

		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			num = num < 0 ? -num : num;
			System.out.println(num);
			if (nums[num - 1] < 0) {
				result.add(num);
			} else
				nums[num - 1] = -1 * nums[num - 1];

		}
		System.out.println(result);
		return result;
	}

	public static void main(String[] args) {
		SolutionFindDuplicates sol = new SolutionFindDuplicates();
		sol.findDuplicates(new int[] { 4, 3, 2, 7, 8, 2, 3, 1 });
	}

}
