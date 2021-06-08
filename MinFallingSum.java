class Solution {
	public int minFallingPathSum(int[][] A)
    {
	int n=A.length;
	int m=A[0].length;
	int[][] dp=new int[n][m];
	for(int i=0;i<m;i++)
	{
		dp[n-1][i]=A[n-1][i];//fill in the last row of the new array with the elements of the given array
    }
    for(int i=n-2;i>=0;i--)
    {
	    for(int j=0;j<m;j++)
        {
	        dp[i][j]=A[i][j];//put the second last row and first column element of the given array in the second last row first column of the new array
	        int mn= dp[i+1][j];
	        if(j+1<m)
            {
	            dp[i][j]= Math.min(mn,dp[i+1][j+1]);//if there is an element in the bottom row to the right then store the minimum of the element below and the element to the right of the below element 	
            }
            if(j-1>=0)
            {
	            dp[i][j]=Math.min(mn, dp[i+1][j-1]);// similarly if there are  elements to the left then store the minimum of the left and below element.
            }
            dp[i][j]+=mn; 
        }
    }
    int res=Integer.MAX_VALUE;
    for(int i=0;i<m;i++)
    {
	    res=Math.min(res, dp[0][i]);//after iterating through the loops choose the minimum of the elements in the top row.
    }
    return res;
    }
}
