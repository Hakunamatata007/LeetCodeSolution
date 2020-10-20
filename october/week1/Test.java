package october.week1;

import java.util.LinkedList;
import java.util.Queue;

class RecentCounter {

	int requests;
	Queue<Integer> req;

	public RecentCounter() {
		requests = 0;
		req = new LinkedList<>();
	}

	public int ping(int t) {

		req.add(t);
		while (!req.isEmpty() && req.peek() < t - 3000)
			req.remove();
		return req.size();
	}

}

public class Test {
	public static void main(String[] args) {
		RecentCounter sol = new RecentCounter();
		System.out.println(sol.ping(1));
		System.out.println(sol.ping(100));
		System.out.println(sol.ping(3001));
		System.out.println(sol.ping(3002));
		// System.out.println(sol.ping(1));
	}
}
