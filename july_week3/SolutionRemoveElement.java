package july_week3;

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

public class SolutionRemoveElement {

	public ListNode removeElements(ListNode head, int val) {

		if (head == null)
			return head;
		while (head.val == val) {
			head = head.next;
			if (head == null)
				return head;
		}
		ListNode current = head;
		while (current != null) {

			while (current.next != null && current.next.val == val) {
				current.next = current.next.next != null ? current.next.next : null;
			}
			current = current.next;
		}
		head = head != null && head.val == val ? head.next : head;
		return head;
	}

	public static void main(String[] args) {
		ListNode next4 = new ListNode(3);
		ListNode next3 = new ListNode(1);
		ListNode next2 = new ListNode(2, next3);
		ListNode next1 = new ListNode(2, next2);
		ListNode head = new ListNode(1, next1);

		next1 = new ListNode(1);
		head = new ListNode(1);

		SolutionRemoveElement sol = new SolutionRemoveElement();
		sol.removeElements(head, 1);

	}

}
