package august.week2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SolutionPathSum3 {

	public int pathSum(TreeNode root, int sum) {

		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		return countPath(root, sum, 0, map);

	}

	private int countPath(TreeNode root, int target, int prefixSum, Map<Integer, Integer> map) {

		if (root == null || root.val == null) {
			return 0;
		}
		prefixSum += (Integer) root.val;
		int count = map.getOrDefault(prefixSum - target, 0);
		map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
		count += countPath(root.left, target, prefixSum, map) + countPath(root.right, target, prefixSum, map);
		map.put(prefixSum, map.get(prefixSum) - 1);
		return count;
	}

	public static void main(String[] args) {
		SolutionPathSum3 sol = new SolutionPathSum3();
		Tree tree = new Tree();
		Object[] arr = new Object[] { 8, 5, -3, 3, 3 };
		tree.root = tree.insertLevelOrder(arr, tree.root, 0);
		sol.pathSum(tree.root, 8);

	}

}
// [0,5,1,9,null,2,null,null,null,null,3,4,8,6,null,null,null,7]
// [0,2,1,3,null,null,null,4,5,null,7,6,null,10,8,11,9]
