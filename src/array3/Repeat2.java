package array3;

public class Repeat2 {
	int i;
	//public int a[] = {1,2,2,1};
	//int n=a.length-2,i;
	public void findRepeat(int a[],int n){
		//System.out.println(n);
		if(n<2){
			System.out.println("there are less no. of elements");
			return;
		}
		else if(n==2){
		System.out.println("1"+" "+"2");
		return;
		}
		else{
			for(i=0;i<a.length;i++){
				if(a[Math.abs(a[i])]>0)
					a[Math.abs(a[i])]=-a[Math.abs(a[i])];
				else
					System.out.println(Math.abs(a[i]));
			}
			for(i=0;i<a.length;i++)
				a[i]=Math.abs(a[i]);
		}}
	public static void main(String[] args) {
		int a[] = {1,2,2,1,3};
		 int n=a.length-2;	

	Repeat2 obj=new Repeat2();
	obj.findRepeat(a,n);
}	}
