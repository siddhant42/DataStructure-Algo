package recursion;

public class Sample5 {
public static void main(String[] args) {
	new Sample5().solve();
}
void solve(){
	int n=5,k=3;
	int[] data=new int[k];
	solveRec(1,0,n,k,data);
}
void solveRec(int st,int idx,int n,int k,int[] data){
	if(k>n) return;
	if(idx==k){
		for(int i=0;i<k;i++)
			System.out.print(data[i]+" ");
		System.out.println();
		return;
	}
	for(int j=st;((j<=n)&&(j<=(n+1-k+idx)));j++){
		data[idx]=j;
		solveRec(j+1,idx+1,n,k,data);
	}
}
}
