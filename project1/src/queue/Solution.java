package queue;

import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
	static LinkedList<Point> list = new LinkedList<>();
	public static long find(int n,long totalTime){
		long TWT = 0,WT = 0,minIdx=Integer.MAX_VALUE;
		for(int k=0;k<n;k++){
			if(minIdx>list.get(k).x) minIdx=list.get(k).x;
		}
		long i = minIdx;
		while(i<totalTime){
			int min=0,minValue=Integer.MAX_VALUE;
			for(int j=0;j<list.size();j++){
				if( list.get(j).x<=i && minValue>list.get(j).y ){
					minValue = list.get(j).y;
					min=j;
				}
			}
			if(minValue!=Integer.MAX_VALUE) {
				i+= minValue;
				WT = i-list.get(min).x;
				TWT +=WT;
				list.remove(min);
			}
			else i++;
		}
		long avgWT = TWT/n;
		return avgWT;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long totalTime = 0;
		for(int i =0;i<n;i++){
			int p1 = sc.nextInt();
			int q1 = sc.nextInt();
			list.add(new Point(p1,q1));
		}
		for(int i=0;i<n;i++){
			totalTime += list.get(i).y;
		}
		sc.close();
		long avg = find(n,totalTime);
		System.out.println(avg);
		
	}
}