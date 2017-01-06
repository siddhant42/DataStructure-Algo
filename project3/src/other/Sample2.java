package other;

public class Sample2{
	public void print(int[] a,int low,int high){
		int mid;
		if(low!=high){
			mid=(high+low)/2;
			System.out.print(a[mid]+" ");
			print(a,low,mid);
			//System.out.print(a[mid]+" ");
			print(a,mid+1,high);
		}
		
	}
public static void main(String[] args) {
	//Sample1 s=new Sample1();
int a[]={1,3,7,9,12,15,18,25};
new Sample2().print(a,0,a.length);
}
}
