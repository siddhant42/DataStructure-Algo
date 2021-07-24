package com.test;

public class S16 {
	static class Job {
		int ST,ET,val;

		public Job() {
			super();
		}

		public Job(int sT, int eT, int val) {
			super();
			ST = sT;
			ET = eT;
			this.val = val;
		}
	}
	public int find(Job[] jobs) {
		if(jobs==null || jobs.length==0) return 0;
		return find(jobs,0,0);
	}
	private int find(Job[] jobs,int ET,int st) {
		if(st==jobs.length) return 0;
		int sum=0,maxsum=0;
		for(int i=st;i<jobs.length;i++) {
			if(jobs[i].ST>=ET)
			sum=jobs[i].val+find(jobs,jobs[i].ET,i+1);
			if(maxsum<sum) maxsum = sum;
		}
		return maxsum;
	}
	public static void main(String[] args) {
		int n=4;
		Job[] jobs = new Job[n];
		jobs[0] = new Job(1,2,50);
		jobs[1] = new Job(3,5,20);
		jobs[2] = new Job(6,19,100);
		jobs[3] = new Job(2,100,200);
		System.out.println(new S16().find(jobs));
	}
}
