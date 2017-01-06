package com.test;

public class S3 {
	public void printArray(int[] a,int[] b){
		int[] c=new int[a.length+b.length];
		boolean flag=true;
		printrec(a,b,c,0,0,0,flag);
	}
private void printrec(int[] a, int[] b, int[] s,int idx, int i, int j, boolean flag) {
	/*	if(flag && idx!=0 && idx%2==0){
			for(int p=0;p<=idx;p++)
				System.out.print(s[p]+" ");
			System.out.println();
			return;
		}*/
		if(flag){
			if(idx!=0 ){
				for(int p=0;p<=idx;p++)
					System.out.print(s[p]+" ");
				System.out.println();
			}
		for(int k=i;k<a.length;k++){
			if(idx==0){
			s[idx]=a[k];
		    printrec(a,b,s,idx,k+1,j,!flag);	
		} else if(s[idx]<a[k]){
			s[idx+1]=a[k];
			
		    printrec(a,b,s,idx+1,k+1,j,!flag);	
		}
			}
		
		}
		else{
			for(int k=j;k<b.length;k++){
				if(s[idx]<b[k]){
					s[idx+1]=b[k];
			printrec(a,b,s,idx+1,i,k+1,!flag);}
		}}
		
	}
public static void main(String[] args) {
	int[] a={10,15,25};
	int[] b={1,5,20,30};
	new S3().printArray(a,b);
}
}
