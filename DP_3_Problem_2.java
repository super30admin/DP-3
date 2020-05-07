//Time Complexity : O(n)
//Space Complexity: O(1)
//Wont run for colums > 3
//Problem : Could not figure out solution for more than 3 columns


public class DP_3_Problem_2 {
    public int minFallingPathSum(int[][] A) {
        if(A==null || A.length == 0 ) return 0;
        else if(A.length==1) {
            int min = Integer.MAX_VALUE;
            for(int i =0 ; i < A[0].length ; i++)
            {
                if(A[0][i]<min)
                {
                    min = A[0][i];
                }
            }
            return min;
        }
        int dp[][] = new int[A.length][A[0].length];
        dp[0] = A[0];
        for(int i=1;i<dp.length;i ++)
        {
            for(int j=0; j < dp[0].length ; j++)
            {
                dp[i][j] = A[i][j] + Math.min(A[i-1][(j+1)%3],A[i-1][(j+2)%3]);
            }
        }
        return Math.min(dp[dp.length-1][0],Math.min(dp[dp.length-1][1],dp[dp.length-1][2]));

    }
}
