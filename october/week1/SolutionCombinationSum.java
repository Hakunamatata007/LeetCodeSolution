package october.week1;

import java.util.ArrayList;
import java.util.List;

public class SolutionCombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		numberCombination(res, new ArrayList<>(), candidates, target, 0);
		return res;
	}

	private void numberCombination(List<List<Integer>> res, List<Integer> combination, int[] candidates, int sum,
			int start) {

		if (sum < 0) {
			return;
		}

		if (sum == 0) {
			List<Integer> newList = new ArrayList<>(combination);
			res.add(newList);
		}

		for (int i = start; i < candidates.length; i++) {
			combination.add(candidates[i]);
			numberCombination(res, combination, candidates, sum - candidates[i], i);
			combination.remove(combination.size() - 1);
		}

	}

	public static void main(String[] args) {
		SolutionCombinationSum sol = new SolutionCombinationSum();
		System.out.println(sol.combinationSum(new int[] { 2, 3, 5 }, 8));
	}

}
