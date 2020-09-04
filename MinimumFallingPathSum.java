// Time Complexity : O(n*m) where n is the row size of the A and M is the column size of A
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] A) {
        //edge case where A is empty or A.length equals 0, return 0
        if(A == null || A.length == 0){
            return 0;
        }
        
        /* j
           1 2 3
         i 4 5 6 
           7 8 9
           */
        //start from the second row and see all the columns
        for(int i=1;i<A.length;i++){
            for(int j=0;j<A[0].length;j++){
                //if it is the first column, then we have to check j, j+1 column as there is no j-1
                if(j == 0){
                    A[i][j] = A[i][j] + Math.min(A[i-1][j], A[i-1][j+1]);
                }else if(j == A.length-1){ //if it is the last column, we check j, j-1 column as there is no j+1
                    A[i][j] = A[i][j] + Math.min(A[i-1][j], A[i-1][j-1]);
                }else{//else we check j-1, j, j+1 columns
                    A[i][j] = A[i][j] + Math.min(Math.min(A[i-1][j-1], A[i-1][j]), A[i-1][j+1]);
                }
            }
        }
        //By the end of the for loop we have the min path sum for each column traversal stored in the last row.
        //So, result will be the minimum of the last row 
        
        int min = Integer.MAX_VALUE;
        for( int j=0; j<A[0].length;j++){
            min = Math.min(min, A[A[0].length-1][j]);
        }
        return min;
    }
}