package com.test3;

import java.io.File;
import java.util.Scanner;

public class Test4 {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(new File("I:/input2.txt"));
		int count =1;
		while(sc.hasNextInt()){
			try {
				int p = sc.nextInt();
//				if(count>=8951 && count<=8960)
//					System.out.println(p);
			}catch(Exception e) {
			System.out.println("Exception occured at "+count+"\n"+e);	
			}
			count++;
		}
		System.out.println(count);
		
	}
}
