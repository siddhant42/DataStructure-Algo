package com.test2;
class OuterClass {

    static {

         System.out.println("Static Outer class loaded");

    }

    {

         System.out.println("Instance Outer class loaded");

    }

    public static class InnerClass {

         static {

              System.out.println("Static Inner class loaded");

         }

         {

              System.out.println("Instance Inner class loaded");

         }

    }

}
public class Test24 {
	public static void main(String[] args) throws ClassNotFoundException {
		 Class.forName("com.test2.OuterClass");
	}
}
