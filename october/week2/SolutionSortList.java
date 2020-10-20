package october.week2;

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

public class SolutionSortList {

	public ListNode sortList(ListNode head) {

		if (head == null || head.next == null)
			return head;
		ListNode mid = getMid(head);
		ListNode nextMiddle = mid.next;
		mid.next = null;
		ListNode left = sortList(head);
		ListNode right = sortList(nextMiddle);
		ListNode sorted = merge(left, right);
		return sorted;
	}

	public ListNode merge(ListNode l1, ListNode l2) {

		ListNode head = new ListNode();
		ListNode tail = head;
		while (l1 != null && l2 != null) {
			if (l2.val > l1.val) {
				tail.next = l1;
				l1 = l1.next;
				tail = tail.next;
			} else {
				tail.next = l2;
				l2 = l2.next;
				tail = tail.next;
			}
		}
		tail.next = l1 == null ? l2 : l1;
		return head.next;
	}

	public ListNode getMid(ListNode list) {

		if (list == null)
			return list;
		ListNode fast = list, slow = list;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}

	public static void main(String[] args) {
		SolutionSortList sol = new SolutionSortList();
		ListNode head = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
		sol.sortList(head);

	}

}
