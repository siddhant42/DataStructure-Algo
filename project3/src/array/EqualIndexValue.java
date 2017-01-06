package array;

public class EqualIndexValue {
	int find(int[] a,int low,int high){
		if(low<high){
			int mid=(low+high)/2;
			if(a[mid]==mid) return mid;
			else if(a[mid]>mid) return find(a,low,mid-1);
			else return find(a,mid+1,high);
		}
		return -1;
	}
public static void main(String[] args) {
	EqualIndexValue obj=new EqualIndexValue();
	int[] a={-4,-2,2,4,6,9};
	System.out.println(obj.find(a,0,a.length-1));
}
}
