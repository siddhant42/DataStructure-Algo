package dynamic;

import java.io.File;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("I:/input.txt"));
        int n = sc.nextInt();
        while(n>0) {
            int m = sc.nextInt();
            int[] a = new int[m];
            for(int i=0;i<m;i++) {
                a[i] = sc.nextInt();
            }
            find(a);
            n--;
        }
            sc.close();
    }
    static void find(int[] a) {
        int max=0,currMax=0;
        for(int i=1;i<a.length;i++) {
            if(a[i]%2!=0)
                currMax+=a[i-1]-1;
            else 
                currMax+=a[i]-1;
        }
        if(max<currMax) max = currMax;
        currMax=0;
        for(int i=1;i<a.length;i++) {
            if(a[i]%2!=0)
                currMax+=a[i]-1;
            else 
                currMax+=a[i-1]-1;
        }
        if(max<currMax) max = currMax;
        System.out.println(max);
    }
}