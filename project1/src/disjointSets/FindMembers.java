package disjointSets;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class FindMembers {
	int[] rank,parent,members;
	int n;

	public FindMembers(int n) {
		super();
		rank = new int[n+1];
		parent = new int[n+1];
		members = new int[n+1];
		this.n= n;
		setMembers();
	}
	private void setMembers(){
		for(int i=1;i<=n;i++)
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
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(new File("I:/input.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("I:/output.txt"));
		int n = sc.nextInt();
		int q = sc.nextInt();
		sc.nextLine();
		FindMembers obj = new FindMembers(n);
		for(int i=0;i<q;i++){
			String str = sc.nextLine();
			String[] s = str.split("\\s");
			if(s[0].equals("M")){
				int l = Integer.parseInt(s[1]);
				int m = Integer.parseInt(s[2]);
				obj.union(l, m);
			}
			else{
				int p = Integer.parseInt(s[1]);
				bw.write(String.valueOf(obj.members[obj.findRoot(p)]));
				bw.newLine();
				bw.flush();
				//System.out.println(obj.members[obj.findRoot(p)]);
			}
		}
		
		//bw.write("Siddhant");
		
		bw.close();
		sc.close();
	}
}
