public int minFallingPathSum(int[][] matrix) {
    int m=matrix.length;
    int n=matrix[0].length;
    int[][] dp=new int[m][n];
    for(int j=0;j<n;j++)
        dp[0][j]=matrix[0][j];
    for(int i=1;i<m;i++){
        for(int j=0;j<n;j++){
            dp[i][j]=dp[i-1][j];
            if(j-1>=0)
                dp[i][j]=Math.min(dp[i-1][j-1],dp[i][j]);
            if(j+1<=n-1)
                dp[i][j]=Math.min(dp[i-1][j+1],dp[i][j]);
            dp[i][j]+=matrix[i][j];
        }
    }
    
    int maxNumber=dp[m-1][0];
    for(int item:dp[m-1]){
        maxNumber=Math.min(maxNumber,item);
    }
    return maxNumber;

}