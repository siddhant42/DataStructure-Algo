package heap;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

import trie.MaxHeap;
import trie.MinHeap;

public class MedianHeap {
	MinHeap minHeap;
	MaxHeap maxHeap;

	public MedianHeap() {
		super();
	}
	public MedianHeap(MinHeap minHeap, MaxHeap maxHeap) {
		super();
		this.minHeap = minHeap;
		this.maxHeap = maxHeap;
	}
	public int signum(Integer a,Integer b) {
		return a.compareTo(b);
	}
	public double insert(int data,double median) {
		int s = signum(minHeap.getSize(),maxHeap.getSize());
		double m=0;
		switch(s){
		case 1:
		if(data>median) {
			maxHeap.insert(minHeap.deleteTop());
			minHeap.insert(data);
		}
		else {
			maxHeap.insert(data);
		}
		m = (double)(minHeap.getRootNode()+maxHeap.getRootNode())/2;
		break;
		case 0:
			if(data>median) {
				minHeap.insert(data);
			}
			else {
				maxHeap.insert(data);
			}
			if(minHeap.getSize()>maxHeap.getSize())
				m=minHeap.getRootNode();
			else
				m = maxHeap.getRootNode();
			break;
		case -1:
			if(data>median) {
				minHeap.insert(data);
			}
			else {
				minHeap.insert(maxHeap.deleteTop());
				maxHeap.insert(data);
			}
			m=(double)(minHeap.getRootNode()+maxHeap.getRootNode())/2;
			
		}
		return m;
	}
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("I:/input.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("I:/output.txt"));
		int n = sc.nextInt();
		MinHeap minHeap = new MinHeap(n/2+1);
		MaxHeap maxHeap = new MaxHeap(n/2+1);
		MedianHeap obj = new MedianHeap(minHeap,maxHeap);
		double median=0;
		for(int i=0;i<n;i++) {	
			int in = sc.nextInt();
			median = obj.insert(in, median);
			//System.out.printf("%.1f\n",median);
			bw.write(String.valueOf(median));
			bw.newLine();
		}
		sc.close();
		bw.close();
	}
}
