package recursion;

import java.util.Arrays;
import java.util.LinkedList;

public class TugofWar {
	int totalsum,min;
	int[] data;
	LinkedList<Integer> list;
	public static void main(String[] args) {
new TugofWar().solve();
}
	int sumArray(int[] s){
		if(s==null||s.length==0)
			return 0;
		int sum=0;
		for(int j=0;j<s.length;j++)
			sum=sum+s[j];
		return sum;
	}
	void solve(){
		int[] a={3,4,5,-3,100,1,89,54,23,20};
		int n=a.length;
		data=new int[n/2];
		totalsum=sumArray(a);
		min=Integer.MAX_VALUE;
		list=new LinkedList<Integer>();
		solveRec(0,n-1,0,n/2,a);
		if(list!=null||(!list.isEmpty())){
			for(int i:list)
				System.out.print(i+" ");
		}
	}
	void solveRec(int st,int end,int idx,int k,int[] a){
		if(idx==k){
			int minvalue=Math.abs(totalsum-2*sumArray(data));
			//System.out.println(minvalue+" "+min);
			if(min>minvalue){
				/*System.out.println(totalsum+" "+sumArray(data)+" "+minvalue);
				for(int i=0;i<data.length;i++)
					System.out.print(data[i]+" ");
				System.out.println();*/
				list.clear();
			for(int i=0;i<data.length;i++)
				list.add(data[i]);
			min=minvalue;
			}
			return;}
			for(int j=st;((j<=end)&&(j<=(end+1-k+idx)));j++){
				data[idx]=a[j];
				solveRec(j+1,end,idx+1,k,a);
			}
		}
	}
