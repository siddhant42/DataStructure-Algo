package dynamicprog;

public class Pallindrome2 {
public static void main(String[] args) {
	Pallindrome2 obj=new Pallindrome2();
	//char[] ch="bacdcad".toCharArray();
	char[] ch="acbcb".toCharArray();
	System.out.println(obj.maxpal(ch,0,1));
}
int l=0,max_len=0;
int max(int a,int b){
	return a>b?a:b;
}
int maxpal(char[] a,int i,int j){
	if(i<0||j==a.length||a[i]!=a[j]) return 0;
	if(i==j) return 1+maxpal(a,i-1,j+1);
	else if(a[i]==a[j]) 
		 return 2+maxpal(a,i+1,j-1);
		return max(maxpal(a,i+1,j),maxpal(a,i+1,j+1));
}
}
