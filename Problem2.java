//Accepted on LT
//Did dp cheacklist took my ds as a matrix and formed a pattern to keep a track of max sum
//Time should be O(mn) where m and n size of matrix

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[m][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0){
                    dp[i][j]= matrix[i][j];
                }
                else{
                    int minPrev = Integer.MAX_VALUE;
                    if(j-1<0){
                        minPrev = Math.min(dp[i-1][j], dp[i-1][j+1]);
                    }
                    else if(j+1>m-1){
                        minPrev = Math.min(dp[i-1][j], dp[i-1][j-1]);
                    }
                    else{
                        minPrev = Math.min(dp[i-1][j], Math.min(dp[i-1][j+1],dp[i-1][j-1]));
                    }


                   

                    dp[i][j] = minPrev + matrix[i][j];

                }
                if(i==n-1){
                    if(min>dp[i][j]){
                        min = dp[i][j];
                    }
                }
            }
        }

        return min;

        
    }
}