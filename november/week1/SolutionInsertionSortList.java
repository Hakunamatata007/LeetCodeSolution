package november.week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionInsertionSortList {

	public ListNode insertionSortList(ListNode head) {
		List<Integer> list = new ArrayList<>();
		while (head != null) {
			list.add(head.val);
			head = head.next;
		}
		head = null;
		Integer[] arr = insertionSortList(list.toArray(new Integer[list.size()]));
		for (int integer : arr) {
			ListNode newNode = new ListNode(integer);
			if (head == null)
				head = newNode;
			else {
				ListNode temp = head;
				while (temp != null && temp.next != null)
					temp = temp.next;
				temp.next = newNode;
			}
		}
		return head;
	}

	public Integer[] insertionSortList(Integer[] head) {

		for (int i = 1; i < head.length; i++) {

			int key = head[i];
			int j = i - 1;
			while (j >= 0 && key < head[j]) {
				head[j + 1] = head[j];
				j--;
			}
			head[j + 1] = key;
		}
		return head;
	}

	public static void main(String[] args) {
		SolutionInsertionSortList sol = new SolutionInsertionSortList();
		System.out.println(Arrays.toString(sol.insertionSortList(new Integer[] { 4, 2, 1, 3 })));
	}

}
