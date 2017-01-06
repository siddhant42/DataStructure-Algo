package trie;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Solution obj = new Solution();
		int lastAns=0;
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m =sc.nextInt();
		ArrayList<Integer>[] seqList = new ArrayList[n];
		sc.nextLine();
		for(int i=0;i<n;i++){
			seqList[i] = new ArrayList<Integer>();
		}
		int p,x,y,seq;
		for(int i=0;i<m;i++) {
			p = sc.nextInt();
			x = sc.nextInt();
			y = sc.nextInt();
			if(p==1){
				seq=(x^lastAns)%n;
				seqList[seq].add(y);
			}
			else{
				seq=(x^lastAns)%n;
				int size = seqList[seq].size();
				lastAns = seqList[seq].get(y%size);
				System.out.println(lastAns);
			}
		}
		sc.close();
	}
}
