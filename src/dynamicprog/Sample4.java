package dynamicprog;

public class Sample4 {
	//int min=Integer.MAX_VALUE;
	int max(int a,int b){
		return a>b?a:b;
	}
	int eggdrop(int n,int k){
	if(k==1||k==0) return k;
	if(n==1) return k;
	int x,res,min=Integer.MAX_VALUE;
	for(x=1;x<=k;x++){
		res=max(eggdrop(n-1,x-1),eggdrop(n,k-x));
		if(min>res)
			min=res;
	}
	return min+1;
	}
public static void main(String[] args) {
	//int n=2,k=100;
	System.out.println(new Sample4().eggdrop(2,100));
}
}
