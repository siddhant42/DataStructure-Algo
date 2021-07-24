package dynamic;

import java.util.Arrays;
import java.util.Comparator;

public class MaxLengthPair {
	static class Pair{
		int x;
		int y;
		public Pair() {
			super();
		}
		public Pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	public static void main(String[] args) {
		Pair[] s=new Pair[4];
		s[0]=new Pair(27, 40);
		s[1]=new Pair(15, 25);
		s[2]=new Pair(50, 60);
		s[3]=new Pair(5, 24);
		int len=new MaxLengthPair().findMax(s);
		System.out.println(len);
	}
	private int findMax(Pair[] s) {
		Arrays.sort(s,new Comparator<Pair>(){
			public int compare(Pair s1,Pair s2){
				return s1.x-s2.x;
			}
		});
		int count=1;
		for(int i=1;i<s.length;i++){
			if(s[i-1].y<s[i].x)
				count++;
		}
		return count;
	}
}
