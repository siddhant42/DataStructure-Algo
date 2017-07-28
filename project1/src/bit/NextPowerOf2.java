package bit;

public class NextPowerOf2 {
	public static int find(int n) {
		n--;
		n |= n>>1;
		n |= n>>2;
		n |= n>>4;
		n |= n>>8;
		n |= n>>16;
		return n+1;
	}
	public static void main(String[] args) {
		int n = 16;
		System.out.println(find(n));
	}
}
