package array;

public class Sample2 {
	int find(int[][] a){
		int max=0,cnt,i;
		for(i=0;i<a.length;i++){
			cnt=findmax1(a[i],0,a[i].length-1,a[i].length);
			System.out.println(cnt);
			if(max<cnt) max=cnt;
		}
		return max;
	}
	int findmax1(int[] a,int low,int high,int max){
/*		while(low<=high){
			int mid=(low+high)/2;
			if(a[mid]==1&&a[mid-1]==0){
				//System.out.println(a.length);
				max= a.length-mid;}
			else if(a[mid]==0)
				high=mid-1;
			else
				low=mid+1;
		}
		return max;*/
		if(low<high){
			int mid=(low+high)/2;
			if(a[mid]==1&&a[mid-1]==0)
				return a.length-mid;
			else if(a[mid]==0)
				max= findmax1(a,low,mid-1,max);
			else
				max= findmax1(a,mid+1,high,max);
		}
		return max;
	}
public static void main(String[] args) {
	Sample2 obj=new Sample2();
	int a[][]={{0,0,0,1,1},{0,0,0,0,0},{0,1,1,1,1},{0,0,0,0,1}};
	System.out.println(obj.find(a));
}
}
