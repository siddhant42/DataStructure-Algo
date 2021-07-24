package recursion;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Permute6 {
	public void permute(String str,String tmp,Set<BigInteger> set) {
		if(tmp!="")
			set.add(new BigInteger(tmp));
		for(int i=0;i<str.length();i++) {
			String newTmp = tmp+str.charAt(i);
			permute(str.substring(0,i)+str.substring(i+1,str.length()),newTmp,set);
		}
	}
	public static BigInteger getDivisor() {
		BigInteger b = new BigInteger("10");
		b = b.pow(9);
		b = b.add(new BigInteger("7"));
		return b;
	}
	public static void main(String[] args) {
		Permute6 obj = new Permute6();
		String str = "";
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while(n>0) {
			int a = sc.nextInt(),b = sc.nextInt(),c = sc.nextInt();
			while(a>0) {
				str+=4; a--;
			}
			while(b>0) {
				str+=5; b--;
			}
			while(c>0) {
				str+=6; c--;
			}
			Set<BigInteger> set = new HashSet<>();
			obj.permute(str, "", set);
			BigInteger result = new BigInteger(String.valueOf(0));
			for(BigInteger s:set)
				result=result.add(s);
			BigInteger div = getDivisor();
			System.out.println(result.remainder(div));
			str = "";
			n--;
		}
		sc.close();
	}
}
