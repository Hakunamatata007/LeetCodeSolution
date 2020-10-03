package august.week3;

import java.util.Arrays;

public class SolutionDistributeCandies {

	public int[] distributeCandies(int candies, int num_people) {

			int[] arr = new int[num_people];
			int candy = 1;
			int i = 0;
			while (candy <= candies) {
				if (i == num_people)
					i = 0;
				arr[i] += candy++;
				candies -= candy - 1;
				i++;
			}
	
			if (candies > 0) {
				if (i == num_people)
					i = 0;
				arr[i] += candies;
			}
	
			return arr;
	}

	public static void main(String[] args) {
		SolutionDistributeCandies sol = new SolutionDistributeCandies();
		System.out.println(Arrays.toString(sol.distributeCandies(10, 3)));
	}

}
