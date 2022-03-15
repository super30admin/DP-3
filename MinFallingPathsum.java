class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n= matrix.length;
        int k= matrix[0].length;
        
        int min= Integer.MAX_VALUE;
        
        for(int i=1; i<n; i++){
            int next_min= Integer.MAX_VALUE;
            for(int j=0; j<k; j++){
                if(j==0 ) {
                     matrix[i][j]= matrix[i][j]+Math.min(matrix[i-1][j], matrix[i-1][j+1]);
                }
                else if(j==k-1 ) {
                     matrix[i][j]= matrix[i][j]+Math.min(matrix[i-1][j], matrix[i-1][j-1]);
                }
                else {
                    int smallest = matrix[i-1][j];
                    if (smallest > matrix[i-1][j-1]) smallest = matrix[i-1][j-1];
                    if (smallest > matrix[i-1][j+1]) smallest = matrix[i-1][j+1];
                    matrix[i][j]= matrix[i][j]+ smallest;
                } 
            }
         
        }
        int minn= Integer.MAX_VALUE;
        for(int i=0; i<k; i++){
            minn= Math.min(minn, matrix[n-1][i]);
        }
       return minn; 
    }
}

//time complexity- O(m*n)
//space complexity- O(m*n)