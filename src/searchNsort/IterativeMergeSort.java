package searchNsort;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;
import java.util.Stack;

public class IterativeMergeSort {
	static class Point {
		private int low,high;
		public Point(int low,int high) {
			this.low = low;
			this.high = high;
		}
		public String toString() {
			return "("+low+","+high+")";
		}
	}
	public static void merge(int[] nums,int low,int mid,int high) {
		int[] tmp = new int[high-low+1];
		int i=low,j=mid+1,k=0;
		while(i<=mid && j<=high) {
			if(nums[i]<nums[j]) {
				tmp[k++] = nums[i++];
			} else {
				tmp[k++] = nums[j++];
			}
		}
		while(i<=mid) {
			tmp[k++] = nums[i++];
		}
		while(j<=high) {
			tmp[k++] = nums[j++];
		}
		k=0;
		i=low;
		while(i<=high)
			nums[i++] = tmp[k++];
	}
	public static void iterativeSort(int[] nums) {
		if(nums==null || nums.length<=1) return;
		Stack<Point> s = new Stack<>();
		LinkedList<Point> queue = new LinkedList<>();
		
		int low=0,high=nums.length-1;
		queue.offer(new Point(low,high));
		while(!queue.isEmpty()) {
			Point point = queue.poll();
			s.push(point);
			int mid = (point.low+point.high)/2;
			if(point.low<mid)
				queue.offer(new Point(point.low,mid));
			if(mid+1<point.high)
				queue.offer(new Point(mid+1,point.high));
		}
		while(!s.empty()) {
			Point p = s.pop();
			int mid = (p.low+p.high)/2;
			merge(nums,p.low,mid,p.high);
		}
	}
	public static void iterativeSort2(int[] nums) {
		if(nums==null || nums.length<=1) return;
		int n = nums.length;
		for(int len=1;len<=n-1;len = 2*len) {
			for(int left=0;left <=n-len; left = left+ 2*len) {
				int mid = Math.min(left+len-1, n-1);
				int right = Math.min(left+2*len-1, n-1);
				merge(nums,left,mid,right);
			}
		} 
	}
	public static void main(String[] args) {
		int[] nums = new int[8];
		Random random = new Random();
		for(int i=0;i<nums.length;i++) {
			nums[i] = random.nextInt(100);
		}
		Arrays.stream(nums).forEach(x->System.out.print(x+" "));
		System.out.println();
		iterativeSort2(nums);
		Arrays.stream(nums).forEach(x->System.out.print(x+" "));
	}
}
