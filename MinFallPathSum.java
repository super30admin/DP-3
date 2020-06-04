// Time Complexity : O(n^2 + n) = O(n^2), where n is the row/col length
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 


class Solution {
    public int minFallingPathSum(int[][] A) {
        if(A[0].length == 1) return A[0][0];  //If 1*1 matrix, return value
        int n = A[0].length;  
        int min = Integer.MAX_VALUE; 
       
        //finds minimum cost path to all elements from row 1, 
        //therefore the last row elements will have minimum cost of valid path from row1 to rown
        for(int i = 1; i < n; i++) { //iterate rows from 1 (row 0 will be fixed)
            for(int j = 0; j < n; j++) { //for each row, choose a col
                if(j == 0){ //for col = 0, only the (row-1,j) and (row-1,j+1) can be selected as valid path
                A[i][j] += Math.min(A[i-1][j], A[i-1][j+1]); //choose the min between (row-1,j) and (row-1,j+1) paths
                }
                else if(j == n-1) { //for col = n-1, only the (row-1,j) and (row-1,j-1) can be selected as valid path
                    A[i][j] += Math.min(A[i-1][j-1], A[i-1][j]);//choose the min between (row-1,j) and (row-1,j-1) paths
                }
                else {//for any other col, (row-1,j-1), (row-1,j) and (row-1,j+1) can be the valid path
                    A[i][j] += Math.min(A[i-1][j],  
                                Math.min(A[i-1][j-1], A[i-1][j+1])); 
                } //choose the min between (row-1,j-1), (row-1,j) and (row-1,j-1) paths
            }
        }

        for(int m = 0; m < n; m++) { //mimimum of the last row is selected
             if(min > A[n-1][m]) {
                 min = A[n-1][m];
             }
         } return min; 

    }
}

