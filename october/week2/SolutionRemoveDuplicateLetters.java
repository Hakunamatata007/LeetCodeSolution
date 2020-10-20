package october.week2;

public class SolutionRemoveDuplicateLetters {

	public String removeDuplicateLetters(String s) {

		int[] charArray = new int[26];
		char[] arr = s.toCharArray();
		for (char c : arr) {
			charArray[c - 'a']++;
		}
		String out = "";
		for (int i = 0; i < 26; i++) {
			if (charArray[i] != 0) {
				out += (char) (i + 'a');
			}
		}
		return out;

	}

	public static void main(String[] args) {
		SolutionRemoveDuplicateLetters sol = new SolutionRemoveDuplicateLetters();
		System.out.println(sol.removeDuplicateLetters(""));

	}

}
