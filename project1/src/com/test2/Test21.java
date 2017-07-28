package com.test2;

import java.io.IOException;
import java.util.Scanner;

public class Test21 {
	static boolean isPrime(long a) {
		if(a==2) return true;
		for(int i=3;i<(int)Math.sqrt(a);i+=2){
			if(a%i==0) return false;
		}
		return true;
	}
	public static void main(String[] args) throws IOException {
/*        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for(int j=0;j<n;j++)
            a[j] = sc.nextInt();
            int result = score(a,0,n-1);
            System.out.println(result);
        }
        sc.close();*/
		int[] a = {0, 2, 3, 2, 3};
		System.out.println(score(a,0,a.length-1));
    }
    static int score(int[] a,int i,int j){
        if(i>=j) return 0;
        long l=1,r=1;
        long s1=0,s2=0;
        while(i<=j) {
            if(a[i]==0) i++;
            else if(a[j]==0) j--;
            else if(l<=r) {
                s1+=a[i];
                l*=a[i++];
            }
            else {
                s2+=a[j];
                r*=a[j--];
            }
        }
        if((s1==s2 && l==r)||(isPrime(l)&&isPrime(r)))
        return 1+score(a,i,a.length-1);
        else return 0;
    }
}
