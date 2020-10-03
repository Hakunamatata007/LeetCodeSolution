package september.week4;

public class SolutionFindTheDifference {

	public char findTheDifference(String s, String t) {

		int sL = 0;
		int tL = 0;
		int xor = 0;
		// method1
		for (int i = 0; i < s.length() + 1; i++) {
			sL += i < s.length() ? s.charAt(i) : 0;
			tL += i < t.length() ? t.charAt(i) : 0;
		}

		// method2
		for (int i = 0; i < s.length() + 1; i++) {
			xor ^= (i < s.length() ? s.charAt(i) : 0) ^ (i < t.length() ? t.charAt(i) : 0);
		}

		System.out.println((char) Math.abs(sL - tL));
		System.out.println((char) xor);
		return (char) Math.abs(sL - tL);
	}

	public static void main(String[] args) {
		SolutionFindTheDifference sol = new SolutionFindTheDifference();
		System.out.println(sol.findTheDifference("abcd", "abced"));
	}

}
