package com.test2;

import java.util.Scanner;

public class Test26 {

	public static void main(String[] args) {
		try {
		for(int i=0;i<10;i++) {
			System.out.println(i);
			if(i==4) throw  new Exception();
			
			
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
