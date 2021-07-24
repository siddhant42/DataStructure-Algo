package com.test2;

import java.io.IOException;
import java.util.Scanner;

public class Test27 {
	public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        long num = sc.nextLong();
        sc.close();
        long result = MaximumNumber(num);
        System.out.println(result);
    }
    static long MaximumNumber(long num){
        long result=0,x=num,count=0; 
        while(x>0) {
            result+=(x%10)*(long)Math.pow(2,count);
            count++;x=x/10;
        }
        long val=0,maxval=0; 
        count=0;x=num; 
        while(x>0) {
            if(x%10==0) val = result+(long)Math.pow(2,count);
            else val = result-(long)Math.pow(2,count);
            count++;
            if(val%3==0 && maxval<val) maxval = val;
            x = x/10;
        }
        if(maxval==0) return -1;
    return maxval;
    }
}
