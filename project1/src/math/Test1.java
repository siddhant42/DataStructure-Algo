package math;

import java.math.BigDecimal;

public class Test1 {
 public void m(){
	 BigDecimal b = new BigDecimal(String.valueOf(10));
	 b = b.pow(9);
	 b = b.add(new BigDecimal(String.valueOf(7)));
	 System.out.println(b);
 }
 public static void main(String[] args) {
	 BigDecimal b = new BigDecimal(String.valueOf(10));
	 b = b.pow(9);
	 b = b.add(new BigDecimal(String.valueOf(7)));
	 System.out.println(b);
}
}
