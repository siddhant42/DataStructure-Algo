package com.test2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test16 {
	public static long find(int[] a,int k) {
	    
        int n = a.length;
    long res = a[0]; 
    for (int j = 0; j < n; j++) {
        for (int p = j; p < n; p++) {
            List<Integer> list1= new ArrayList<Integer>();
            List<Integer> list2 = new ArrayList<Integer>(); 
            int sum = 0; 
            for (int i = 0; i < n; i++) {
                if (i >= j && i <= p) {
                 list1.add(a[i]);
                    sum += a[i];
                } else {
                    list2.add(a[i]);
                }
            }

            Collections.sort(list1);

            Collections.sort(list2);
            Collections.reverse(list2);
            res = Math.min(res, sum); 
            for (int t = 1; t <= k; t++) {

                if (t > list1.size() || t > list2.size()) break;

                sum -= list1.get(list1.size() - t);
                sum += list2.get(list2.size() - t);
                res = Math.min(res, sum);
            }
        }
    }
    return res;
   
   }
   public static void main(String args[] ) throws Exception {
   Scanner sc = new Scanner(System.in);
   int t = sc.nextInt();
   for(int i=0;i<t;i++) {
       int n = sc.nextInt();
       int k = sc.nextInt();
       int[] a = new int[n];
       long result = find(a,k);
       System.out.println(result);
   }
   }
}
