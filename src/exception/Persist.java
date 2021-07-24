package exception;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

class Persist{  
	 public static void main(String args[]) {  
	  Student s1 =new Student(211,"ravi",new Date());  
	  
	  try {
		FileOutputStream fout=new FileOutputStream("f.txt");
	}   catch(RuntimeException ex){
		ex.printStackTrace();
	}catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  /*ObjectOutputStream out=new ObjectOutputStream(fout);  
	  
	  out.writeObject(s1);  
	  out.flush();  
	  out.close();*/
	  System.out.println("success");  
	 }  
	}  
