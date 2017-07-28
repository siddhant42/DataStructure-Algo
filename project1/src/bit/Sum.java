package bit;

public class Sum {
	public static int add(int x,int y) {
		int carry = x&y;
		int sum = x^y;
		sum = sum|(carry<<1);
		return sum;
	}
	public static void main(String[] args) {
		int a = 5,b=3;
		System.out.println(add(a,b));
	}
}
