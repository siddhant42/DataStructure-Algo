package dynamic;

public class Keypad {
	static long find(int n) {
		int[][] s = new int[10][];
		s[0]=new int[]{0,8};//9
		s[1]=new int[]{1,2,4};//11
		s[2]=new int[]{1,2,3,5};//15
		s[3]=new int[]{2,3,6};//11
		s[4]=new int[]{1,4,5,7};//15
		s[5]=new int[]{2,4,5,6,8};//22
		s[6]=new int[]{3,5,6,9};//15
		s[7]=new int[]{4,7,8};//12
		s[8]=new int[]{0,5,7,8,9};//18
		s[9]=new int[]{6,8,9};//12
		if(n<=0) return 0;
		if(n==1) return s.length;
		long max = 0;
		for(int i=0;i<s.length;i++){
			max+=findMax(s,s[i],n-1);
		}
		return max;
	}
	static long findMax(int[][] a,int[] s,int n) {
		if(n<=0) {
			return 0;
		}
		if(n==1) return s.length;
		long max = 0;
		for(int i=0;i<s.length;i++) {
			max+=findMax(a,a[s[i]],n-1);
		}
		return max;
	}
	public static void main(String[] args) {
		for(int n=1;n<=6;n++)
		System.out.println(find(n));
	}
}
