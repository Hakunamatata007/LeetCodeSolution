import java.util.HashMap;
import java.util.Map;

public class SolutionSubarraysDivByK {

	public int subarraysDivByK(int[] A, int K) {

		Map<Integer, Integer> map = new HashMap<>();
		int count = 0;
		int prefixSum = 0;
		map.put(0, 1);
		for (int i = 0; i < A.length; i++) {
			prefixSum += A[i];
			int remainder = prefixSum % K;
			remainder = remainder >= 0 ? remainder : remainder + K;
			count += map.getOrDefault(remainder, 0);
			map.put(remainder, map.getOrDefault(remainder, 0) + 1);

		}
		return count;

	}

	public static void main(String[] args) {
		SolutionSubarraysDivByK sol = new SolutionSubarraysDivByK();
		sol.subarraysDivByK(new int[] { -1, 2, 9 }, 2);

	}

}
