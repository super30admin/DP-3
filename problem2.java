// Time Complexity : O(n^2)
// Space Complexity : O(1) // no extra space used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach: I need to go to the bottom for each start, so I start with second to last row and update each index with the minimum it can be - compare left down and right and add it to the value at the index. When I am at first row, at each index I have options of left right and down which are already representing the minimum value I could get when I go down that path. So I keep a track of min only for the first row and return it. 

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int res = Integer.MAX_VALUE;
        if(n==1) for(int i = 0; i<n; i++) res = Math.min(res, matrix[0][i]);
        for(int i = n-2; i>=0; i--){
            for(int j = 0; j<n; j++){
                int down = matrix[i+1][j];
                int leftDiag = j-1>=0?matrix[i+1][j-1]:Integer.MAX_VALUE;
                int rightDiag = j+1<n?matrix[i+1][j+1]:Integer.MAX_VALUE;
                matrix[i][j] = matrix[i][j] + Math.min(down, Math.min(leftDiag, rightDiag));
                if(i==0) res = Math.min(res, matrix[i][j]);
            }
        }
        return res;
    }
}