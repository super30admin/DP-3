//Time complexity: O(m*n)+O(nlogn)
//Space complexity: O(m*n)

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m=matrix.length; int n=matrix[0].length;
        int dp[][]=new int[m][n];
        for(int j=0;j<n;j++)
        {
            dp[0][j]=matrix[0][j];
        }
        for(int i=1;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(j==0)
                dp[i][j]=matrix[i][j]+Math.min(dp[i-1][j],dp[i-1][j+1]);
                else if(j>0 && j<n-1)
                {
                    int a= Math.min(dp[i-1][j],dp[i-1][j+1]);
                    int b=Math.min(a, dp[i-1][j-1]);
                    dp[i][j]=matrix[i][j]+b;
                }
                else if(j==n-1)
                    dp[i][j]=matrix[i][j]+Math.min(dp[i-1][j],dp[i-1][j-1]);
            }
        }
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]= dp[m-1][i];
        }
        Arrays.sort(arr);
        return arr[0];
        
    }
}