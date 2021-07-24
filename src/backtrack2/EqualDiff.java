package backtrack2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


class EqualDifff {
	boolean check(int idx,char ch,int[] p){
		int cnt=0,k=idx-(ch-95);
		if(p==null||p.length==0) return true;
		for(int i=0;i<idx;i++){
			if(p[i]==ch) cnt++;
		}
		if(cnt==0) return true;
		else if(cnt==1 && k>=0 && p[k]==ch )
			return true;
		else 
			return false;
	}
void printrec(int[] p,char[] r,int st,int n){
		if(st==2*n) 
			{
			for(int i=0;i<2*n;i++)
				System.out.print((char)p[i]);
			System.out.println();
			return;}
		
			for(int j=0;j<n;j++){
				if(check(st,r[j],p)){
					p[st]=r[j];
					printrec(p,r,st+1,n);
					p[st]=0;
				}
			}
			return  ;
		
	}
	void print(int n){
		if(n==0||n==1||n==2){  //because for n=1 & n=2 no such name is possible
			System.out.println("crazy compound");
			return;
		}
		int[] p=new int[2*n];
		//Arrays.fill(p, 0);
		String str="abcdefghijklmn";
		char[] r=str.substring(0, n).toCharArray();

		printrec(p,r,0,n);
		/*if(printrec(p,r,0,n)==true)
		{
			for(i=0;i<2*n;i++)
			System.out.print((char)p[i]);
			}
			else
			System.out.print("Crazy Compound");*/
}
		
	
    public static void main(String args[] ) throws Exception {
        // Read input from stdin and provide input before running
/*
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);*/
  new EqualDifff().print(3);
    }
}

