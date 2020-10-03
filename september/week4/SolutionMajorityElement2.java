package september.week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SolutionMajorityElement2 {

	public List<Integer> majorityElement(int[] nums) {

		int candidate1 = -1;
		int candidate2 = -1;
		int count1 = 0;
		int count2 = 0;
		List<Integer> res = new ArrayList<>();

		for (int i : nums) {

			if (candidate1 != -1 && candidate1 == i) {
				count1++;
			} else if (candidate2 != -1 && candidate2 == i) {
				count2++;
			} else if (count2 == 0) {
				candidate2 = i;
				count2++;
			} else if (count1 == 0) {
				candidate1 = i;
				count1++;
			} else {
				count1--;
				count2--;
			}
		}
		count1 = count2 = 0;
		for (int i : nums) {
			if (candidate1 == i)
				count1++;
			else if (candidate2 == i)
				count2++;
		}
		if (count1 > nums.length / 3)
			res.add(candidate1);
		if (count2 > nums.length / 3)
			res.add(candidate2);

		return res;

	}

	public static void main(String[] args) {

		SolutionMajorityElement2 sol = new SolutionMajorityElement2();
		System.out.println(sol.majorityElement(new int[] { 1 }));
	}
}
