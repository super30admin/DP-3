//time-O(m*n)
//space-O(1)
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix==null || matrix.length==0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int sum = Integer.MAX_VALUE;

        for(int row=m-2; row>=0; row--){
            for(int col=0; col<n; col++){
                int behind = col==0 ? Integer.MAX_VALUE : matrix[row+1][col-1];
                int below = matrix[row+1][col];
                int infront = col==n-1 ? Integer.MAX_VALUE : matrix[row+1][col+1];
                matrix[row][col] += Math.min(behind, Math.min(below, infront));
            }
        }

        for(int i=0; i<n; i++){
            sum = Math.min(sum, matrix[0][i]);
        }

        return sum;
    }
}