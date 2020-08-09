import java.util.HashMap;
import java.util.Map;

public class SolutionSubArrayEqualSum {

	public int subarraySum(int[] nums, int k) {

		Map<Integer, Integer> map = new HashMap<>();
		int count = 0;
		int prefixSum = 0;
		map.put(0, 1);
		for (int i = 0; i < nums.length; i++) {
			prefixSum += nums[i];
			count += map.getOrDefault(prefixSum - k, 0);
			map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
		}
		System.out.println(map);
		System.out.println(count);
		return count;

	}

	public static void main(String[] args) {

		SolutionSubArrayEqualSum sol = new SolutionSubArrayEqualSum();
		sol.subarraySum(new int[] { 4,5,0,-2,-3,1 }, 5);

	}

}
