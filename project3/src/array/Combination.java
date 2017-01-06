package array;

public class Combination {
public static void main(String[] args) {
	int arr[]={1,2,3,4};
	int r=3;
	//int[] used=new int[r];
	//printrec(a,)
	new Combination().printcomb(arr,r);
}
void printcomb(int[] a,int r){
	int[] used=new int[r];
	printrec(a,0,a.length-1,0,r,used);
}
void printrec(int[] a,int st,int end,int idx,int r,int[] used){
	if(idx==r){
		for(int i=0;i<r;i++)
			System.out.print(used[i]+" ");
		System.out.println();
	}
	else{
		for(int j=st;j<=end&&j<=end+1-r+idx;j++){
			used[idx]=a[j];
			printrec(a,j+1,end,idx+1,r,used);
		}
	}
}
}
