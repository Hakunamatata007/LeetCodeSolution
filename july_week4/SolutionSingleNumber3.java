package july_week4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SolutionSingleNumber3 {

	public int[] singleNumber(int[] nums) {

		Map<Integer, Integer> map = new HashMap<>();
		for (int i : nums) {
			if (map.containsKey(i)) {
				map.remove(i);
			} else {
				map.put(i, 1);
			}
		}
		int[] a = map.keySet().stream().mapToInt(x -> x).toArray();
		System.out.println(Arrays.toString(a));
		return a;

	}

	public static void main(String[] args) {
		SolutionSingleNumber3 sol = new SolutionSingleNumber3();
		sol.singleNumber(new int[] { 1, 2, 1, 3, 2, 5 });
	}

}
