package array;

public class SearchMatrix {
	public static void main(String[] args) {
		int a[][] = { 
				{1, 2, 3, 4, 5},
	            {6, 7, 8, 9, 10},
	            {11,12,13,14,15},
	            {16,17,18,19,20},
	            {21,22,23,24,25},
	            {26,27,28,29,30}
	    };
new SearchMatrix().find(a,0,4,5,4,30);
}
	void find(int[][] a,int i,int j,int m,int n,int key){
		if(i>m||j>n){
			System.out.println("key is not found in the given array");
			return;
		}
		else{
			int pivot=a[i][j];
			if(pivot==key){
				System.out.println("key is found at row= "+(i+1)+" and column= "+(j+1));
				return;}
				else if(key>a[i][j])
					find(a,i+1,j,m,n,key);
				else
					find(a,i,j-1,m,n,key);
			}
		}
	}

