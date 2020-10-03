package september.week2;

import java.util.ArrayList;
import java.util.List;

public class SolutionCombinationSum3 {

	public List<List<Integer>> combinationSum3(int k, int n) {

		List<List<Integer>> res = new ArrayList<>();
		recur(k, n, res, new ArrayList<>(), 1);
		return res;

	}

	public void recur(int k, int sum, List<List<Integer>> res, List<Integer> currRes, int start) {

		if (k == currRes.size()) {
			if (sum == 0)
				res.add(new ArrayList<Integer>(currRes));
			return;
		}

		for (int i = start; i <= 9; i++) {
			currRes.add(i);
			recur(k, sum - i, res, currRes, i + 1);
			currRes.remove(currRes.size() - 1);
		}

	}

	public static void main(String[] args) {
		SolutionCombinationSum3 sol = new SolutionCombinationSum3();
		System.out.println(sol.combinationSum3(3, 7));
	}

}
