package dynamic2;

public class MaxSumRectangle {

	public static void main (String[] args) throws java.lang.Exception
	{
		findMaxSubMatrix(new int[][] {
			{1, 2, -1, -4, -20},
			{-8, -3, 4, 2, 1},
			{3, 8, 10, 1, 3},
			{-4, -1, 1, 7, -6}
		});
	}
	private static int[] findMaxInCol(int[] a) {
		int[] result = new int[]{Integer.MIN_VALUE,0,0};
		int currMax=0,sIdx=0,eIdx=0;
		for(int i=0;i<a.length;i++) {
			currMax+=a[i];
			if(currMax<a[i]) {
				currMax=a[i];
				if(result[0]<currMax){
					result[0]=currMax;
				sIdx=i;eIdx=i;
				}
			}
			else if(result[0]<currMax) {
				result[0]=currMax;
				eIdx=i;
			}
		}
		result[1]=sIdx;
		result[2]=eIdx;
		return result;
	}
	public static void findMaxSubMatrix(int[][] a) {
		int rows = a.length,cols = a[0].length;
		int maxSum=Integer.MIN_VALUE;
		int left=0,right=0,top=0,bottom=0;
		int[] result;
		for(int leftCol=0;leftCol<cols;leftCol++) {
			int[] tmp = new int[rows];
			for(int rightCol=leftCol;rightCol<cols;rightCol++) {
				for(int i=0;i<rows;i++)
					tmp[i]+=a[i][rightCol];
				result=findMaxInCol(tmp);
				if(maxSum<result[0]) {
					maxSum=result[0];
					left = leftCol;
					right=rightCol;
					top = result[1];
					bottom=result[2];
				}
			}
		}
		System.out.println("Maxsum "+maxSum+" Range ("+left+","+top+"),("+right+","+bottom+")");
	}
}
