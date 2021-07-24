package linkedlist2;

import linkedlist2.Reverse2.Node;

public class Reverse2 {
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
Node reverse(Node head,int k){
	Node start,prev=null,end=head;
	int p=k;
	if(end==null) return null;
	while(p>0 && end!=null){
		start=end;
		end=end.next;
		start.next=prev;
		prev=start;
		p--;
	}
	head.next=reverse(end,k);
	return prev;
}
Node swap(Node head){
	if(head==null) return null;
	Node prev=head,start=prev.next,end=null;
	if(start!=null) end=start.next;
	if(start!=null)
		start.next=prev;
	else return prev;
	prev=start;
	head.next=swap(end);
	return prev;
	
}
public static void main(String[] args) {
Node head=new Node(1);
head.next=new Node(2);
head.next.next=new Node(3);
head.next.next.next=new Node(4);
head.next.next.next.next=new Node(5);
head.next.next.next.next.next=new Node(6);
head.next.next.next.next.next.next=new Node(7);
//head.next.next.next.next.next.next.next=new Node(8);
    Reverse2 obj=new Reverse2();
    //Node p=obj.reverse(head,3);
    Node p=obj.swap(head);
    obj.printdata(p);
}
void printdata(Node head){
	while(head!=null){
		System.out.print(head.data+" ");
		head=head.next;
	}
}
}
