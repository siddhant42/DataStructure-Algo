package array3;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class NumberReading {
    public static int [] readNumsFromCommandLine() {

        Scanner s = new Scanner(System.in);

        int count = s.nextInt();
        s.nextLine(); // throw away the newline.

        int [] numbers = new int[count];
        Scanner numScanner = new Scanner(s.nextLine());
        for (int i = 0; i < count; i++) {
            if (numScanner.hasNextInt()) {
                numbers[i] = numScanner.nextInt();
            } else {
                System.out.println("You didn't provide enough numbers");
                break;
            }
        }

        return numbers;
    }

    public static void main(String[] args) {
        int[] numbers = readNumsFromCommandLine();
       Stack<Integer> s=new Stack<Integer>();
       int max=0,i;
       for(i=0;i<numbers.length;i++){
    	   if(s.isEmpty()) s.push(numbers[i]);
    	   else{
    		   while(s.isEmpty()==false && numbers[i]>s.firstElement())
    			   s.pop();
    		   s.push(numbers[i]);
    	   }
    	  
    	   if(max<s.size()){
    		   max=s.size();
    		  
    	   }
       }
       System.out.println(max);
    }
}
