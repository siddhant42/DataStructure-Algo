package collections2;

import java.io.FileReader;
import java.util.Properties;

public class Test2 {  
public static void main(String[] args)throws Exception{  
    FileReader reader=new FileReader("src/collections/db.properties");  
      
    Properties p=new Properties();  
    p.load(reader);  
      p.setProperty("book", "java");
    System.out.println(p.getProperty("user"));  
    System.out.println(p.getProperty("password")); 
    System.out.println(p.getProperty("book"));
}  
} 