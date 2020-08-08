package july_week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SolutionBuildTree {

	public TreeNode buildTree(int[] inorder, int[] postorder) {

		int pLength = postorder.length;
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 1; i < inorder.length; i++) {
			map.computeIfAbsent(inorder[i], (x -> new ArrayList<Integer>())).add(i);
		}
		for (int i = 1; i < postorder.length; i++) {
			TreeNode tempRoot = new TreeNode(postorder[i]);
		}
		System.out.println(map);
		return null;

	}

	public void recur(int[] inorder, int[] postorder, int pIndex, Map<Integer, Integer> map) {

		if (pIndex < 0)
			return;
//		if( )

		int rootIndex = map.get(postorder[pIndex]);

		for (int i = rootIndex; i < inorder.length; i++) {
			
			recur(inorder, postorder, pIndex - 1, map);
		}

	}

	public static void main(String[] args) {
		SolutionBuildTree sol = new SolutionBuildTree();
		int[] inorder = new int[] { 9, 3, 15, 20, 7 }; //left root right
		int[] postorder = new int[] { 9, 15, 7, 20, 3 }; //left right root
		sol.buildTree(inorder, postorder);
	}
	// inorder - left root right
	// postorder - left right root
	// inorder = [9,3,15,20,7] left root right
	// postorder = [9,15,7,20,3] left right root
	// 3
	// / \
	// 9 20
	// / \
	// 15 7
}
