// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

class SolMinFallingSum {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[] dp = new int[n];

        // copy all elements of last row of the matrix to my array 'dp'
        for(int i=0; i<n; i++){
            dp[i] = matrix[n-1][i];
        }

        // iterate the for loop to traverse from bottom to top in matrix.
        for(int i = n-2; i >= 0 ; i--){

            // updated all the values of array dp by getting the minimum values out of j-1, j & j+1 with help of two variable to store the un-modified value.
            int prevCell = 0;
            for(int j=0; j<n; j++){

                int currCell = dp[j];
                if(j == 0){
                    dp[j] = matrix[i][j]+ Math.min(currCell,dp[j+1]);
                } else {
                    if(j != n-1){
                        dp[j] = matrix[i][j]+ Math.min(currCell, Math.min(prevCell,dp[j+1]));
                    } else {
                        dp[j] = matrix[i][j]+ Math.min(currCell,prevCell);
                    }
                }
                prevCell = currCell;

            }
        }

        // finding the minimum value out of the array.
        int min = dp[0];
        for(int j=1; j<n; j++){
            min = Math.min(dp[j],min);
        }

        return min;
    }
}
