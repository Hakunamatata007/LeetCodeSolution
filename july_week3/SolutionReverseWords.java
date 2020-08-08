package july_week3;

import java.util.Arrays;

public class SolutionReverseWords {

	static String reverseWords(String s) {

		// String[] strArr = s.split("\\s+");
		// System.out.println(Arrays.deepToString(strArr));
		// String result = "";
		// for (int i = strArr.length - 1; i >= 0; i--) {
		// result += strArr[i] + " ";
		// }
		// result = result.trim();
		// System.out.println(result);
		// return result;

		if (s == null)
			return s;
		StringBuilder ans = new StringBuilder();
		int i = s.length() - 1;
		int j = i;
		while (i >= 0) {
			while (i >= 0 && s.charAt(i) == ' ') {
				i--;
				j = i; // last character
			}
			while (i >= 0 && s.charAt(i) != ' ') {
				i--;
			}
			if (j != i)
				ans.append(s, i + 1, j + 1).append(' ');
		}
		if (ans.length() - 1 >= 0 && ans.charAt(ans.length() - 1) == ' ')
			ans = ans.deleteCharAt(ans.length() - 1);
		System.out.println(ans.length());
		System.out.println(s.length());
		return ans.toString();
	}

	public static void main(String[] args) {
		SolutionReverseWords.reverseWords(" g ");
	}

}
