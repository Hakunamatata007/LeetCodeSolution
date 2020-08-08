
class Node {
	public int val;
	public Node prev;
	public Node next;
	public Node child;
}

public class SolutionFlatten {

	static Node flatten(Node head) {

		Node temp = head;
		connectChild(temp);
		return head;
	}

	static void connectChild(Node temp) {

		if (temp == null)
			return;

		if (temp.child == null) {
			connectChild(temp.next);
			return;
		}
		Node child = temp.child;
		Node temp2 = temp.next;
		// connect child to temp
		temp.next = child;
		child.prev = temp;
		temp.child = null;
		connectChild(temp.next);
		while (temp.next != null) {
			temp = temp.next;
		}
		if (temp2 != null) {
			temp.next = temp2;
			temp2.prev = temp;
		}
	}

	public static void main(String[] args) {
		Node head = null;

		Node node1 = new Node();
		node1.val = 1;
		Node node2 = new Node();
		node2.val = 2;
		// Node node3 = new Node();
		// node3.val = 3;

		head = node1;
		// node1.next = node2;
		// node2.prev = node1;
		// node2.next = node3;
		// node3.prev = node2;

		// Node node4 = new Node();
		// node4.val = 4;
		// Node node5 = new Node();
		// node5.val = 5;

		node1.child = node2;
		// node4.next = node5;
		// node5.prev = node4;

		head = SolutionFlatten.flatten(head);

		Node listNode = head;
		while (listNode != null) {
			System.out.print(listNode.val + ", ");
			listNode = listNode.next;
		}

	}

}
