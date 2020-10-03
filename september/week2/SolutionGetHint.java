package september.week2;

import java.util.HashMap;
import java.util.Map;

public class SolutionGetHint {

	public String getHint(String secret, String guess) {

		Map<Character, Integer> secretMap = new HashMap<>();
		int numberOfBulls = 0;
		int numberOfCows = 0;
		int[] indexVisited = new int[guess.length()];
		for (int i = 0; i < secret.length(); i++) {
			if (secret.charAt(i) == guess.charAt(i)) {
				numberOfBulls++;
				indexVisited[i]++;
			} else
				secretMap.put(secret.charAt(i), secretMap.getOrDefault(secret.charAt(i), 0) + 1);
		}
		for (int i = 0; i < guess.length(); i++) {
			if (indexVisited[i] == 0 && secretMap.getOrDefault(guess.charAt(i), 0) != 0) {
				numberOfCows++;
				secretMap.put(guess.charAt(i), secretMap.get(guess.charAt(i)) - 1);
			}
		}
		return numberOfBulls + "A" + numberOfCows + "B";
	}

	public static void main(String[] args) {
		SolutionGetHint sol = new SolutionGetHint();
		System.out.println(sol.getHint("11", "10"));
	}

}
