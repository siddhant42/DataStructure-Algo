package dynamic;


public class Solution {
	private int find(int n, int l, int x,int k) {
		if((k*n)<6) return -1;
		return find(x,k,k,1,1);
	}
	int find(int x,int p,int k,int st,int idx) {
		if(st>x) return 0;
		if(idx==5) return 1;
		int count = 0;
		int l = st;
		for(int i=st;i<=x;i++) {
			if(p==1)
				count += find(x,k,k,i+1,idx+1);
			else if(l<i) {
				count += find(x,k,k,i,idx+1);
				l=i;
			}
			else if(p>1)
				count += find(x,p-1,k,i,idx+1);
			
			
			
		}
		return count;
	}
	public static void main(String[] args) throws Exception {
		Solution obj = new Solution();
		int n=10,l=8,x=6,k=2;
		System.out.println(obj.find(n, l, x,k));
	}
}