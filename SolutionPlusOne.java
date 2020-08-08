import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SolutionPlusOne {

	static int[] plusOne(int[] digits) {
		List<Integer> output = new ArrayList<>();
		String number = "";
		int carry = 1;
		for (int i = digits.length - 1; i >= 0; i--) {
			int temp = digits[i] + carry;
			if (temp > 9) {
				output.add(0);
				carry = 1;
			} else {
				output.add(temp);
				carry = 0;
			}
		}
		boolean i = (carry == 1) ? output.add(carry) : false;
		Collections.reverse(output);
		 System.out.println(Arrays.toString(output.toArray()));
		return output.stream().mapToInt(Integer::intValue).toArray();
	}

	public static void main(String[] args) {
		SolutionPlusOne.plusOne(new int[] { 9 });
	}

}
