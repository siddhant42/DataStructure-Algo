package linkedlist;

public class Palindrome {
	static class Node{
		int data;
		Node next;
		public Node(int data){
			this.data=data;
			this.next=null;
		}
	}
	public static void main(String[] args) {
		Node head = new Node(1);
		head = insert(head,2);
		head = insert(head,3);
		head = insert(head,4);
		head = insert(head,5);
		//head = insert(head,4);
		head = insert(head,3);
		head = insert(head,2);
		head = insert(head,1);
		printNodes(head);
		System.out.println(new Palindrome().isPalRec(head));

	}
	Node p=null;
	private boolean isPalRec(Node head) {
		p=head;
		return isPal(p,head);
	}
	private boolean isPal(Node head,Node end) {
		if(end==null) return true;
		if(isPal(head,end.next) == false)
			return false;
		if(p.data!=end.data) 
			return false;
		else
			p=p.next;
		return true;
	}
	private static Node insert(Node head,int data){
		Node tmp = head;
		while(tmp.next!=null)
			tmp = tmp.next;
		tmp.next = new Node(data);
		return head;
	}
	private static void printNodes(Node head) {
		while(head!=null){
			System.out.print(head.data+" ");
			head = head.next;
		}
	}

}
