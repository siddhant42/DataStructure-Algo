package stack;

import java.io.File;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("I:/input.txt"));
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++)
            a[i] = sc.nextInt();
        sc.close();
        int max = Integer.MIN_VALUE;
         for(int i=0;i<n-1;i++) {
             int s =(1&(a[i]^a[i+1]))|( a[i]^a[i+1]);
            		 //((a[i]&a[i+1])^(a[i]|a[i+1]))&(a[i]^a[i+1]);
             if(max<s) max = s;
         }
        System.out.println(max);
    }
}
