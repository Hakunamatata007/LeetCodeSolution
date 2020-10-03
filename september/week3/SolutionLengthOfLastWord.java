package september.week3;

public class SolutionLengthOfLastWord {

	public int lengthOfLastWord(String s) {

		int i = s.length() - 1;
		int j = 0;
		while (i >= 0 && !s.substring(i, i + 1).matches("[a-zA-Z]")) {
			i--;
		}
		j = i;
		while (j >= 0 && s.substring(j, j + 1).matches("[a-zA-Z]")) {
			j--;
		}
		return i - j;
	}

	public static void main(String[] args) {
		SolutionLengthOfLastWord sol = new SolutionLengthOfLastWord();
		System.out.println(sol.lengthOfLastWord("  "));
	}

}
