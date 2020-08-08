package july_week4;
					
import java.util.Arrays;
import java.util.Collections;

public class SolutionLeastInterval {

	public int leastInterval(char[] tasks, int n) {

		int[] charMap = new int[26];
		for (char ch : tasks) {
			charMap[ch - 'A']++;
		}
		Arrays.sort(charMap);
		int maxValue = charMap[25] - 1;
		int idleSpaces = maxValue * n;
		for (int i = 24; i >= 0; i--) {
//			idleSpaces = idleSpaces - Math.min(maxValue,charMap[i]);
			if(charMap[i] == 0)
				break;
		}
		idleSpaces = idleSpaces > 0 ? idleSpaces : 0;
		System.out.println(tasks.length + idleSpaces);
		return tasks.length + idleSpaces;

	}

	public static void main(String[] args) {
		SolutionLeastInterval sol = new SolutionLeastInterval();
		sol.leastInterval(new char[] 
//				{ 'B', 'C', 'D', 'E', 'A', 'A', 'A', 'A', 'A', 'A', 'F', 'G' }
				{ 'B', 'B', 'B', 'A', 'A', 'A' }
		, 3);
	}

}
