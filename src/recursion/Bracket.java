package recursion;

public class Bracket {
	public static void main(String[] args) {
		int n=3;
		char[] s=new char[2*n];
		new Bracket().print(0,0,0,n,s);
	}

	private void print(int i, int open, int close, int n, char[] s) {
		if(i==2*n){
			for(int j=0;j<s.length;j++){
				System.out.print(s[j]);
			}
			System.out.println();
			return;
		}
		if(open>close){
			s[i]='}';
			print(i+1,open,close+1,n,s);
		}
		if(open<n){
			s[i]='{';
			print(i+1,open+1,close,n,s);
		}
	}
}
