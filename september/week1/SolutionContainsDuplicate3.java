package september.week1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SolutionContainsDuplicate3 {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

		// t = number diff, k = index diff
		boolean flag = false;
		Map<Integer, List<Integer>> map = new TreeMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.computeIfAbsent(nums[i], (x -> new ArrayList<Integer>())).add(i);
		}
		for (int i = 0; i < nums.length; i++) {
			int maxDiff = Math.abs(nums[i] - t);
			int ignoreIndex = i;
			List<Integer> numsWithAtMostDiff = new ArrayList<>();
			for (int j = maxDiff; j >= 0; j--) {
				if (j != ignoreIndex && map.containsKey(j)) {
					numsWithAtMostDiff.add(j);
					flag = true;
				}
			}
			if (!flag)
				continue;
			List<Integer> indexesOfNums = map.get(nums[i]);
			for (int j = 0; j < numsWithAtMostDiff.size(); j++) {
				List<Integer> indexesOfDiff = map.get(numsWithAtMostDiff.get(j));
				for (int l = 0; l < indexesOfDiff.size(); l++) {
					for (int l2 = 0; l2 < indexesOfNums.size(); l2++) {
						if (Math.abs(indexesOfNums.get(l2) - indexesOfDiff.get(l)) <= k)
							return true;
					}
				}
			}
			flag = false;
		}

		System.out.println(map);
		return false;
	}

	public static void main(String[] args) {
		SolutionContainsDuplicate3 sol = new SolutionContainsDuplicate3();
		System.out.println(sol.containsNearbyAlmostDuplicate(new int[] { 1, 2, 3, 1 }, 3, 0));
	}

}
