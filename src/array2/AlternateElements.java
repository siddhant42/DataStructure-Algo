package array2;

public class AlternateElements {
	public static void find(int[] a,int[] b,int st1,int st2,int[] c,int idx,int num,boolean f) {
		//if(st1>=a.length || st2>=b.length) return;
		if(!f && idx>0) {
			for(int i=0;i<idx;i++){
				System.out.print(c[i]+" ");
			}
			System.out.println();
		}
		if(!f){
			for(int i=st1;i<a.length;i++) {
				if(num<a[i]) {
					num = a[i];
					c[idx] = num;
					find(a,b,i+1,st2,c,idx+1,num,!f);
				}
			}
		}
		if(f) {
			for(int i=st2;i<b.length;i++) {
				if(f && num<b[i]) {
					num = b[i];
					c[idx] = num;
					find(a,b,st1,i+1,c,idx+1,num,!f);
				}
			}
		}
	}
	public static void find(int[] a1,int[] a2) {
		int[] c = new int[a1.length+a2.length];
		find(a1,a2,0,0,c,0,0,false);
	}
	public static void main(String[] args) {
		int[] a1 = {10,15,25};
		int[] a2 = {1,5,20,30};
		find(a1,a2);
	}
}
