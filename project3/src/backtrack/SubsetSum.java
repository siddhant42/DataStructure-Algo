package backtrack;

import java.util.ArrayList;

public class SubsetSum {
	public static void main(String[] args) {
		long sttime=System.currentTimeMillis();
	new SubsetSum().solve();
	long endtime=System.currentTimeMillis();
	System.out.println("total time of execution= "+(endtime-sttime)+"");
}
void solve(){
	int[] a={10,6,5,18,12,20,13};
	if(solveRec(a,19,0)==false){
		System.out.println("solutio does not exits");
		return;
	}
	else{
		System.out.println("the given sum exists in the given array");
		for(int i:list)
			System.out.print(i+" ");
}	}
ArrayList<Integer> list=new ArrayList<Integer>();
int p=0;
boolean solveRec(int[] a,int sum,int st){
if(p==sum) return true;
for(int i=st;i<a.length;i++){
	if(p<sum){
		list.add(a[i]);
		p+=a[i];
		for(int j:list)
			System.out.print(j+" ");
		System.out.println(i+" "+st);
		if(solveRec(a,sum,i+1)==true)
			return true;
		else{
			list.remove((Integer)a[i]);
			p-=a[i];
	}}
}
return false;
}
}