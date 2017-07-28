package bit;

public class SwapBit {
	public static int swap(int num,int p1,int p2,int n) {
		int set1 = (num>>p1)&((1<<n)-1);
		int set2 = (num>>p2)&((1<<n)-1);
		int xor = set1^set2;
		xor = (xor<<p1) | (xor<<p2);
		int result = num^xor;
		return result;
	}
	public static void main(String[] args) {
		int num = 47;
		int p1 = 1;
		int p2 = 5;
		int n = 3;
		int result = swap(num,p1,p2,n);
		System.out.println(result);
	}
}
