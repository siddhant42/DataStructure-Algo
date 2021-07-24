package backtrack2;

public class FillTwo2 {
public static void main(String[] args) {
	new FillTwo2().solve();
}

void solve(){
	int n=7;
	int[] data=new int[2*n];
	if(solveRec(data,n,n)==false){
		System.out.println("not possibe");
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
boolean solveRec(int[] data,int n,int curr){
	if(curr==0) return true;
	for(int i=0;i+curr+1<2*n;i++){
		if(data[i]==0 &&data[i+curr+1]==0){
			data[i]=data[i+curr+1]=curr;
			if(solveRec(data,n,curr-1)==true) return true;
			data[i]=data[i+curr+1]=0;
		}
	}
	
	return false;
}
}
