package array3;

import java.util.Arrays;

public class Unique {
	public void find(int a[],int low,int high){
		int mid;
		if(low<=high){
			mid=(low+high)/2;
			if(mid>0&&mid<a.length-1){
			if(a[mid]>a[mid-1]&&a[mid]<a[mid+1])
				System.out.println(a[mid]);
		}
			else if(mid==0&&a[mid]<a[mid+1])
				System.out.println(a[mid]);
			else if(mid==a.length-1&&a[mid]>a[mid-1])
				System.out.println(a[mid]);
			find(a,low,mid-1);
			find(a,mid+1,high);
		}
	}
public static void main(String[] args) {
	Unique u=new Unique();
	int a[]={1,2,2,4,3,3,8,3,3,3,3,3,5,21,9,9,9,9,9,9,9,9,9,9,9,6,8,8,8,8,8,8,8,8,8,8,8,8};
	Arrays.sort(a);
	u.find(a,0,a.length);
	
}

}