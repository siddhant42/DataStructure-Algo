package array;

import java.util.Stack;

public class HistoGram {
	int findMax(int[] a){
		int max=Integer.MIN_VALUE;
		int currMax=Integer.MIN_VALUE;
		Stack<Integer> s = new Stack<>();
		int i=0;
		while(i<a.length){
			if(s.isEmpty() || a[s.peek()]<=a[i])
				s.push(i++);
			else {
				int tp = s.pop();
				currMax = a[tp] * (s.isEmpty()?i:i-s.peek()-1);
				if(max<currMax)
					max = currMax;
			}}
			while(s.isEmpty()==false){
				int tp = s.pop();
				currMax = a[tp] * (s.isEmpty()?i:i-s.peek()-1);
				if(max<currMax)
					max = currMax;
			}
		
		return max;
	}
public static void main(String[] args) {
	HistoGram obj = new HistoGram();
	int[] a = {6,2,5,4,5,1,6};
	System.out.println(obj.findMax(a));
	int[][] a1= {
			   {0 , 1,  1,  1,  1 },
			   {1,  1,  0,  1,  0 },
			   {1,  1,  1,  1,  0},
			   {1,  1,  1,  1,  0},
			   {1,  1,  0,  1,  1},
			   {0,  0,  1,  1,  1}
	};
	System.out.println(obj.findMaxArea(a1));
	
}
private int findMaxArea(int[][] a) {
	int max=Integer.MIN_VALUE;
	int currMax=0;
	assert(a!=null);
	assert(a.length>0);
	for(int i=1;i<a.length;i++){
		for(int j=0;j<a[0].length;j++){
			if(a[i-1][j]!=0 && a[i][j]!=0)
				a[i][j]+=a[i-1][j];
		}
	}
	for(int i=0;i<a.length;i++){
		currMax=findMax(a[i]);
		if(max<currMax)
			max = currMax;
	}
	return max;
}
}
