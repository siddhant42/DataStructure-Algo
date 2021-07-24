package com.test2;

import java.io.File;
import java.io.FilenameFilter;

public class Test8 {
	 public static void main(String[] args) {
      File dir = new File("I:");
/*		      FilenameFilter filter = new FilenameFilter() {
	         public boolean accept (File dir, String name) { 
	            return name.equals("test12.txt");
	         } 
	      }; 
	      String[] children = dir.list(filter);
	      if (children == null) {
	         System.out.println("Either dir does not exist or is not a directory"); 
	      } else { 
	         for (int i=0; i< children.length; i++) {
	            String filename = children[i];
	            System.out.println(filename);
	         } 
	      } */
   /*   String str = search(dir,"input.txt");
      System.out.println(str);*/
      int a=5,b=4;
	   } 
	 static String search(File file,String fileName) {
		 for(File temp: file.listFiles()) {
			 if(temp.isDirectory())
				 return search(temp,fileName);
			 else if(fileName.equals(temp.getName()))
				 return temp.getAbsolutePath().toString();
		 }
		 return null;
	 }
	 
}
