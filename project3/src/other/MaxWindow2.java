package other;
import java.util.LinkedList;
import java.util.TreeSet;

public class MaxWindow2 {
public static void main(String[] args) {
	int[] a={6,12,4,3,10,2,1};
	new MaxWindow2().find(a,15);
}
void find(int[] a,int w){
	assert w<a.length;
	int i;
	LinkedList<Integer> l=new LinkedList<Integer>();
TreeSet<Integer> s=new TreeSet<Integer>();
for(i=0;i<w-1;i++)
	l.add(a[i]);
for(i=w-1;i<a.length;i++){
	l.add(a[i]);
	s.addAll(l);
	System.out.print(s.last()+" ");
	s.remove(l.pollFirst());
}
}

}

