package july_week3;

public class SolutionAddBinary {

	public String addBinary(String a, String b) {

		int length = a.length() > b.length() ? a.length() : b.length();

		String temp = "";
		int diff = Math.abs(a.length() - b.length());
		while (diff != 0) {
			temp += "0";
			diff--;
		}
		// 1 - 49
		// 0 - 48
		if (a.length() < b.length())
			a = temp + a;
		else
			b = temp + b;
		int carry = 0;
		String result = "";
		for (int i = length - 1; i >= 0; i--) {
			int x = a.charAt(i) - 48;
			int y = b.charAt(i) - 48;
			System.out.println(x + " " + y);
			String temp2;
			int cal = x + y + carry;
			if (cal > 1) {
				temp2 = Integer.toString(cal - 2);
				carry = 1;
			} else {
				temp2 = Integer.toString(cal);
				carry = 0;
			}
			result = temp2 + result;
		}
		result = carry == 1 ? 1 + result : result.startsWith("0") ? result.replaceFirst("^0+(?!$)", "") : result;
		System.out.println(result);
		return result;

	}

	public static void main(String[] args) {

		SolutionAddBinary sol = new SolutionAddBinary();
		sol.addBinary("1111", "1111");
	}

}
// "11110"
// "10000"
