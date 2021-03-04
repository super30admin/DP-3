class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix.length ==0 || matrix == null){
            return 0;
        }
        int n = matrix[0].length;
        
        for(int i=1; i<n; i++){
            for(int j=0; j<n; j++){
               if(j==0){
                   matrix[i][j] += Math.min(matrix[i-1][j], matrix[i-1][j+1]);
               }
                else if(j==matrix.length-1){
                    matrix[i][j] += Math.min(matrix[i-1][j-1], matrix[i-1][j]);
                }
                else
                    matrix[i][j] += Math.min(matrix[i-1][j-1], Math.min(matrix[i-1][j], matrix[i-1][j+1]));
                    
            }
        
        }
           int min = Integer.MAX_VALUE;
            
            for(int j=0; j<n; j++){
               min = Math.min(min, matrix[n-1][j]);
           }
            return min;
        }
    
}
//TC: O(n*n)
//SC: O(1)
