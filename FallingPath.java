// Time Complexity : O(mn) where m is the number of rows and n is number of columns
// Space Complexity : O(1) since we are doing the operations in place (each new row is only dependent on the previous row)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Initially, I was not able to model the problem into 2d array. 
/* Your code here along with comments explaining your approach: The first row remains as it is as we can start with any of the 3 possibilities that 
it can either begin with first column to jth column. The next row, I have the option either to choose the same corresponding jth column value, 
or (j-1)th column value or (j+1)th column value to see which of the paths give me the minimum cost. I would put boundary conditions on the j value
at 0 and n-1. I would parse over the last row of the matrix to get the minimum cost. 
*/
class Solution {
    public int minFallingPathSum(int[][] A) {
    if(A == null || A.length == 0){return 0;}
     for(int i = 1 ; i<A.length;i++){
         for(int j = 0; j <A[0].length; j++){
             if(j==0){                                                  // Boundary conditions on j = 0
                A[i][j] += Math.min(A[i-1][j], A[i-1][j+1]);
             } else 
             if(j==A[0].length-1){                                      // Boundary condition on j = n-1
                A[i][j] += Math.min(A[i-1][j-1], A[i-1][j]);
             } else {
                A[i][j] += Math.min(A[i-1][j-1], Math.min(A[i-1][j], A[i-1][j+1]));         // Rest of the case where j can be j-1, j+1 or j itelf
             }
         }
     }
        int n = A.length-1;
        int min = A[n][0];
        for(int i = 0; i < A[0].length;i++){                    // Parsing over the last row to get the minimum element 
                if(A[n][i] < min){
                    min = A[n][i];  
                }
            }
        return min;
     }
}
}