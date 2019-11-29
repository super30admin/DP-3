/**
LeetCode Submitted : YES
Time Complexity : O(N^2)
Space Complexity : O(N^2)

The idea is to replicate house paint problem and populate min across each position by referring to available sum in previous row by handling boundary conditions

**/


class Solution {
    public int minFallingPathSum(int[][] A) {
     
        if(A == null || A.length == 0)
            return 0;
        
        int row = A[0].length;
        int col = A.length;
        
        //int[][] paths = new int[row][col];
        
        //Create Paths will possible sum 
        for(int i = 0; i< row; i++){
            for(int j = 0; j<col;j++){
                if(i == 0){
                    //Store path sum as it is
                //    paths[i][j] = A[i][j];
                    continue;
                }
                else if(j == 0){ //First Column
                    A[i][j] = A[i][j] + Math.min(A[i-1][j],A[i-1][j+1]);
                }else if(j == col-1){ //Last Column
                    A[i][j] =  A[i][j] + Math.min(A[i-1][j-1],A[i-1][j]);
                    
                }
                else{
                    A[i][j] = A[i][j] + Math.min(A[i-1][j-1],Math.min(A[i-1][j],A[i-1][j+1]));
                }
                
            }
        }
        
        //Calculate min of last row
        int min = A[row-1][0];
        for(int j = 1;j<col;j++){
            if(min > A[row-1][j])
                min = A[row-1][j];
        }
        
        return min;
        
        
        
    }
}
