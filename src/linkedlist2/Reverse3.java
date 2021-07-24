package linkedlist2;

public class Reverse3 {
	static class Node {
		int data;
		Node next;
		public Node(int data) {
			super();
			this.data = data;
		}
	}
	public void printList(Node head) {
		while(head!=null) {
			System.out.print(head.data+" ");
			head = head.next;
		}
	}
	public Node reverse(Node head) {
		if(head == null || head.next==null) {
			return head;
		}
		Node tmp = head.next;
		Node p = reverse(head.next);
		tmp.next = head;
		head.next = null;
		return p;
	}
	public static void main(String[] args) {
		Reverse3 obj = new Reverse3();
		Node head = new Node(1);
		head.next  = new Node(2);
		head.next.next  = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		obj.printList(head);
		System.out.println();
		Node p = obj.reverse(head);
		obj.printList(p);
	}
}
