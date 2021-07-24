package collection;

import java.util.Arrays;

public class Search1 {
	String[] words={"this","that","these","those","then"};
	public static void main(String[] args) {
		String given="ohtes";
		String result="";
		System.out.println(new Search1().searchAnagram(result,given));
		//System.out.println(given.substring(0,2)+given.substring(3,given.length()));
		//System.out.println(given.substring(4,5));
	}
	private boolean searchAnagram(String result, String given) {
		if(given.isEmpty()){
			//System.out.println(result);
			if(Arrays.binarySearch(words, result)!=-1)
				return true;
			}
	else{
		for(int i=0;i<given.length();i++)
		if(searchAnagram(result+given.charAt(i),given.substring(0,i)+given.substring(i+1,given.length()))==true)
	return true;
	}
		return false;
}
}