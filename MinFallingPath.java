class Solution {

    /* Time Complexity :O(n^2)
    Space Complexity: O(1)
    Executed in leetcode
     */
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int minPath = Integer.MAX_VALUE;
        if (n ==1) return matrix[0][0];

        for (int i =1; i<n;i++){
            for (int j = 0; j<n; j++){
                if (j ==0){
                    matrix[i][j] += Math.min(matrix[i-1][0], matrix[i-1][1]);
                }else if (j == n-1){
                    matrix[i][j] += Math.min(matrix[i-1][j], matrix[i-1][j-1]);
                }else{
                    matrix[i][j] += Math.min(matrix[i-1][j-1], Math.min(matrix[i-1][j], matrix[i-1][j+1]));
                }
                if (i == n-1){
                    minPath = Math.min(minPath, matrix[i][j]);
                }
            }

        }
        return minPath;
        
    }
}