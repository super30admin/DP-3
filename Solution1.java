
//TC : O(n*m)
// SC : O(n*m) 
class Solution1 {
    public int minFallingPathSum(int[][] matrix) {

        //rows
        int n = matrix.length;

        //columns
        int m = matrix[0].length;

        int[][] dp = new int[n][m];
        dp[0] = matrix[0];

        //top down approach. first row as it is
        //for next row calculate  minimum sum for each element
        //column j for i th row
        for(int i =1; i< n; i++) {
            for(int j =0; j<m; j++) {
                int sum =0;
                int min = 0;
                if(j!=0 && j!=m-1){
                    //In the middle elements take minimum from previous row all elements in dp array 
                    min = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i-1][j+1]));
                    sum = matrix[i][j] + min;
                    dp[i][j] = sum;
                } else if(j == 0) {
                    min = Math.min(dp[i-1][j], dp[i-1][j+1]);
                    sum = matrix[i][j] + min;
                    dp[i][j] = sum;
                } else if(j==m-1) {
                    min = Math.min(dp[i-1][j-1], dp[i-1][j]);
                    sum = matrix[i][j] + min;
                    dp[i][j] = sum;
                }
            }
        }

        //Calculate minimum from last row array  dp
        int result = Integer.MAX_VALUE;
        for(int i = 0; i<dp[m-1].length; i++) {
            if(dp[m-1][i]<result) result = dp[m-1][i];
        }

        return result;
    }
}
    