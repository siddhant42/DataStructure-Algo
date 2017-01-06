package linkedlist;

import linkedlist.Reverse.Node;

public class Split {
	static class Node {
		int data;
		Node next;

		public Node() {
			super();
		}
		public Node(int data) {
			super();
			this.data = data;
			next=null;
		}
	}
	public static void main(String[] args) {
		Node head=null;
		Node n1=new Node(1);
		Node n2=new Node(2);
		Node n3=new Node(3);
		Node n4=new Node(4);
		Node n5=new Node(5);
		head=n1;
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
	    n4.next=n5;
	    Split obj=new Split();
	    obj.frontbacksplit(head);
	}
	int count(Node head){
		if(head==null) return 0;
		return 1+count(head.next);
	}
	void frontbacksplit(Node head){
		if(head==null||head.next==null){
			System.out.println("can't split");
			return;
		}
		Node l1=head,l2=head,tmp;
		int i=0,k,n=count(head);
		if(n%2==0) k=n/2;
		else k=n/2+1;
		while(i<k){
			l2=l2.next;
			i++;
		}
		i=0;tmp=l1;
		while(i<k-1){
			tmp=tmp.next;
			i++;
		}
		tmp.next=null;
		printdata(l1);
		System.out.println();
		printdata(l2);
	}
	void printdata(Node head){
		if(head==null) return;
		System.out.print(head.data+" ");
		printdata(head.next);
	}
}
