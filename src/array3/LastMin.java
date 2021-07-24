package array3;

public class LastMin {
	public static void print(int[] a){
		if(a==null||a.length==0){
			System.out.println("array is empty");
			return;
		}
		int i,min=a[a.length-1];
		for(i=a.length-2;i>=0;i--){
			if(min>a[i]) min=a[i];
			else a[i]=min;
		}
		for(i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
	}
public static void main(String[] args) {
	int[] a={5,4,15,8,12,21};
	print(a);
}
}
