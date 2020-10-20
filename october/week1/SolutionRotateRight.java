package october.week1;

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

public class SolutionRotateRight {
	public ListNode rotateRight(ListNode head, int k) {

		ListNode temp = head;
		int length = 0;
		while (temp != null) {
			temp = temp.next;
			length++;
		}
		k %= length;
		System.out.println(k);
		if (length == 0 || length == 1 || k == 0)
			return head;
		int remainingLength = length - k; // 3

		// Input: 1->2->3->NULL, k = 1
		// Output: 3->1->2->NULL
		ListNode temp2 = head;
		for (int i = 0; i < remainingLength - 1; i++) {
			temp2 = temp2.next; // temp2 = 2->3->null
		}
		temp = temp2.next; // temp = 3->null
		temp2.next = null; // head = 1->2->null
		temp2 = temp;
		while (temp != null) {
			if (temp.next == null) {
				temp.next = head;
				break;
			}
			temp = temp.next;
		}
		return temp2;
	}

	public static void main(String[] args) {
		SolutionRotateRight sol = new SolutionRotateRight();
		// ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new
		// ListNode(4, new ListNode(5)))));
		ListNode head = new ListNode(1, new ListNode(2));
		sol.rotateRight(head, 2);
	}

}
