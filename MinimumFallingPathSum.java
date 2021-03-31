public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        /*
        
        Thought Process:
        
        Falling down, we calculate the minimum of above neighbors and add to self. 
        When we reach last row, return min of all last row elements.
        
        TC -> O(M*N) Looping through the matrix
        SC -> O(1) as we will use the same matrix to store the calculations
        
        */
        
        int min = Integer.MAX_VALUE;
        if(matrix==null || matrix.length==0) return min;
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        for(int i=1; i<m; i++){
            for(int j=0; j<n; j++){
                if(j==0){
                    matrix[i][j] += Math.min(matrix[i-1][j], matrix[i-1][j+1]);
                }
                else if(j==n-1){
                    matrix[i][j] += Math.min(matrix[i-1][j], matrix[i-1][j-1]);
                }else{
                    matrix[i][j] += Math.min(matrix[i-1][j], Math.min(matrix[i-1][j+1],matrix[i-1][j-1]));
                }
            }
        }
        for(int j=0; j<n;j++){
            min = Math.min(min, matrix[m-1][j]);
        }
        return min;
    }
}
