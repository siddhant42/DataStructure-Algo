package other;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Sample6 {
	 private static final char[][] _letters = new char[][]{
         {'0'},
         {'1'},
         {'A', 'B', 'C'},
         {'D', 'E', 'F'},
         {'G', 'H', 'I'},
         {'J', 'K', 'L'},
         {'M', 'N', 'O'},
         {'P', 'Q', 'R', 'S'},
         {'T', 'U', 'V'},
         {'W', 'X', 'Y', 'Z'}
 };

 public static void main(String[] args)
 {
     if (args.length != 1)
     {
         System.out.println("Please run again with your phone number (no dashes)");
         System.exit(0);
     }
     recursive_phoneSpell(args[0], 0, new ArrayList<String>());

 }


 private static void recursive_phoneSpell(String arg, int index, List<String> results)
 {
     if (index == arg.length())
     {
         printResults(results);
         return;
     }
     int num = Integer.parseInt(arg.charAt(index)+"");

     if (index==0)
     {
         for (int j = 0; j<_letters[num].length; j++)
         {
             results.add(_letters[num][j]+"");
         }
         recursive_phoneSpell(arg, index+1, results);
     }
     else
     {
         List<String> combos = new ArrayList<String>();
         for (int j = 0; j<_letters[num].length; j++)
         {
              for (String result : results)
              {
                  combos.add(result+_letters[num][j]);
              }
         }
         recursive_phoneSpell(arg, index+1, combos);
     }
 }

 private static void printResults(List<String> results)
 {
     for (String result : results)
     {
         System.out.println(result);
     }
 }
}
