// Time Complexity : O(r*c)
// Space Complexity :O(c)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : yes, the core algorith of taking min from prev row was crucial


// Your code here along with comments explaining your approach
/*
We need to take minimum of the previous valid path to create a minimum path
we will take first row and fill in dp and start from the second row in matrix
we will see which value is min from the previous valid path and we will add it
*/

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        //O(c) space
        int[] dp =  new int[matrix[0].length];// we only need one row, this would contain the minim sum at each column

        //filling the dp with first row
        for(int c=0;c<dp.length;c++){
            dp[c] = matrix[0][c];
        }

        int[] temp = new int[matrix[0].length]; // temp array to hold the state

        //O(rc) time
        for(int row=1;row<matrix.length;row++){ 
            for(int col=0;col<matrix[0].length;col++){
                // Check from previous row, which dp is holding
                // go up
               int up = Integer.MAX_VALUE;
                if(isValid(row-1,col,matrix)){
                up = dp[col];
                }
                
                 int left = Integer.MAX_VALUE;
                //go upper left
                if(isValid(row-1,col-1,matrix)){
                    left = dp[col-1];
                }
                
                //go upper right
                int right = Integer.MAX_VALUE;
                if(isValid(row-1,col+1,matrix)){
                    right = dp[col+1];
                }

                temp[col] = Math.min(up,left);
                temp[col] = Math.min(temp[col],right);
                temp[col] += matrix[row][col];

            }
            // copying temp to dp
            for(int col = 0;col<dp.length;col++){
                dp[col]=temp[col];
            }
        }

        int minimum = Integer.MAX_VALUE;

        for(int i=0;i<dp.length;i++){
            minimum = Math.min(minimum,dp[i]);
        }

        return minimum;
    }

    private boolean isValid(int row, int col, int[][] matrix){
        if(row >= 0 && row <matrix.length && col>=0 && col<matrix[0].length){
            return true;
        }
        return false;
    }


}