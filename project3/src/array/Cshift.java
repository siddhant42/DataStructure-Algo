package array;

public class Cshift {
	int i,j,tmp;
	public void convert(int a[],int n){
		if(a.length<n){
			System.out.println("there are less no. of elements than what we have to shift");
			return;
		}
		if(a.length==n){
			for(i=0;i<a.length;i++)
				System.out.print(a[i]+"  ");
			return;
		}
			
		for(i=0,j=n;i<j;i++){
		tmp=a[i];
		a[i]=a[j];
		a[j]=tmp;
		if(j==a.length-1) j=n;
		else j++;
		}
		for(i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
		System.out.println();
	}
public static void main(String[] args) {
	int a[]={1,2,3,4,5},n=5;
	Cshift obj=new Cshift();
	obj.convert(a,n);
}
}
