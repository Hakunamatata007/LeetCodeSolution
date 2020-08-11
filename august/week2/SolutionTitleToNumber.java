package august.week2;

//https://leetcode.com/problems/excel-sheet-column-number/
public class SolutionTitleToNumber {

	public int titleToNumber(String s) {
		int sum = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			sum += (s.charAt(i) - 'A' + 1) * Math.pow(26, s.length() - i - 1);
		}
		return sum;
	}

	public static void main(String[] args) {
		SolutionTitleToNumber sol = new SolutionTitleToNumber();
		System.out.println(sol.titleToNumber("AAA"));
	}
	// AAA - 703 - 1*26^2 + 1*26^1 + 1*26^0
	// AB - 1*26^1 + 2*26^0
}