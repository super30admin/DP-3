// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes https://leetcode.com/problems/delete-and-earn/
// Any problem you faced while coding this : -

/*
Problem::: Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.
A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right. Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).
Solution::: DP-  Use bottom up approach to solve */
public class MinFallingPath {
    public int minFallingPathSum(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int[][] temp = new int[row][col];

        //Fill last row of temp with actual values
        for(int i=0; i< col; i++){
            temp[row -1][i] = matrix[row -1][i];
        }

        for(int i=row -2 ;i>=0;i--){
            for(int j=0; j<col; j++){
                if(j==0)
                {
                    temp[i][j] = matrix[i][j]+ Math.min(temp[i+1][j], temp[i+1][j+1]);
                }
                else if(j==matrix[0].length -1)
                    temp[i][j] = matrix[i][j]+ Math.min(temp[i+1][j], temp[i+1][j-1]);
                else
                    temp[i][j] = matrix[i][j]+ Math.min(temp[i+1][j], Math.min(temp[i+1][j-1],temp[i+1][j+1]));

            }

        }
        int min = temp[0][0];
        for(int i=0; i<col; i++){
            min = Math.min(temp[0][i], min);
        }


        return min;
    }
}
