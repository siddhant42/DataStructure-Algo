package linkedlist;

import linkedlist.Reverse.Node;

public class S3 {

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
//		head = insert(head,8);
//		head = insert(head,9);
		printNodes(head);
		System.out.println();
		//Node rNode=new S3().reverseNodes(head, 3);
		Node rNode = new S3().reverseSingle(head);
		printNodes(rNode);
	}
	private Node reverseNodes(Node head,int k) {
		if(head==null) return null;
		Node prev=null,p2=head,p3=null;
		if(p2!=null) p3=p2.next;
		p2.next=prev;
		for(int i=0;i<k-1;i++){
			if(p3==null) return p2;
			prev=p2;p2=p3;p3=p3.next;
			p2.next=prev;
		}
		head.next=reverseNodes(p3,k);
		return p2;
	}
	private Node reverseSingle(Node head){
		if(head==null||head.next==null) return head;
//		Node p2=head,p3;
//		head=head.next;
//		p2.next=prev;
//		prev=p2;
//		//return reverseSingle(head,prev);
		Node tmp = reverseSingle(head.next);
//		Node p = tmp;
//		while(p.next!=null) p=p.next;
//		p.next = head;
		head.next.next=head;
		head.next = null;
		return tmp;
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
