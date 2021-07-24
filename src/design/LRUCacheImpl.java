package design;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LRUCacheImpl {
	static class Node{
		private Object key;
		private Object value;
		Node prev;
		Node next;
		public Node(Object key,Object value) {
			this.key = key;
			this.value = value;
			next=prev=null;
		}
		
	}
	public LRUCacheImpl(int capacity) {
		this.capacity = capacity;
	}
	private final Map<Object,Node> map = new HashMap<>();
	private final int capacity;
	private Node head = null;
	private Node end = null;
	public Object get(Object key) {
		Node node = map.get(key);
		if(node==null) return node;
		removeNode(node);
		setHead(node);
		return node.value;
	}
	private void setHead(Node node) {
		node.next=head;
		if(head!=null) head.prev = node;
		head = node;
		if(end==null) end = head;		
	}
	private void removeNode(Node node) {
		if(node.prev!=null)
			node.prev.next = node.next;
		else head = node.next;
		
		if(node.next!=null)
			node.next.prev = node.prev;
		else end = node.prev;
		
	}
	public void set(Object key,Object value){
		final Node created = new Node(key,value);
		if(map.get(key)!=null) {
			Node old = map.get(key);
			old.value = value;
			removeNode(old);
			setHead(old);
			return;
		}
		if(map.size()>=capacity){
			map.remove(end.key);
			removeNode(end);
		}
		setHead(created);
		map.put(key, created);
	}
	public void printHeadEndSize(){
		if(head!=null)
		System.out.println("head is "+head.value);
		if(end!=null)
		System.out.println("end is "+end.value);
		System.out.println("size is "+map.size());
	}
/*	private void setEnd(Node node) {
		node.prev=end;
		if(end!=null) end.next = node;
		end = node;
		if(head==null) head=node;
	}*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LRUCacheImpl obj = new LRUCacheImpl(2);
		while(true) {
			System.out.println("please enter your choice-get,set,print or exit");
			String str = sc.next();
			if(str.equals("print")) obj.printHeadEndSize();
			else if(str.equals("get")) {
				String key = sc.next();
				String s =(String) obj.get(key);
				System.out.println(s);
			}
			else if(str.equals("set")){
				String key = sc.next();
				String value = sc.next();
				obj.set(key, value);
				System.out.println("key & value is set successfully");
			}
			else break;
		}
	}
	
}
