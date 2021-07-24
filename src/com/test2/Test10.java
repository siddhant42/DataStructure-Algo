package com.test2;

import java.math.BigInteger;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class Test10 {
	static int threshold(int num,int p) {
        int count = 1;
        while(true) {
            if(Math.pow(count,p)>num) break;
            count++;
        }
        return count;
    }
    static int find(int sum,int p,int st,int t) {
    	if(sum<0) return 0;
        if(sum==0) return 1;
        int count = 0;
        for(int i=st;i<t;i++) {
            count+=find(sum-(int)Math.pow(i,p),p,i+1,t);
        }
        return count;
    }
    
    static String[] braces(String[] values) {


    	String[] result = new String[values.length];
        char c,st ;
        int j;
        Stack<Character> mystack = new Stack<Character>();
        for(int i=0;i<values.length;i++)
        {
        	result[i]="NO";
        	for( j =0;j<values[i].length();j++)
        	{
        		if(values[i].length()%2 !=0)
        		{
        			result[i]= "NO";
        			break;
        		}
        		c = values[i].charAt(j);
        		if((c == '{') || (c == '(') || (c == '['))
        		{
        			mystack.push(c);	
        		}
        		else
        		{
        			st = mystack.pop();
        			if((c == '}' && st == '{') || (c == ']' && st == '[') || (c== ')' && st == '('))
        			{
        				//result[i]="YES";
        			}
        			else
        			{
        				result[i]="NO";
        				mystack.empty();
        				break;
        			}
        		}
        	}
        	if(j==values[i].length())
        	{
        		result[i]="YES";
        	}
        		
        		
        }
        return result;
            
        }
    
    static void findSubstrings(String s) {

    	String mystr = s.substring(s.indexOf('a'));
    	s.matches("^a[^aeiou]");

    }
    static int[] getMinimumDifference(String[] a, String[] b) {

    	int[] res = new int[a.length];
    	   Map<String, Integer> mapa = new TreeMap<String, Integer>();           
    	
    	   Map<String, Integer> mapb = new TreeMap<String, Integer>();           
    	for(int i = 0 ; i< a.length;i++)
    	{
    		if(b[i].length() != a[i].length())
    		{
    			res[i]= -1;
    		}
    		else
    		{
    			for(int j = 0 ; j<a[i].length();j++)
    			{
    				char aa = a[j].charAt(j);
    				char bb = b[j].charAt(j);
    				
    				if(mapa.containsKey(""+aa))
    				{
    					mapa.put(""+aa, mapa.get(""+aa) + 1);
    				}
    				else
    				{
    					mapa.put(""+aa, 1);
    				}
    				if(mapb.containsKey(""+bb))
    				{
    					mapa.put(""+bb, mapa.get(""+bb) + 1);
    				}
    				else
    				{
    					mapa.put(""+bb, 1);
    				}
    				
    				
    			}
    			int counter=0;
    			for(String key:mapa.keySet())
    			{
    				if(! mapb.containsKey(key))
    				{
    					counter++;
    				}
    				else
    				{
    					if(mapa.get(key)> mapb.get(key))
    					{
    					counter = counter + (mapa.get(key) - mapb.get(key));
    					}
    					else
    					{
    						counter = counter + (mapb.get(key) - mapa.get(key));
    					}
    				}
    			}
    			res[i]=counter;
    		}
    	}

    	return res;
    }

    
    public static void main(String[] args) {
    	/*BigInteger big = new BigInteger("1");
    	big.add(new BigInteger("2"));
    	System.out.println(big);*/
    	
    	String[] myarr = {"{}()[](","{([)]}"};
    	String[] res = new String[2];
    	res = braces(myarr);
    	System.out.println(res[0]);
    	System.out.println(res[1]);
    	
    }
}
