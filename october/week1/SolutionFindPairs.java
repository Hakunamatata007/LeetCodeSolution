package october.week1;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SolutionFindPairs {

	public int findPairs(int[] nums, int k) {

		Map<Integer, Integer> map = new HashMap<>();
		for (int i : nums) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		int[] counter = new int[] { 0 };
		map.keySet().forEach(key -> {
			if (k == 0) {
				counter[0] += map.get(key) >= 2 ? 1 : 0;
			} else {
				counter[0] += map.containsKey(key - k) ? 1 : 0;
			}
		});
		return counter[0];

	}

	public static void main(String[] args) {
		SolutionFindPairs sol = new SolutionFindPairs();
		System.out.println(sol.findPairs(new int[] { 1, 3, 1, 5, 4 }, 0));
	}

}
