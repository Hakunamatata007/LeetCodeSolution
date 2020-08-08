package july_week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SolutionTopKFrequent {

	static int[] topKFrequent(int[] nums, int k) {

		Arrays.sort(nums);
		int[] res = new int[k];
		int length = nums.length;
		Map<Integer, List<Integer>> map = new TreeMap<>(Collections.reverseOrder());
		int i = 0;
		while (i < length) {
			int counter = 1;
			while (i + 1 < length && nums[i] == nums[i + 1]) {
				counter++;
				i++;
			}
			if (map.containsKey(counter)) {
				List<Integer> temp = map.get(counter);
				temp.add(nums[i]);
				map.put(counter, temp);
			} else {
				List<Integer> temp = new ArrayList<>();
				temp.add(nums[i]);
				map.put(counter, temp);
			}
			i++;
		}
		k--;
		for (Map.Entry<Integer, List<Integer>> set : map.entrySet()) {
			List<Integer> temp = set.getValue();
			for (Integer integer : temp) {
				if (k < 0)
					break;
				res[k--] = integer;
			}
			if (k < 0)
				break;
		}
		System.out.println(Arrays.toString(res));
		return res;
	}

	public static void main(String[] args) {
		int[] res = new int[] { -1, -1, 1, 2, 2, 3, 4 };
		int k = 2;
		SolutionTopKFrequent.topKFrequent(res, k);
	}

}
