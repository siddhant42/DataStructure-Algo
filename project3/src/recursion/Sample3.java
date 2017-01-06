package recursion;

public class Sample3 {
public static void main(String[] args) {
	int[] a={6,2,7,3};
	//int[] a={5,9,1,3,4,2,6,7,11,10};
	int target=7;
	Sample3 obj=new Sample3();
	obj.solve(a,target);
}
void solve(int[] a,int target){
	int n=a.length;
	int sz=n*(n-1)/2;
	int[] index=new int[sz];
	//index[0]=0;
	solveRec(a,0,target,index,0,0);
}
void solveRec(int[] a,int sum,int target,int[] idx,int n,int index){
	if(sum>target) return;
	if(sum==target){ 
		printdata(idx,index);
		return;
	}
	for(int i=n;i<a.length;i++){
		idx[index]=a[i];
		//System.out.println(i+","+(n+1)+","+idx[n+1]+","+(sum+a[i])+" ");
		//System.out.print(i+","+(sum+a[i])+" ");
		solveRec(a,sum+a[i],target,idx,n+1,index+1);
	}
}
void printdata(int[] idx,int m){
	for(int i=0;i<m;i++)
		System.out.print(idx[i]+" ");
	System.out.println();
}
}
