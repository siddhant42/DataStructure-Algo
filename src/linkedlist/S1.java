package linkedlist;

public class S1 {

	static class Node{
		int data;
		Node next;
		public Node(int data){
			this.data=data;
			this.next=null;
		}
	}
	public static void main(String[] args) {
		S1 obj = new S1();
		obj.head = new Node(1);
		obj.head = insert(obj.head,2);
		obj.head = insert(obj.head,3);
		obj.head = insert(obj.head,4);
		obj.head = insert(obj.head,5);
		obj.head = insert(obj.head,6);
		printNodes(obj.head);
		obj.p=obj.head;
		obj.convert(obj.head);
		printNodes(obj.head);

	}
	private boolean convert(Node end) {
		if(end==null) return false;
		Node r=null;
		if(convert(end.next)) return true;
		if(p==end||p.next==end){
			end.next=null;
			return true;
		}
			
		r=p.next;
		p.next=end;
		end.next=r;
		p=r;
		return false;
	}
	Node head;
	Node p;
	
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
		System.out.println();
	}

}
