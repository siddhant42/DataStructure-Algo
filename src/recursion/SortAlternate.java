package recursion;

public class SortAlternate {
	void find(int[] a,int[] b,int[] data,int m,int n,int i,int j,int idx,boolean flag){
		if(a==null||b==null||(m==0&&n==0)) return;
		if(flag){
			if(idx>0){
			for(int p=0;p<idx;p++){
				System.out.print(data[p]+" ");
			}
				System.out.println();
			}
				
			for(int k=i;k<m;k++){
				if(idx==0 || a[k]>data[idx-1]){
					data[idx]=a[k];
					find(a,b,data,m,n,k+1,j,idx+1,!flag);
				}
				
			}
		}
		else {
			for(int l=j;l<n;l++){
				if( b[l]>data[idx-1]) {
					data[idx]=b[l];
					find(a,b,data,m,n,i,l+1,idx+1,!flag);
				}
				
			}
		}
	}
	public static void main(String[] args) {
		int[] a = {10, 15, 25};
		int[] b = {1, 5, 20, 30};
		int[] data = new int[a.length+b.length];
		//List<Integer> data = new ArrayList<Integer>();
		new SortAlternate().find(a,b,data,a.length,b.length,0,0,0,true);
	}
}
