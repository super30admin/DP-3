class Solution {
    int min = Integer.MAX_VALUE;
    public int minFallingPathSum(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int m= matrix.length;
        int n=matrix[0].length;
        if(m == 1) return matrix[0][0];
        for(int i=1 ; i<m;i++){    
            for(int j=0; j<n; j++){
                
                if(j==0){
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i-1][j], matrix[i-1][j+1]);
                }else if(j == n-1){
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i-1][j], matrix[i-1][j-1]);
                }else{
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i-1][j], Math.min(matrix[i-1][j+1], matrix[i-1][j-1]));
                }             
                
            }
        }  
        
        for(int i=0; i < n; i++){
            min = Math.min(min, matrix[m-1][i]);
        }
    return min;
    }
    
}
