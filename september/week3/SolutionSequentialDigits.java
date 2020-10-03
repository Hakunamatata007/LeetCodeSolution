package september.week3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SolutionSequentialDigits {

	public List<Integer> sequentialDigits(int low, int high) {

		List<Integer> result = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= 9; i++) {
			sb.append(i);
			int temp = i;
			while (sb.length() != Integer.toString(low).length() || sb.length() != Integer.toString(high).length()) {
				sb.append(++temp);
				if (Integer.toString(temp).length() > 1
						|| (sb.length() >= Integer.toString(high).length() && Integer.parseInt(sb.toString()) >= high))
					break;
				if (sb.length() >= Integer.toString(low).length() && Integer.parseInt(sb.toString()) >= low
						&& sb.length() <= Integer.toString(high).length() && Integer.parseInt(sb.toString()) <= high) {
					result.add(Integer.parseInt(sb.toString()));
				}
			}
			// if (prevSize == result.size())
			// break;
			sb.setLength(0);

		}

		result.sort(Comparator.naturalOrder());
		System.out.println(result);
		return result;

	}

	public static void main(String[] args) {
		SolutionSequentialDigits sol = new SolutionSequentialDigits();
		// System.out.println(Integer.parseInt("12345678910"));
		sol.sequentialDigits(58, 155);
	}

}
