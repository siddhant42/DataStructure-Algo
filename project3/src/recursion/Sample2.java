package recursion;

public class Sample2 {
public static void main(String[] args) {
	int[] a={2,3,6,7};
	int target=7;
	Sample2 obj=new Sample2();
	obj.solve(a,target);
}
void solve(int[] a,int target){
	int n=a.length;
	int sz=n*(n-1)/2;
	int[] index=new int[sz];
	//index[0]=0;
	solveRec(a,0,target,index,0);
}
void solveRec(int[] a,int sum,int target,int[] idx,int n){
	if(sum>target) return;
	if(sum==target){ 
		printdata(a,idx,n);
		return;
	}
	for(int i=idx[n];i<a.length;i++){
		idx[n+1]=i;
		//System.out.println(i+","+(n+1)+","+idx[n+1]+","+(sum+a[i])+" ");
		solveRec(a,sum+a[i],target,idx,n+1);
	}
/*	for(int i=0;i<a.length;i++){
		idx[n]=a[i];
		System.out.println(i+","+idx[n]+","+(sum+idx[n])+" ");
		solveRec(a,sum+a[i],target,idx,n+1);
	}*/
}
void printdata(int[] a,int[] idx,int m){
	for(int i=1;i<=m;i++)
		System.out.print(a[idx[i]]+" ");
	System.out.println();
}
}
