package matrix;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CommonElements {
	static int find(int[][] a) {
		if(a==null || a.length==0 || a.length==1) return -1;
		int m = a.length,n=a[0].length;
		int[] tmp = new int[m];
		int[] s = Arrays.copyOfRange(a[0], 0, a[0].length);
		for(int i=1;i<m;i++) {
			int j=0,k=0,p=0;
			while(j<s.length && k<n) {
				if(s[j]<a[i][k]) j++;
				else if(s[j]>a[i][k]) k++;
				else {
					tmp[p] = s[j];
					p++; j++; k++;
				}
			}
			if(p==0) return -1;
			s= Arrays.copyOfRange(tmp, 0, p);
		}
		if(s.length>0) return s[0];
		return -1;
	}
	static int find2(int[][] a) {
		if(a==null || a.length==0 || a.length==1) return -1;
		Map<Integer,Integer> map = new HashMap<>();
		int m = a.length,n = a[0].length;
		for(int i=0;i<n;i++)
			map.put(a[0][i], 0);
		for(int i=1;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(map.get(a[i][j])!=null && map.get(a[i][j])==i-1) map.put(a[i][j], i);
			}
		}
		int result = -1;
		for(int i=0;i<n;i++) {
			if(map.get(a[m-1][i])!=null && map.get(a[m-1][i])==m-1) {
				result = a[m-1][i];
				break;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		int mat[][] = { {1, 2, 3, 4, 5},
                {2, 4, 5, 8, 10},
                {3, 5, 7, 9, 11},
                {1, 3, 5, 7, 9},
              };
		int result = find2(mat);
		if(result==-1) System.out.println("no common elements found");
		else System.out.println(result);
	}
}
