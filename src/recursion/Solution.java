package recursion;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
	int totalSum=0,count=0;
	int sumArray(int[] a) {
		int sum=0;
		for(int i=0;i<a.length;i++)
			sum+=a[i];
		return sum;
	}
	int find(int[] a) {
		int[] s = new int[a.length];
		Arrays.fill(s, 1);
		Stack<Integer> st = new Stack<>();
		for(int i=0;i<a.length;i++) {
		while(st.empty()==false && a[i]>a[st.peek()]) {
				s[i]+=s[st.pop()];
		}
		st.push(i);
		}
		return sumArray(s);
	}
	public void permute(int[] s, int currIndex) {
        if (currIndex == s.length - 1) {
        	totalSum+=find(s);
        	count++;
            return;
        }
        permute(s, currIndex + 1);
        
        for (int i = currIndex + 1; i < s.length; i++) {
            if (s[currIndex] == s[i]) continue;
            int tmp = s[currIndex];
            s[currIndex] = s[i];
            s[i] = tmp;
            permute(s, currIndex + 1);
            int tmp2 = s[currIndex];
            s[currIndex] = s[i];
            s[i] = tmp2;
        }
    }
	public static void main(String[] args) {
		Solution obj = new Solution();
		int[] a = {1,2,3};
		obj.permute(a, 0);
		System.out.printf("%.2f",(float)obj.totalSum/obj.count);
	}
}
