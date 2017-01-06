package backtrack;
public class TugOfWar {
	int min = Integer.MAX_VALUE,halfSum;
	public static void main(String[] args) {
		int[] a={23, 45, -34, 12, 0, 98, -99, 4, 189, -1, 4};
		int[] set = new int[a.length];
		int[] p = new int[a.length/2];
		int sum=0;
		for(int i:a)
			sum+=i;
		sum=sum/2;
		TugOfWar obj = new TugOfWar();
		obj.find(a,sum,0,0,0,set,p);
		System.out.println(obj.min);
		System.out.println(obj.halfSum);
		for(int i:p)
		System.out.print(i+" ");
	}
	private void find(int[] a, int sum, int currSum, int idx, int st,int[] set,int[] p) {
		if(idx>a.length/2) return;
		if(idx==a.length/2) {
			int diff = Math.abs(sum-currSum);
			if(min>diff){
				min=diff;
			halfSum=currSum;
			//list = Arrays.asList(set);
			for(int i=0;i<p.length;i++){
				p[i]=set[i];
			}
			}
		}
		else {
			for(int i=st;i<a.length;i++) {
				set[idx] = a[i];
				find(a,sum,currSum+a[i],idx+1,i+1,set,p);
				set[idx]=0;
			}
		}
	}
}
