package bitmagic;

public class SetBit {
public static void main(String[] args) {
	int n=64;
	System.out.println(find(n));
}
static int find(int n){
	if(n==0) return 0;
	int cnt=0;
	while(n>0){
		if((n&1)!=0) cnt++;
		n=n>>1;
	}
	return cnt;
}
}
