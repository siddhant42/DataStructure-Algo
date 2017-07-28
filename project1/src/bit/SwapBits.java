package bit;

public class SwapBits {
	public static int swap(int n) {
/*		int result = 0,o=0,e=1;
		while(n>0) {
			result|=(n&1)<<e;
			n=n>>1;
			result|=(n&1)<<o;
			n=n>>1;
			o+=2;
			e+=2;
		}
		return result;*/
		 int even_bits = n & 0xAAAAAAAA; 
		 int odd_bits  = n & 0x55555555;
		 even_bits >>= 1;  // Right shift even bits
		    odd_bits <<= 1;   // Left shift odd bits
		 
		    return (even_bits | odd_bits); 
	}
	public static void main(String[] args) {
		int n = 27;
		System.out.println(swap(n));
		System.out.println(0xAAAAAAAA);
		System.out.println(0x55555555);
	}
}
