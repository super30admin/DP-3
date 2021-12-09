public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        if(n == 0) {
            return Integer.MIN_VALUE;
        }

        int min = Integer.MAX_VALUE;
        for(int i = m-2; i>=0; i--) {
            for(int j =0; j<n; j++) {
                if(j==0) {
                    matrix[i][0] = matrix[i][0] + Math.min(matrix[i+1][0], matrix[i+1][1]);

                } else if(j ==n-1){
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j], matrix[i+1][j-1]);
                } else {
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j-1], Math.min(matrix[i+1][j], matrix[i+1][j+1]));
                }
            }
        }

        for(int i =0; i<n; i++) {
            min = Math.min(min, matrix[0][i]);
        }
        return min;
    }
}
