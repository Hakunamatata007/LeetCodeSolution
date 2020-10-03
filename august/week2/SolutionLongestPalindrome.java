package august.week2;

import java.util.HashMap;
import java.util.Map;

public class SolutionLongestPalindrome {

	public int longestPalindrome(String s) {

		Map<Character, Integer> map = new HashMap<>();

		for (char ch : s.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		int[] count = new int[2];
		map.forEach((k, val) -> {
			if (val % 2 == 0)
				count[0] += val;
			else {
				count[1] = 1;
				count[0] += val - 1;
			}
		});
		System.out.println(map);
		return count[1] == 1 ? count[0] + 1 : count[0];

	}

	public static void main(String[] args) {
		SolutionLongestPalindrome sol = new SolutionLongestPalindrome();
		System.out.println(sol.longestPalindrome("ccc"));
	}

}
