package dynamicprog;

public class Pallindrome {
public static void main(String[] args) {
	char[] str="bbabcbcab".toCharArray();
	Pallindrome obj=new Pallindrome();
	//System.out.println(obj.ispalRec(str,0,str.length-1));
	System.out.println(obj.ispaldp(str));
}
int max(int a,int b){
	return a>b?a:b;
}
int ispalRec(char[] a,int i,int j){
	if(i==j) return 1;
	if(j==i+1&&a[i]==a[j]) return 2;
	if(a[i]==a[j])
		return ispalRec(a,i+1,j-1)+2;
	else
		return max(ispalRec(a,i+1,j),ispalRec(a,i,j-1));
}
int ispaldp(char[] a){
	int n=a.length;
	int[][] s=new int[n][n];
	for(int k=0;k<n;k++)
		s[k][k]=1;
	for(int i=n-2;i>=0;i--){
		for(int j=i+1;j<n;j++){
			if(j==i+1&&a[j]==a[i])
				s[i][j]=2;
			else if(a[i]==a[j])
				s[i][j]=2+s[i+1][j-1];
			else 
				s[i][j]=max(s[i+1][j],s[i][j-1]);
			
		}
		
	}
	return s[0][n-1];
}
}
