// Time Complexity : O(m) where m = number of rows
// Space Complexity : O(n) where n = number of columns
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class Problem2 {
    
    public static int minFallingPathSum(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int[] prev = matrix[0];
        for (int i = 1; i < rows; i++) {
            int[] curr = new int[cols];
            for (int j = 0; j < cols; j++) {
                // Calculate minimum falling sum till each index in the curr array
                if (j == 0) {
                    curr[j] = matrix[i][j] + Math.min(prev[j], prev[j+1]);
                } else if (j == cols-1) {
                    curr[j] = matrix[i][j] + Math.min(prev[j-1], prev[j]);
                } else {
                    curr[j] = matrix[i][j] + Math.min(prev[j-1], Math.min(prev[j], prev[j+1]));
                }
            }
            // Set prev to curr
            prev = curr;
        }
        
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < cols; j++) {
            ans = Math.min(ans, prev[j]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
        int ans = minFallingPathSum(matrix);
        System.out.println(ans);
    }

}
