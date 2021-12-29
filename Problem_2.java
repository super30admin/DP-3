// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
//Just start with index 1 and find the min among the value aboue it and add it to present, don't include the n-1 for j == 0 and n + 1 for j == m-1 index.
// Your code here along with comments explaining your approach
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i = 1; i < m; i++){
            for(int j = 0; j < n; j++){
                if(j==0){
                    matrix[i][j] = matrix[i][j]
                            + Math.min(matrix[i-1][j], matrix[i-1][j+1]);
                }else if( j == n-1){
                    matrix[i][j] = matrix[i][j]
                            + Math.min(matrix[i-1][j], matrix[i-1][j-1]);
                }else{
                    matrix[i][j] = matrix[i][j]
                            + Math.min(matrix[i-1][j],
                            Math.min(matrix[i-1][j+1], matrix[i-1][j-1]));
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            min = Math.min(min, matrix[m-1][i]);
        }
        return min;
    }
}