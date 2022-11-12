// Time Complexity : O(n)
// Space Complexity :O(1) same matrix is used to store the ans
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix.length==0) return 0;
        
        int n=matrix.length;
        
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<n;j++){
                if(j==0){
                    //if its the first col then add min of element below it or to diag
                    matrix[i][j]+= Math.min(matrix[i+1][0], matrix[i+1][1]);
                }
                    //if it is last col element then add min of col below it and left diag
                else if(j==n-1){
                     matrix[i][j]+= Math.min(matrix[i+1][n-1], matrix[i+1][n-2]);
                }
                //if it is other than first and last col element , add min between col below it , left and right
                else{
                     matrix[i][j]+= Math.min(matrix[i+1][j-1],Math.min(matrix[i+1][j], matrix[i+1][j+1]));
                }    
            }
        }
        
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            min=Math.min(min, matrix[0][i]);
        }
        return min;
    }
}