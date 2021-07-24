package com.test3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Test3 {
	static long find(int[] a,int n,int min) {
        long result = Integer.MAX_VALUE;
        for(int j=0;j<5;j++) {
            //int curr = (j+1)/2;
            long curr=0;
            if(min-j>=0) {
                for(int i=0;i<n;i++) {
                    int p = a[i]- (min-j);
                    curr+= p/5 + (1+ (p%5))/2;
                }
                if(result>curr) result = curr;
            }
        }
        return result;
    }
    public static void main(String args[] ) throws Exception {
       Scanner sc = new Scanner(new File("I:/input3.txt"));
       BufferedWriter bw = new BufferedWriter(new FileWriter(new File("I:/output.txt")));
        int t = sc.nextInt();
        for(int i=0;i<t;i++) {
            int n = sc.nextInt();
            int min=Integer.MAX_VALUE;
            int[] a = new int[n];
            for(int j=0;j<n;j++) {
            	String str = "Empty";
            	try{
            		str = sc.next();
               // a[j] = sc.nextInt();
            	}catch(Exception e) {
            		System.out.println("Exception occured at row= "+j+" column = "+i+"and string is "+str+"\n"+e);
            	}
                if(min>a[j]) min = a[j];
            }
           // long result = find(a,n,min);
            //bw.write(result+"\n");
        }
        sc.close();
        bw.close();
    }
}
