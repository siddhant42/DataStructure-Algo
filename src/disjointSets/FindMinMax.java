package disjointSets;

import java.util.Arrays;
import java.util.Scanner;

public class FindMinMax {
	int[] rank,parent,members;
	int n;

	public FindMinMax(int n) {
		super();
		rank = new int[2*n+1];
		parent = new int[2*n+1];
		members = new int[2*n+1];
		this.n= n;
		setMembers();
	}
	private void setMembers(){
		for(int i=1;i<=2*n;i++)
			parent[i]=i;
		Arrays.fill(members, 1);
	}
	int findRoot(int x){
		if(x!=parent[x]){
			return findRoot(parent[x]);
		}
		return parent[x];
	}
	void union(int x,int y){
		int xRoot = findRoot(x);
		int yRoot = findRoot(y);
		if(xRoot == yRoot) return;
		if(rank[xRoot]<rank[yRoot]){
			parent[xRoot] = yRoot;
		members[yRoot]+=members[xRoot];
		}
		else if(rank[yRoot]<rank[xRoot]){
			parent[yRoot] = xRoot;
			members[xRoot]+=members[yRoot];
		}
		else{
			parent[xRoot] = yRoot;
			rank[yRoot]+=1;
			members[yRoot]+=members[xRoot];
		}
	}
	public void findMinMax(int n){
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(int i=1;i<=n;i++) {
			int p = findRoot(i);
			int num = members[p];
			if(num!=1){
				if(max<num) max = num;
				if(min>num) min = num;
			}
		}
		System.out.println(min+" "+max);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		FindMinMax obj = new FindMinMax(n);
		for(int i=0;i<n;i++){
			int p = sc.nextInt();
			int q = sc.nextInt();
			obj.union(p, q);
		}
		sc.close();
		obj.findMinMax(n);
	}
}
