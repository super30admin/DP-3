// Time Complexity : O(n^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class FallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<n;j++){
                if(j==0){
                    matrix[i][j] += Math.min(matrix[i+1][j], matrix[i+1][j+1]);
                }
                else if(j==n-1){
                    matrix[i][j] += Math.min(matrix[i+1][j-1], matrix[i+1][j]);
                }
                else{
                    matrix[i][j] += Math.min(matrix[i+1][j-1], Math.min(matrix[i+1][j],matrix[i+1][j+1]));
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(min>matrix[0][i]){
                min = matrix[0][i];
            }
        }
        return min;
    }

    public static void main(String[] args){
        int[][] matrix = {{2, 1, 3}, {6, 5, 4}, {7, 8, 9}};
        FallingPathSum fps = new FallingPathSum();
        System.out.println(fps.minFallingPathSum(matrix));
    }
}