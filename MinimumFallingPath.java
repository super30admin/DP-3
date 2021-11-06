class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++)
            for(int j=0;j<matrix[0].length;j++)
                dp[i][j]=-1;
        int min = Integer.MAX_VALUE;
        for(int k=0;k<matrix[0].length;k++)
            min=Math.min(min, helper(matrix,dp,matrix.length-1,k));
        return min;

    }

    public static int helper(int[][] matrix, int dp[][], int i, int j){
        if(dp[i][j]!=-1)
            return dp[i][j];
        if(i==0){
            dp[i][j]=matrix[i][j];
            return matrix[i][j];
        }
        int min = Integer.MAX_VALUE;
        for(int k=j-1;k<=j+1;k++){
            if(k==-1 || k==matrix[0].length)
                continue;
            min=Math.min(min, matrix[i][j]+helper(matrix,dp,i-1,k));
        }
        dp[i][j]=min;
        return min;
    }
}