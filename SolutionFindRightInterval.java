import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SolutionFindRightInterval {

	public int[] findRightInterval(int[][] intervals) {

		Map<Integer, Integer> freq = new HashMap<>();
		int[] arr = new int[intervals.length];
		int[] res = new int[intervals.length];
		for (int i = 0; i < intervals.length; i++) {
			freq.put(intervals[i][0], i);
			arr[i] = intervals[i][0];
		}
		Arrays.sort(arr);

		for (int i = 0; i < intervals.length; i++) {
			int index = next(arr, intervals[i][1]);
			if (arr[index] >= intervals[i][1])
				res[i] = freq.get(arr[index]);
			else
				res[i] = -1;
		}
		return res;
	}

	private static int next(int[] arr, int target) {
		int s = 0;
		int e = arr.length - 1;
		while (s < e) {
//			int mid = s + (e - s) / 2;
			int mid = s + e >>> 1;
			if (arr[mid] < target)
				s = mid + 1;
			else
				e = mid;
		}
		return s;
	}

	public static void main(String[] args) {
		SolutionFindRightInterval sol = new SolutionFindRightInterval();
		sol.findRightInterval(new int[][] { { 3, 4 }, { 2, 3 }, { 1, 2 } });
	}

}
