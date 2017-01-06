package recursion;

public class Permute3 {
	public static void main(String[] args) {
		int n=4;
		//int[] a={1,2,3,4};
		String str="1234";
		int[] data = new int[n];
		new Permute3().find(str,0,n,data);
	}

	private void find(String str, int idx, int end, int[] data) {
		if(idx==end){
			for(int i:data)
				System.out.print(i+" ");
			System.out.println();
			return;
		}
		for(int i=0;i<str.length();i++){
			int k =Integer.parseInt(String.valueOf(str.charAt(i)));
			if(idx==0 || (idx+1)%k==0 || k%(idx+1)==0){
				data[idx] = k;
				find(str.substring(0,i)+str.substring(i+1,str.length()),idx+1,end,data);
			}
		}
	}
}
