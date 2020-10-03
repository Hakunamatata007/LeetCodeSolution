package august.week2;

import java.util.LinkedList;
import java.util.Queue;

public class CombinationIterator {

	Queue<String> queue;

	public CombinationIterator(String characters, int combinationLength) {
		queue = new LinkedList<>();
		generateSubsets(new StringBuilder(), combinationLength, 0, characters);
	}

	private void generateSubsets(StringBuilder sb, int combinationLength, int length, String characters) {

		if (sb.length() == combinationLength) {
			queue.add(sb.toString());
			return;
		}

		for (int i = length; i < characters.length(); i++) {
			sb.append(characters.charAt(i));
			generateSubsets(sb, combinationLength, i + 1, characters);
			sb.deleteCharAt(sb.length() - 1);
		}

	}

	public String next() {

		return queue.poll();
	}

	public boolean hasNext() {

		return !queue.isEmpty();

	}

	public static void main(String[] args) {
		CombinationIterator sol = new CombinationIterator("abc", 2);
		System.out.println(sol.queue);
		 System.out.println(sol.hasNext());
		 System.out.println(sol.next());
		 System.out.println(sol.hasNext());
		 System.out.println(sol.next());
		 System.out.println(sol.hasNext());
		 System.out.println(sol.next());
		 System.out.println(sol.hasNext());

	}

}
