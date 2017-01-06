package com.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

class A{
	int x,y,z;
	long val;
}
public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("I:/input.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("I:/output.txt"));
        int q = sc.nextInt();
        sc.nextLine();
        while(q>0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            sc.nextLine();
            A[] arr = new A[1000];
//            for(int i=0;i<1000;i++)
//            	arr[i] = new A();
            int count = 0;
        for(int p =0;p<m;p++) {
            String str = sc.nextLine();
            String[] s = str.split("\\s");
            if(s[0].equals("UPDATE")) {
                int x = Integer.parseInt(s[1]);
                int y = Integer.parseInt(s[2]);
                int z = Integer.parseInt(s[3]);
                long w = Long.parseLong(s[4]);
                arr[count] = new A();
                arr[count].x=x;
                arr[count].y=y;
                arr[count].z=z;
                arr[count].val=w;
                count++;
                
                
            }
            else {
                long sum=0;
                int x1 = Integer.parseInt(s[1]);
                int y1 = Integer.parseInt(s[2]);
                int z1 = Integer.parseInt(s[3]);
                int x2 = Integer.parseInt(s[4]);
                int y2 = Integer.parseInt(s[5]);
                int z2 = Integer.parseInt(s[6]);
                for(int i=0;i<count;i++){
                	if(x1<=arr[i].x && arr[i].x<=x2 && y1<=arr[i].y && arr[i].y<=y2
                			&& z1<=arr[i].z && arr[i].z<=z2)
                		sum+=arr[i].val;
                	
                }
                //System.out.println(sum);
                bw.write(String.valueOf(sum));
                bw.newLine();
                bw.flush();
            }
          /*  if(count==318){
            	for(int i=0;i<count;i++){
            		System.out.println(arr[i].val);
            	}
            	System.out.println(p);
            	System.exit(1);
            }*/
        }
            q--;
        }
            sc.close();
            bw.close();
    }
}