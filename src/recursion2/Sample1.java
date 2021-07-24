package recursion2;

public class Sample1 {
public static void main(String[] args) {
	int n=5,k=3,st=1,idx=0;
	int[] a=new int[k];
	new Sample1().printRec(a,st,idx,n,k);
}
void printRec(int[] a,int st,int idx,int n,int k){
	if(k<=0||k>n||n<=0){
		System.out.println("can't determine sequence");
		System.out.println("please put valid input details");
		return;
	}
	if(idx==k){
		for(int i=0;i<k;i++)
			System.out.print(a[i]+" ");
		System.out.println();
	}
	else{
		for(int j=st;j<=n+1-k+idx;j++){
			a[idx]=j;
			printRec(a,j+1,idx+1,n,k);
		}
	}
}
}
