import java.util.HashMap;
import java.util.Map;

public class SolutionGetPermutation {

	static Map<Integer, Integer> factTable = new HashMap<>();

	static void createFactorial() {
		factTable.put(0, 1);
		factTable.put(1, 1);
		factTable.put(2, 2);
		factTable.put(3, 6);
		factTable.put(4, 24);
		factTable.put(5, 120);
		factTable.put(6, 720);
		factTable.put(7, 5040);
		factTable.put(8, 40320);
		factTable.put(9, 362880);
	}

	static String getPermutation(int n, int k) {
		createFactorial();
		String input = "";
		String output = "";
		for (int i = 1; i <= n; i++) {
			input += i;
		}
		int N = 0;
		System.out.println("input" + input);
		for (int i = 1; i < n; i++) {
			int index = 0;
			N = getFactorial(n - i);
			while (k > N) {
				k = k - N;
				index++;
			}
			output += input.charAt(index);
			input = charRemoveAt(input, index);
		}
		output += input;
		System.out.println(output);
		return output;
	}

	static String charRemoveAt(String str, int p) {
		return str.substring(0, p) + str.substring(p + 1);
	}

	static int getFactorial(int n) {
		return factTable.get(n);
	}

	public static void main(String[] args) {
		SolutionGetPermutation.getPermutation(3, 2);
	}

}
