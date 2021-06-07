class MinFallingPathSum{
    public int minFallingPathSum(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int n = matrix.length;


        for(int i = 1; i<n; i++){
            for(int j=0; j<n; j++){
                if(j==0)
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i-1][j], matrix[i-1][j+1]);
                else if(j== n - 1)
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i-1][j-1], matrix[i-1][j]);
                else
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i-1][j-1], Math.min(matrix[i-1][j], matrix[i-1][j+1]));
            }
        }

        int min = Integer.MAX_VALUE;
        for(int j=0; j<matrix.length; j++){
            min = Math.min(min, matrix[matrix.length-1][j]);
        }
        return min;
    }

//    public int minFallingPathSum(int[][] matrix) {
//        int min = Integer.MAX_VALUE;
//        for(int i=0; i<matrix[0].length; i++){
//            min = Math.min(min, helper(matrix, 0, i, 0));
//        }
//        return min;
//    }
//
//    private int helper(int[][] matrix, int row, int col, int minSum){
//        //base
//        if(row == matrix.length)
//            return minSum;
//
//        int case1 = Integer.MAX_VALUE;
//        int case2 = Integer.MAX_VALUE;
//        int case3 = Integer.MAX_VALUE;
//        //logic
//        if(col-1>=0 && col+1<matrix.length){
//            case1 = helper(matrix, row+1, col-1, matrix[row][col] + minSum);
//            case2 = helper(matrix, row+1, col, matrix[row][col] + minSum);
//            case3 = helper(matrix, row+1, col+1, matrix[row][col] + minSum);
//        }
//
//        else if(col-1 < 0){
//            case2 = helper(matrix, row+1, col, matrix[row][col] + minSum);
//            case3 = helper(matrix, row+1, col+1, matrix[row][col] + minSum);
//        }
//
//        else {
//            case1 = helper(matrix, row+1, col-1, matrix[row][col] + minSum);
//            case2 = helper(matrix, row+1, col, matrix[row][col] + minSum);
//        }
//
//        return Math.min(case1, Math.min(case2, case3));
//    }
}