package linkedlist;


public class S2 {
	static class Node{
		int data;
		Node next;
		
		public Node() {
			super();
		}

		public Node(int data){
			this.data=data;
			this.next=null;
		}}
	public static void main(String[] args) {
		Node head = null;
		Node head2 = null;
		head = insert(head,2);
		head = insert(head,4);
		head = insert(head,6);
		head = insert(head,8);
		head2=insert(head2,1);
		head2=insert(head2,3);
//		printNodes(head);
//		printNodes(head2);
//		Node p = new S2().mergeList(head,head2);
//		printNodes(p);
		System.out.println(new S2().GetNode(head, 1));
	}
	private static Node insert(Node head,int data){
		if(head==null){
            head= new Node();
            head.data=data;
            //head.next=null;
            return head;
        }
		Node tmp = head;
		while(tmp.next!=null)
			tmp = tmp.next;
		tmp.next = new Node();
        tmp.next.data=data;
        //tmp.next.next=null;
		return head;
	}
	private static void printNodes(Node head) {
		while(head!=null){
			System.out.print(head.data+" ");
			head = head.next;
		}
		System.out.println();
	}
	Node MergeLists(Node headA, Node headB) {
	    Node headC = null;
	    while(headA!=null && headB!=null){
	        if(headA.data<headB.data){
	            headC=insert(headC,headA.data);
	            headA=headA.next;
	        }
	        else{
	            headC=insert(headC,headB.data);
	            headB=headB.next;
	        }
	    }
	    Node p=null;
	    if(headA!=null){
	          p=headA;  
	    }
	    else if(headB!=null){
	         p=headB;
	    }
    if(headC==null) headC=p;
    else{
        Node q=headC;
        while(q.next!=null) q=q.next;
        q.next=p;
    }
	  
	    return headC;
	}
	private Node mergeList(Node a,Node b){
		if(a==null) return b;
		if(b==null) return a;
		Node c=null;
		if(a.data<b.data){
			c=new Node();
			c.data=a.data;
			c.next=mergeList(a.next,b);
		}
		else if(b.data<a.data){
			c=new Node();
			c.data=b.data;
			c.next=mergeList(a,b.next);
		}
		return c;
	}
	int GetNode(Node head,int n) {
	    int c=count(head);
	    //System.out.println(c);
	    assert(n>=0 && c>n);
	    if(c==0 || c<=n) return Integer.MIN_VALUE;
	    for(int i=0;i<c-n;i++)
	        head=head.next;
	    return head.data;
	}
	int count(Node head){
	    if(head==null) return 0;
	    return 1+count(head.next);
	}

}
