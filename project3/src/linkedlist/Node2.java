package linkedlist;

public class Node2 {
int data;
Node2 next;

public Node2() {
	super();
}
public Node2(int data) {
	super();
	this.data = data;
	next=null;
}
Node2 head=null;
void merge(Node2 l1,Node2 l2){
	head=l1;
	while(l1!=null){
		while(l2.data<=l1.next.data){
			Node2 tmp=l2;
			l2=l2.next;
			tmp.next=null;
			tmp.next=l1.next;
			l1.next=tmp;
		}
		l1=l1.next;
	}
	
}
void print2(){
	if(head==null){
		System.out.println("list is empty");
		return;
	}
	while(head!=null){
		System.out.print(head.data+" ");
		head=head.next;
	}
}
void print(Node2 p){
	if(p==null){
		System.out.println("list is empty");
		return;
	}
	while(p!=null){
		System.out.print(p.data+" ");
		p=p.next;
	}
}
public static void main(String[] args) {
	Node2 obj=new Node2();
	//Node2 head2=null;
	Node2 s1=new Node2(1);
	Node2 s2=new Node2(5);
	Node2 s3=new Node2(8);
	Node2 t1=new Node2(2);
	Node2 t2=new Node2(4);
	Node2 t3=new Node2(10);
	Node2 t4=new Node2(20);
	s1.next=s2;
	s2.next=s3;
	t1.next=t2;
	t2.next=t3;
    t3.next=t4;
    //head2=s1;
obj.merge(s1,t1);
obj.print2();
}
}
