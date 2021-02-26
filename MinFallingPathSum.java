class MinFallingPathSum {
    
    // Time Complexity : O(nm)
    // Space Complexity: O(1)
    
    public int minFallingPathSum(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        for(int i = 1; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(j == 0)
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i-1][j], matrix[i-1][j+1]);
                else if(j == matrix[i].length-1)
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i-1][j], matrix[i-1][j-1]);
                else
                    matrix[i][j] = matrix[i][j] + Math.min(Math.min(matrix[i-1][j],matrix[i-1][j-1]),matrix[i-1][j+1]);
            } 
        }
        
        int result = Integer.MAX_VALUE;
        for(int i : matrix[matrix.length-1])
            result = Math.min(result, i);
        
        return result;
    }
}