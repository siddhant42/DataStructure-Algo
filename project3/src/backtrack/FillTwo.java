package backtrack;

public class FillTwo {
public static void main(String[] args) {
	new FillTwo().solve();
}

void solve(){
	int n=3,k=0;
	int[] data=new int[2*n];
	if(solveRec(data,n,k)==false){
		System.out.println("solution does not exists");
		return;
	}
	printdata(data);
	/*int[] data={1,2,3};
	System.out.println(isSafe(3,data));*/
}
void printdata(int[] data){
	if(data==null||data.length==0){
		System.out.println("array is empty");
		return;
	}
	for(int j=0;j<data.length;j++)
		System.out.print(data[j]+" ");
	System.out.println();
}
boolean isSafe(int x,int[] data){
	if(data==null||data.length==0) return true;
	int i,cnt=0,p;
	for(i=0;i<data.length;i++){
		if(data[i]==x) cnt++;
	}
	if(cnt==0) return true;
	else if(cnt==1){
		p=data.length-1-x;
		if(p>=0 && data[p]==x)
			return true;
	}
	
	return false;
}
boolean solveRec(int[] data,int n,int k){
	if(k==2*n) return true;
	for(int i=1;i<=n;i++){
		if(isSafe(i,data)){
			data[k]=i;
			printdata(data);
			if(solveRec(data,n,k+1)==true) return true;
			else data[k]=0;
		}
	}
	return false;
}
}
