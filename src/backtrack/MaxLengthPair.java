package backtrack;
class Pair{
	int x,y;

	public Pair() {
		super();
	}

	public Pair(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}
public class MaxLengthPair {
	static int findMax(Pair[] p,int n) {
		int[] lis = new int[n];
		for(int i=0;i<n;i++) lis[i] = 1;
		for(int i=1;i<n;i++) {
			for(int j=0;j<i;j++) {
				if(p[j].y<p[i].x && lis[i]<lis[j]+1)
					lis[i] = lis[j] +1;
			}
		}
		int max = Integer.MIN_VALUE;
		for(int i=0;i<n;i++) {
			if(max<lis[i]) max = lis[i];
		}
		return max;
	}
	/*static int findMax1(Pair[] p,int n) {
		
	}*/
	public static void main(String[] args) {
		int n=5;
		Pair[] obj = new Pair[n];
		obj[0] = new Pair(5,24);
		obj[1] = new Pair(39,49);
		obj[2] = new Pair(15,28);
		obj[3] = new Pair(27,40);
		obj[4] = new Pair(50,90);
		System.out.println(findMax(obj,n));
		
	}
}
