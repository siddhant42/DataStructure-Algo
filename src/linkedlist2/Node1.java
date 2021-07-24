package linkedlist2;

public class Node1 {
int data;
Node1 next;

public Node1() {
	super();
}
public Node1(int data) {
	super();
	this.data = data;
	next=null;
}
Node1 head1;
public boolean find(Node1 end){
	if(end==null) return true;
	boolean p=find(end.next);
	if(p==false) return false;
	else if(head1.data!=end.data)
	return false;
	head1=head1.next;
	return true;
}
public static void main(String[] args) {
	Node1 obj=new Node1();
	Node1 head=null;
	Node1 n1=new Node1(1);
	Node1 n2=new Node1(2);
	Node1 n3=new Node1(3);
	Node1 n4=new Node1(2);
	Node1 n5=new Node1(1);
	Node1 n6=new Node1(3);
	head=n1;
	n1.next=n2;
	n2.next=n3;
	n3.next=n6;
	n6.next=n4;
    n4.next=n5;
	obj.head1=head;
	
if(obj.find(head))
	System.out.println("pallidrome");
else
	System.out.println("not a pallindrome");
	
}
}
