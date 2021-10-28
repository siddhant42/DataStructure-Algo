package dynamic;

public class DecodingWays {
	static int find(String str) {
		if(str==null||str.length()==0) return 0;
		if(str.length()<=1) return 1;
		int[] arr = new int[str.length()+1];
		arr[0] = 1;
		for(int i=1;i<arr.length;i++) {
			if(str.charAt(i-1)!='0')
			arr[i] = arr[i-1];
			if(i>=2 && (str.charAt(i-2)=='1' || str.charAt(i-2)=='2' && str.charAt(i-1)<'7')) 
				arr[i] += arr[i-2];
		}
		return arr[arr.length-1];
	}
	public static void main(String[] args) {
		String str="1111";
		int res = find(str);
		System.out.println(res);
	}
}
