package august.week1;

public class SolutionValidPalindrome {

	public boolean isPalindrome(String s) {

		s = s.replaceAll("[^\\w\\d]|[_]", "");
		System.out.println(s);
		for (int i = 0; i < s.length() / 2; i++) {
			if (Character.toUpperCase(s.charAt(i)) != Character.toUpperCase(s.charAt(s.length() - 1 - i))) {
				return false;
			}
		}

		return true;

	}

	public static void main(String[] args) {
		SolutionValidPalindrome sol = new SolutionValidPalindrome();
		System.out.println(sol.isPalindrome("a b c"));
	}

}
