package october.week2;

import java.util.HashSet;
import java.util.Set;

public class SolutionBuddyStrings {

	public boolean buddyStrings(String A, String B) {

		if (A.length() != B.length())
			return false;

		if (A.equals(B)) {
			Set<Character> s = new HashSet<Character>();
			for (char c : A.toCharArray())
				s.add(c);
			return s.size() < A.length();
		}

		int index1 = -1, index2 = -1, count = 0;
		for (int i = 0; i < A.length(); i++) {
			if (A.charAt(i) != B.charAt(i)) {
				count++;
				if (index1 == -1)
					index1 = i;
				else if (index1 != -1 && index2 == -1)
					index2 = i;
			}
		}
		return count == 2 && A.charAt(index1) == B.charAt(index2) && A.charAt(index2) == B.charAt(index1);
	}

	public static void main(String[] args) {
		SolutionBuddyStrings sol = new SolutionBuddyStrings();
		System.out.println(sol.buddyStrings("aa", "aa"));
	}

}
