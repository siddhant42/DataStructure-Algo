package backtrack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;


class TestClass {
	boolean printrec(int[] p,char[] r,int curr,int n){
		if(curr==0) return true;
		for(int i=0;i<2*n-curr-1;i++){
			if(p[i]==0 && p[i+curr+1]==0){
				p[i]=p[i+curr+1]=r[curr-1];;
				if(printrec(p,r,curr-1,n))
					return true;
				p[i]=p[i+curr+1]=0;
			}
		}
		return false;
	}
	void print(int n){
		int i;
		int[] p=new int[2*n];
		Arrays.fill(p, 0);
		String str="abcdefghijklmn";
		char[] r=str.substring(0, n).toCharArray();

		if(printrec(p,r,n,n)==true)
		{
			p.toString();
			for(i=0;i<2*n;i++)
				System.out.print((char)p[i]);
		}
		else
			System.out.print("Crazy Compound");
	}


	public static void main(String args[] ) throws Exception {
		// Read input from stdin and provide input before running

//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String line = br.readLine();
//		int N = Integer.parseInt(line);
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		new TestClass().print(N);
		sc.close();
	}
}

