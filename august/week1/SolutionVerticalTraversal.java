package august.week1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SolutionVerticalTraversal {

	public List<List<Integer>> verticalTraversal(TreeNode root) {

		List<List<Integer>> res = new ArrayList<>();
		Map<Integer, Map<Integer, List<Integer>>> map = new TreeMap<>();

		dfs(root, 0, 0, map);
		System.out.println(map);
		map.forEach((key, value) -> {
			// value -> map
			List<Integer> temp = new ArrayList<>();
			value.forEach((k, v) -> {
				Collections.sort(v);
				temp.addAll(v);
			});
			res.add(temp);
		});
		System.out.println(res);
		return res;

	}

	private void dfs(TreeNode root, int currentX, int currentY, Map<Integer, Map<Integer, List<Integer>>> map) {

		if (root == null || root.val == null)
			return;

		map.computeIfAbsent(currentX, x -> new TreeMap<>()).computeIfAbsent(currentY, x -> new ArrayList<>())
				.add((Integer) root.val);

		dfs(root.left, currentX - 1, currentY + 1, map);
		dfs(root.right, currentX + 1, currentY + 1, map);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SolutionVerticalTraversal sol = new SolutionVerticalTraversal();
		Tree tree = new Tree();
		Object[] arr = new Object[] { 0, 2, 1, 3, null, null, null, 4, 5, null, 7, 6, null, 10, 8, 11, 9 };
		tree.root = tree.insertLevelOrder(arr, tree.root, 0);
		sol.verticalTraversal(tree.root);

	}

}
// [0,5,1,9,null,2,null,null,null,null,3,4,8,6,null,null,null,7]
// [0,2,1,3,null,null,null,4,5,null,7,6,null,10,8,11,9]


