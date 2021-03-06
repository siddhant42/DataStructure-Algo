package recursion;

import java.util.Arrays;

public class Permute5 {
	public void permute(int[] s, int currIndex) {
		if (currIndex == s.length - 1) {
			for(int i:s) 
				System.out.print(i+" ");
			System.out.println();
			return;
		}
		permute(s, currIndex + 1);
		//Integer prevIdx=null,num=null;'
		int prevIdx=0,num=0;
		for (int i = currIndex + 1; i < s.length; i++) {
			if (s[currIndex] == s[i]||(prevIdx==currIndex && num==s[i])) continue;
			prevIdx = currIndex;num = s[i];
			int[] p = Arrays.copyOfRange(s, 0,s.length);
			int tmp = p[currIndex];
			p[currIndex] = p[i];
			p[i] = tmp;
			permute(p, currIndex + 1);
		}
	}
	public static void main(String[] args) {
		Permute5 obj = new Permute5();
		int[] a={1,2,3,2};
		obj.permute(a, 0);

	}
}
