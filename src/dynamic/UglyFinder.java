package dynamic;

public class UglyFinder {
	public static void main(String[] args) {
		int n = 150;
		System.out.println(new UglyFinder().findUgly(n));
	}
	public int findUgly(int n) {
		if(n<=0) return -1;
		int i2,i3,i5,nextUgly=0;
		i2=i3=i5=0;
		int nextugly2=2;
		int nextugly3=3;
		int nextugly5=5;
		int[] ugly = new int[n+1];
		ugly[0]=1;
		for(int i=1;i<=n;i++) {
			nextUgly=min(nextugly2,nextugly3,nextugly5);
			ugly[i] = nextUgly;
			if(nextUgly == nextugly2) {
				i2++;
				nextugly2=ugly[i2]*2;
			}
			if(nextUgly == nextugly3) {
				i3++;
				nextugly3=ugly[i3]*3;
			}
			if(nextUgly == nextugly5) {
				i5++;
				nextugly5=ugly[i5]*5;
			}
		}
		return ugly[n-1];
	}

	private int min(int a, int b, int c) {
		if(a<=b && a<=c) return a;
		else if (b<=a && b<=c) return b;
		return c;
	}
}
