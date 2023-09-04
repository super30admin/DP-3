class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int minpath = Integer.MAX_VALUE;

        if(m==0) return 0;

        for(int i= m-2; i>=0; i--){
            for(int j=0; j<n; j++){
                if(j==0){
                    matrix[i][j] += Math.min(matrix[i+1][j], matrix[i+1][j+1]);
                   

                }
                else if(j==n-1){
                     matrix[i][j] += Math.min(matrix[i+1][j], matrix[i+1][j-1]);
                     
                }
                else{
                     matrix[i][j] += Math.min(matrix[i+1][j-1], Math.min(matrix[i+1][j],matrix[i+1][j+1]));
                    
                }
            }
        }
       
       for(int j=0; j<n;j++){
         minpath = Math.min(matrix[0][j], minpath);
       }
       return minpath;
    }
}




/**

TC : O(m*n) --> Iterating through the matrix.

SC : O(1) --> Not using any extra space.

Description : It is similar to pain house, caliculating from down and finding minimum in the top row.

 */