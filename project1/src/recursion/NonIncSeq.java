package recursion;

public class NonIncSeq {
	public static void main(String[] args) {
		int n=6;
		int[] data = new int[n];
		new NonIncSeq().find(0,0,n,data);
	}

	private void find(int idx,int sum,int n,int[] data) {
		int i;
		if(sum>n) return;
		if(sum==n){
			i=0;
			while(i<data.length && sum>0){
				System.out.print(data[i]+" ");
				sum-=data[i];
				i++;
			}
			System.out.println();
			return;
		}
		for(i=1;(i<=n)&&(sum+i<=n);i++){
			if(idx==0 || (idx>0 && i<=data[idx-1])){
				data[idx]=i;
				find(idx+1,sum+i,n,data);
			}
			
		}
	}
}
