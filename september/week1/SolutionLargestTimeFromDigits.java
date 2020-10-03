package september.week1;

import java.util.HashMap;
import java.util.Map;

public class SolutionLargestTimeFromDigits {

	public String largestTimeFromDigits(int[] A) {

		String result = "";
		for (int i = 0; i < 4; ++i) {
			for (int j = 0; j < 4; ++j) {
				for (int k = 0; k < 4; ++k) {
					if (i == j || j == k || k == i)
						continue;
					String hh = A[i] + "" + A[j];
					String mm = A[k] + "" + A[6 - i - j - k];
					String _time = hh + ":" + mm;
					if (hh.compareTo("24") < 0 && mm.compareTo("60") < 0 && _time.compareTo(result) > 0)
						result = _time;
				}
			}
		}
		return result;
	}

	public String largestTimeFromDigits1(int[] A) {
		String result = "";
		Map<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		
		// position of 6 could be at either 1th or 3rd index;
		// if #6 >= 2 then the maximum hour could be 1
		int sixGtCount = 0;
		for (int i : A) {
			sum += i;
			map.put(i, map.getOrDefault(i, 0) + 1);
			if (i >= 6)
				sixGtCount++;
		}

		int maxHour = sixGtCount == 2 ? 1 : 2;

		int h1 = -1;
		for (int i = maxHour; i >= 0; i--) {
			if (map.containsKey(i)) {
				h1 = i;
				map.put(i, map.get(i) - 1);
				break;
			}
		}

		int h2 = -1;
		// if h1 == 2 then h2 0->3
		// if h1 == 1 then h2 0->9
		// if h1 == 0 then h2 0->9

		int start = h1 == 2 ? 3 : 9;
		for (int i = start; i >= 0; i--) {
			if (map.containsKey(i) && map.get(i) > 0) {
				h2 = i;
				map.put(i, map.get(i) - 1);
				break;
			}
		}

		int m1 = -1;
		for (int i = 5; i >= 0; i--) {
			if (map.containsKey(i) && map.get(i) > 0) {
				m1 = i;
				map.put(i, map.get(i) - 1);
				break;
			}
		}

		int m2 = sum - h1 - h2 - m1;
		result = h1 + "" + h2 + ":" + m1 + "" + m2;
		result = result.length() == 5 ? result : "";
		System.out.println(result);
		return result;
	}

	public static void main(String[] args) {
		SolutionLargestTimeFromDigits sol = new SolutionLargestTimeFromDigits();
		sol.largestTimeFromDigits1(new int[] { 2, 0, 6, 6 });
	}
	// "06:26"

}
