package collection;

import java.util.Stack;

public class ListSum {
	static class Node{
		int data;
		Node next;
		public Node(){}
		public Node(int data){
			this.data=data;
			this.next=null;
		}
		public void add(Integer n){
			Node tmp=this;
			while(tmp.next!=null)
				tmp=tmp.next;
			tmp.next=new Node(n);
		}
	}
	public static void main(String[] args) {
		Node p1,p2,p3;
		p1 = new Node(9);
		p1.next = new Node(2);
		p1.next.next = new Node(3);
		p2 = new Node(4);
		p2.next = new Node(6);
		p3 = new Node(2);
		p3.next = new Node(5);
		p3.next.next = new Node(1);

		ListSum obj = new ListSum();
		Node p4 = obj.calculate(p1,p2,p3);
		obj.printList(p4);
	}
	private void printList(Node p4) {
		if(p4 == null) return;
		while(p4 != null) {
			System.out.print(p4.data);
			p4=p4.next;
		}

	}
	private Node calculate(Node p1, Node p2, Node p3) {
		Node p4 = new Node();
		Stack<Integer> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();
		Stack<Integer> s3 = new Stack<>();
		Stack<Integer> s4 = new Stack<>();
		int sum=0,carry=0,sum1=0,carryPrev=0;
		while(p1!=null){
			s1.push(p1.data); p1=p1.next;
		}
		while(p2!=null){
			s2.push(p2.data); p2=p2.next;
		}
		while(p3!=null){
			s3.push(p3.data); p3=p3.next;
		}
		while(s1.empty()==false || s2.empty()==false || s3.empty()==false){
			sum=0;carry=0;
			if(s1.empty()==false) sum+=s1.pop();
			if(s2.empty()==false) sum+=s2.pop();
			if(s3.empty()==false) sum+=s3.pop();
			if(sum>=20){
				sum-=20; carry=2;
			}
			else if(sum>=10){
				sum-=10; carry=1;
			}
			else carry=0;
			sum1 = sum+carryPrev;
			if(sum1>10){
				sum1-=10; carry++;
			}
			s4.push(sum1);
			carryPrev = carry;
		}
		if(carry>0)
			s4.push(carry);
		if(s4.empty()==false)
			p4.data=s4.pop();
		while(s4.empty()==false)
			p4.add(s4.pop());
		return p4;
		
	}


}
