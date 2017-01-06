package backtrack;

public class SubsetSum {
	static int count=0;
	public static void main(String[] args) {
		int[] a={10,7,5,18,12,20,15};
		int target=35;
		int[] set=new int[a.length];
		new SubsetSum().findSubset(a,0,0,0,target,set);
		System.out.println(count);
	}

	private void findSubset(int[] a, int st, int idx, int sum, int target, int[] set) {
		
		if(sum>target) return;
		count++;
		if(sum==target){
			print(set);
			System.out.println();
			//findSubset(a,st+1,idx-1,sum-set[st],target,set);
			return;
		}
		else{
		for(int i=st;i<a.length;i++){
			set[idx]=a[i];
			findSubset(a,i+1,idx+1,sum+a[i],target,set);
			set[idx]=0;
		}}
	}

	private void print(int[] set) {
		for(int i:set){
			if(i!=0)
				System.out.print(i+" ");
		}
		
	}
}
