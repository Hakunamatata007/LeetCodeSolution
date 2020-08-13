package august.week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SolutionPascalTriangle {

	public List<List<Integer>> generate(int numRows) {

		List<List<Integer>> pascal = new ArrayList<>();
		pascal.add(Arrays.asList(1)); // 0
		pascal.add(Arrays.asList(1, 1)); // 1

		for (int i = 2; i < numRows; i++) {
			List<Integer> previous = pascal.get(i - 1);
			int[] temp = new int[i + 1];
			temp[0] = temp[i] = 1;
			for (int j = 0; j <= (i - 1) / 2; j++) {
				int sum = previous.get(j) + previous.get(j + 1);
				temp[j + 1] = sum;
				if (i - j - 1 < i)
					temp[i - j - 1] = sum;
			}
			pascal.add(Arrays.stream(temp).boxed().collect(Collectors.toList()));
		}
		return pascal;
	}

	public static void main(String[] args) {
		SolutionPascalTriangle sol = new SolutionPascalTriangle();
		sol.generate(7);

	}

}
