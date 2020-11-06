package november.week1;

public class SolutionConsecutiveCharacters {

	public int maxPower(String s) {

		int power = 0;
		for (int i = 0; i < s.length(); i++) {
			int localPower = 1;
			while (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
				localPower++;
				i++;
			}
			power = Math.max(power, localPower);
		}
		return power;
	}

	public static void main(String[] args) {
		SolutionConsecutiveCharacters sol = new SolutionConsecutiveCharacters();
		System.out.println(sol.maxPower("tourist"));
	}

}
