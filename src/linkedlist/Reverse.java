package linkedlist;

public class Reverse {
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
		head = insert(head,6);
		head = insert(head,7);
		head = insert(head,8);
		//head = insert(head,9);
		printNodes(head);
		System.out.println();
		Node rNode=new Reverse().reverseNodes(head, 3);
		printNodes(rNode);
	}
	private Node reverseNodes(Node head,int k) {
		if(head==null||head.next==null)
			return head;
		int p = k;
		Node p1=head,p2=head.next,p3=null;
		if(p2!=null) p3=p2.next;
		while(p>1 && p2!=null){
			p2.next=p1;
			p1=p2;
			p2=p3;
			if(p3!=null)
				p3=p3.next;
			p--;
		}
		head.next =  reverseNodes(p2,k);
		return p1;
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
