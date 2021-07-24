package exception;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

@SuppressWarnings("unused")
public class S1 {
public static void main(String[] args) throws RuntimeException,IOException {
	try {
		BufferedReader br = new BufferedReader(new FileReader("f.txt"));
		int p = 10/0;
	} catch (RuntimeException|IOException e) {
		//e=new IOException();
		throw e;
	}
	System.out.println("line after exception");
	//int p = Integer.parseInt("10");
 try{
	 new S1().run();
 }finally{}
}
public void run(){
	try{
		FileReader fr = new FileReader(new File("f.txt"));
	}catch(IOException e){}
}
}
