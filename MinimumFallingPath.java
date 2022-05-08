// Time Complexity : O(n*m) where n is the number of rows and m is the number of columns
// Space Complexity : O(m) where m is the number of columns
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : did not take a temp array to store initially, and ended up with wrong calculations.


// Your code here along with comments explaining your approach

public class MinimumFallingPath {
    public int minFallingPathSum(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int[] dp = new int[c];
        int[] temp = new int[c];

        // base case, dp explores all columns, in the end, we return minimum in this
        for(int i=0; i<c; i++){
            dp[i] = matrix[0][i];
        }

        for(int i=1; i<r; i++){
            for(int j=0; j<c; j++){ // add the min path, sum till previous row is stored in dp. Check adjacent sums, choose the minimum
                if(j==0){
                    temp[j] = matrix[i][j]+ Math.min(dp[j], dp[j+1]);
                }
                else if(j==c-1){
                    temp[j] = matrix[i][j]+ Math.min(dp[j-1], dp[j]);
                }
                else{
                    temp[j] = matrix[i][j]+ Math.min(dp[j-1], Math.min(dp[j], dp[j+1]));
                }
            }
            // stored the values in temp as we might overright the dp during the iteration
            for(int j=0; j<c; j++){
                dp[j] = temp[j]; // copy it back
            }
        }
        int min = dp[0];
        for(int i=1; i<c; i++){
            if(dp[i]<min){
                min=dp[i];
            }
        }
        return min; // minimum path sum in dp
    }
}
