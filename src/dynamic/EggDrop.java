package dynamic;

public class EggDrop {
	public static void main(String[] args) {
		int n=2,k=100;
		System.out.println(new EggDrop().eggDrop(n,k));
	}

	private int find(int n, int k) {
		if(k==1||k==0) return k;
		if(n==1) return k;
		int min=Integer.MAX_VALUE;
		for(int x=1;x<=k;x++){
			int max= Math.max(find(n-1,x-1), find(n,k-x));
			if(min>max){
				min=max;
				//System.out.println(min);
		}}
		return min+1;		
	}
	int eggDrop(int n, int k)
	{
	    /* A 2D table where entery eggFloor[i][j] will represent minimum
	       number of trials needed for i eggs and j floors. */
	    int eggFloor[][]=new int[n+1][k+1];
	    int res;
	    int i, j, x;
	 
	    // We need one trial for one floor and0 trials for 0 floors
	    for (i = 1; i <= n; i++)
	    {
	        eggFloor[i][1] = 1;
	        eggFloor[i][0] = 0;
	    }
	 
	    // We always need j trials for one egg and j floors.
	    for (j = 1; j <= k; j++)
	        eggFloor[1][j] = j;
	 
	    // Fill rest of the entries in table using optimal substructure
	    // property
	    for (i = 2; i <= n; i++)
	    {
	        for (j = 2; j <= k; j++)
	        {
	            eggFloor[i][j] = Integer.MAX_VALUE;
	            for (x = 1; x <= j; x++)
	            {
	                res =  Math.max(eggFloor[i-1][x-1], eggFloor[i][j-x]);
	                if (res < eggFloor[i][j])
	                    eggFloor[i][j] = 1 +res;
	            }
	        }
	    }
	 
	    // eggFloor[n][k] holds the result
	    return eggFloor[n][k];
	}
}
