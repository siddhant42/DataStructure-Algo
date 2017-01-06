package linkedlist;

public class Reverse {
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
    Reverse obj=new Reverse();
    obj.reverse(head);
    obj.printdata(obj.p);
}
Node p=null;
void reverse(Node head){
	if(head==null) return;
	//if(head.next==null) return head;
	Node rev=head.next;
	head.next=p;
	p=head;
	 reverse(rev);
	 
	
}

void printdata(Node head){
	while(head!=null){
		System.out.print(head.data+" ");
		head=head.next;
	}
}
}
