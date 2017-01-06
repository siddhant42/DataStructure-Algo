package dynamic;


public class MinJumps {
	static int findMin(int[] a,int st,int n) {
		if(st>=n) return 0;
		if(a[st]==0) return Integer.MAX_VALUE;
		int min = Integer.MAX_VALUE;
		int j = 1;
		while(j<=a[st]) {
			min = Math.min(min,1+ findMin(a,st+j,n));
			j++;
		}
		return min;
	}
	static int minJumps2(int a[], int n){
			if(a==null||a.length==0) return -1;
			int lastVisited=0,i=0,steps=0;
			while(i<n && lastVisited<n) {
				boolean b = true;
				int j=i,l=lastVisited;
				while(i<=l) {
					if(lastVisited<i+a[i])
						lastVisited=i+a[i];
					if(b) {
						steps++;
						b=false;
					}
					i++;
				}
				if(j==i) return -1;
			}
			return steps;
		}
	static int findMinDyn(int[] a,int n) {
		if(a==null||a.length==0) return -1;
		else if(n==0) return 0;
		int[][] s = new int[n+1][n+1];
		for(int i=n;i>=0;i--) {
			for(int j=i;j<=n;j++) {
				if(i==j) s[i][j] = 0;
				else if(j-i<=a[i]) s[i][j] = 1;
				else {
					int min = Integer.MAX_VALUE;
					for(int k=1;k<=a[i];k++) {
						int p = s[i+k][j];
						if(p!=0 && min>p)
							min = p;
					}
					if(min!=Integer.MAX_VALUE) {
						s[i][j] = min+1;
					}
				}
			}
		}
		if(s[0][n]!=0) return s[0][n];
		else return -1;
	}
	public static void main(String[] args) {
		int[] a = {1,3,5,8,9,2,6,7,6,8,9};
		//int[] a ={1,3,2,0,0,7};
		//System.out.println(findMin(a,0,a.length-1));
		//System.out.println(findMinDyn(a,a.length-1));
		System.out.println(minJumps2(a,a.length));
	
	}
}
