// Time Complexity : O(n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
class MinFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        for(int i=1;i<matrix.length;i++){
            for(int j =0;j<matrix[0].length;j++){
                if(j ==0){
                    matrix[i][j] += Math.min(matrix[i-1][j], matrix[i-1][j+1]);
                }else if(j == matrix[0].length-1){
                    matrix[i][j] += Math.min(matrix[i-1][j-1], matrix[i-1][j]);
                }else{
                    matrix[i][j] += Math.min(matrix[i-1][j-1], Math.min(matrix[i-1][j], matrix[i-1][j+1]));
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i : matrix[matrix.length-1]) min =Math.min(min, i);
        return min;
    }
}