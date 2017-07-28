package bit;

public class ShiftNibble {
	public static byte shift(byte b1) {
		/*byte k1 =(byte)(b1>>4);
		byte k2 = (byte)(((1<<4)-1)&b1);
		byte res = (byte)(k1^k2);
		return (byte)(b1^(res<<4)^res);*/
		return (byte) ((b1>>4)|(b1<<4));
	}
	public static char find(char a) {
		return (char)(((a&0x0F)<<4)|((a&0xF)>>4));
	} 
	public static void main(String[] args) {
		byte b1 = 25;
		//System.out.println(shift(b1));
		char c = 25;
		System.out.println((int)find(c));
	}
}
