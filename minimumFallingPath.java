/* Time complexity: O((A.length)*(A.length)); where A is the given array
Space complexity: O(n); where n is the number of given elements

1. Using dynamic programming to find the minimum falling path.
2. For each element, the sum at current position is equal to the value at current position plus the value at previous position.
3. The value of the previous position depends on the location of the current element. For an element at corner, previous element would be at previous row, with column number of(j, j+1) and (j-1, j)(j being the column of current element)
and for middle element, it is(j-1, j, j+1) */

class Solution{
    public int minFallingPathSum(int[][] A){
        int n = A.length;
        int dp[][] = new int[n][n];

        for(int i=0; i<n; i++){
            dp[0][i] = A[0][i];
        }

        for(int i=1; i<n; i++){
            for(int j=0; j<n; j++){
                if(j == 0){
                    dp[i][j] = A[i][j] + Math.min(dp[i-1][j], dp[i-1][j+1]);
                }
                else if(j == n-1){
                    dp[i][j] = A[i][j] + Math.min(dp[i-1][j], dp[i-1][j-1]);
                }
                else{
                    dp[i][j] = A[i][j] + Math.min(dp[i-1][j], Math.min(dp[i-1][j+1], dp[i-1][j-1]));
                }
            }
        }
        int minimum = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            if(minimum > dp[n-1][i]){
                minimum = dp[n-1][i];
            }
        }

        return minimum;

    }
}

