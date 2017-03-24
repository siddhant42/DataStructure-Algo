package array2;

public class StockProblem {
	public static void find(int[] a) {
		if(a==null ||a.length==0||a.length==1) return;
		int sIdx=0,eIdx=0,n=a.length;
		boolean b = false;
		for(int i=1;i<n;i++) {
			if(a[i]>a[i-1]) {
				eIdx=i;
				if(i==n-1) {
					if(!b) b = true;
					System.out.println("buy at day "+sIdx+" sell at day "+eIdx);
				}
			}
			else {
				if(eIdx>sIdx) {
					if(!b) b = true;
					System.out.println("buy at day "+sIdx+" sell at day "+eIdx);
				}
				sIdx=eIdx=i;
			}
		}
		if(!b) 
			System.out.println("There is no such comb. of days to get profit by buying and selling");
	}
	public static void main(String[] args) {
		int[] a = {100, 180, 260, 310, 40, 535, 695};
		find(a);
		find(new int[]{5,4});
	}
}
