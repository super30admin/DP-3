
public class Minimum_Falling_Path_Sum {
	 public int minFallingPathSum(int[][] A) {
		//Approach: 1. Using dp approach, we can calculate the minimum falling path sum, we initiailize the dp matrix with value from the initial row.
		 //2. then for each element of the dp matrix we calculate the possibilities of taking that element and not taking it. Here we consider 3 cases, initial element, edge element and others.
		 //3. For edge case elements we have only two options of choosing value from previous optimal solutions and we will take the minimum of it, whereas for others we will choose minimum from 3 elements and fill the dp matrix.
		 //4. Finally, we return the minimum of the last row in dp matrix.
        int length = A.length;
        int[][] dp =  new int[A.length][A.length];
        for(int i=0;i<A.length;i++)
        {
           dp[0][i]=A[0][i];
        }
        
        for(int i=1; i< A.length;i++)
        {
            for(int j=0; j< A.length;j++)
            {
                if(j==0)
                {
                    dp[i][j] = A[i][j] + Math.min(dp[i-1][j], dp[i-1][j+1]);
                }else if(j == A.length-1)
                {
                    dp[i][j] = A[i][j] + Math.min(dp[i-1][j], dp[i-1][j-1]);
                }else
                {
                    dp[i][j] = A[i][j] + Math.min(Math.min(dp[i-1][j], dp[i-1][j-1]), dp[i-1][j+1]);
                }
            }
        }
        
        int min = Integer.MAX_VALUE;
        for(int i=0;i<A.length;i++)
        {
            if(min > dp[length-1][i])
                min = dp[length-1][i];
        }
        
        return min;
    }
}

//Time Complexity : O(n * n ), where n is the size of the array A 
//Space Complexity : O(n * n ) for construction of dp matrix where n is the size of the array.
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :