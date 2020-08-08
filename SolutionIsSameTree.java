
public class SolutionIsSameTree {
	static boolean flag;

	public static boolean isSameTree(TreeNode p, TreeNode q) {

		flag = true;
		Boolean out = inOrderComparision(p, q);
		System.out.println(out);
		return out;
	}

	static boolean inOrderComparision(TreeNode p, TreeNode q) {

		if (flag && p == null && q == null) {
			return true;
		} else if (flag && (p != null && q != null)) {
			if (p.val == q.val) {
				flag = inOrderComparision(p.left, q.left);
				if (flag) {
					flag = inOrderComparision(p.right, q.right);
				}
				return flag;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	static boolean isSameTree2(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			flag = true;
			return flag;
		}
		if (p == null || q == null) {
			flag = false;
			return flag;
		}
		boolean out = flag && p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		System.out.println(out);
		return out;
	}

	public static void main(String[] args) {
		Object arr[] = { 10, 5, 15 };
		Tree p = new Tree();
		p.root = p.insertLevelOrder(arr, p.root, 0);

		Object arr2[] = { 10, 5, null, null, 15 };
		Tree q = new Tree();
		q.root = q.insertLevelOrder(arr2, q.root, 0);
		SolutionIsSameTree.isSameTree2(p.root, q.root);
	}

}
