package recursion;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permute4 {
	 public  Set<List<Integer>> permutation(Integer[] a) {
	        final Set<List<Integer>> stringPermutations = new HashSet<>();
	        permute(a, 0, stringPermutations);
	        return stringPermutations;
	    }
	    public void permute(Integer[] s, int currIndex,Set<List<Integer>> set) {
	        if (currIndex == s.length-1) {
	        	Integer[] p = s;
	        	List<Integer> list = Arrays.asList(p);
	        	set.add(list);
	        	for(List<Integer> l:set)
	        		System.out.println(l);
	        	return;
	        }

	        // prints the string without permuting characters from currIndex onwards.
	        permute(s, currIndex + 1,set);

	        // prints the strings on permuting the characters from currIndex onwards.
	        for (int i = currIndex+1 ; i <s.length; i++) {
	            Integer tmp = s[currIndex];
	            s[currIndex] = s[i];
	            s[i] = tmp;
	            permute(s, currIndex + 1,set);
	            Integer tmp2 = s[currIndex];
	            s[currIndex] = s[i];
	            s[i] = tmp2;
	        }
	    }

	    public static void main(String[] args) {
	    	Permute4 obj = new Permute4();
	    	Integer[] a= {10,2,4,4};
	    	Set<List<Integer>> set = obj.permutation(a);
//	        for(List<Integer> list:set){
//	        	System.out.println(list);
//	        	//System.out.println();
//	        }
	    }

}
