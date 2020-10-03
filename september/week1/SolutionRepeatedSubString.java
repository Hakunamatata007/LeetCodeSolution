package september.week1;

import java.util.HashMap;
import java.util.Map;

public class SolutionRepeatedSubString {

	public boolean repeatedSubstringPattern(String s) {

		int subStringLength = 0;
		String subString = "";
		for (int i = 0; i < s.length(); i++) {
			int j = 1;
			while (j < s.length()) {
				if (s.charAt(j) == s.charAt(i)) {
					subStringLength = j - 0;
				} else {
					j++;
				}
				if (j == s.length())
					return false;
				if (subStringLength <= 0)
					continue;
				subString = s.substring(0, subStringLength);
				i = j;
				if (i + subStringLength > s.length())
					return false;
				while (i < s.length() && i + subStringLength <= s.length()
						&& subString.equals(s.substring(i, i + subStringLength))) {
					System.out.println("s.substring(i, i + subStringLength) " + s.substring(i, i + subStringLength));
					i = i + subStringLength;
				}
				if (i == s.length())
					return true;
				j++;
				subStringLength = 0;
				i = 0;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		SolutionRepeatedSubString sol = new SolutionRepeatedSubString();
		System.out.println(sol.repeatedSubstringPattern("abab"));
	}

}
