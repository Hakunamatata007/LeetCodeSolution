package november.week1;

import java.util.ArrayList;
import java.util.List;

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

public class SolutionBinaryToDecimalLinkedList {

	public int getDecimalValue(ListNode head) {

		List<Integer> list = new ArrayList<>();
		while (head != null) {
			list.add(head.val);
			head = head.next;
		}
		return getDecimalValue(list.toArray(new Integer[list.size()]));
	}

	public int getDecimalValue(Integer[] head) {

		int pow = 0;
		int start = head.length - 1;
		int result = 0;
		while (pow < head.length) {
			result += head[start--] * (Math.pow(2, pow++));
		}
		return result;
	}

	public static void main(String[] args) {
		SolutionBinaryToDecimalLinkedList sol = new SolutionBinaryToDecimalLinkedList();
		System.out.println(sol.getDecimalValue(new Integer[] { 1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0 }));

	}

}
