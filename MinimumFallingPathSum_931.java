// Time Complexity : O(n * n );
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class MinimumFallingPathSum_931 {
    public int minFallingPathSum(int[][] matrix) {
        
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return -1;
        }
        
        int n = matrix.length;
        
        for(int i=1;i<n ;i++){
            for(int j=0;j<n;j++){
                
                if(j==0){
                    matrix[i][j]= matrix[i][j] + Math.min(matrix[i-1][j],matrix[i-1][j+1]);
                } else if(j==n-1){
                    matrix[i][j]= matrix[i][j] + Math.min(matrix[i-1][j],matrix[i-1][j-1]);
                } else {
                    matrix[i][j]= matrix[i][j] + Math.min(Math.min(matrix[i-1][j],matrix[i-1][j-1]),matrix[i-1][j+1]);
                }
            }  
        }
        
        int min = matrix[n-1][0];
        
        for(int i=1;i<n;i++){
            min = Math.min(min,matrix[n-1][i]);
        }
        
        return min;
        
    }
}