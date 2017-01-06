package recursion;

import java.util.ArrayList;
import java.util.List;

public class Sample4 {
	int[] a={2,6,2,7,3};
	int target=7;
	List<Integer> list=new ArrayList<Integer>();
	void findsubset(int index,int sum){
		if(sum==target) System.out.println(list);
		else{
			for(int i=index;i<a.length;i++){
				sum+=a[i];
				if(sum>target){
					sum-=a[i];
					break;
				}
				list.add(a[i]);
				findsubset(i+1,sum);
				sum-=a[i];
				list.remove(a[i]);
			}
		}
	}
	public static void main(String[] args) {
		new Sample4().findsubset(0,0);
	}
}
