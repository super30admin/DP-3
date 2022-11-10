/*
    Time Complexity = O(n2) //iterating over n2 matrix
    Space Complexity = O(1) //mutating given matrix only
    Did this code successfully run on Leetcode : yes
 */

package com.madhurima;

public class MinimumFallingPathSum {
}

class SolutionA {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return 0;
        }

        int n = matrix.length;
        //n-1 -> last row, n-2 -> 2nd last row (we start here)
        //from down to up, fill up matrix
        //if leftmost and rightmost cell, only two choices. Else, 3 choices.

        for(int i = n-2; i >=0; i--){
            for(int j = 0; j < n; j++){
                if(j == 0){
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j], matrix[i+1][j+1]);
                }else if(j == n-1){
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j], matrix[i+1][j-1]);
                }else{
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j], Math.min(matrix[i+1][j-1], matrix[i+1][j+1]));
                }
            }
        }

        //return min from 0th row
        int min = Integer.MAX_VALUE;
        for(int j = 0; j < n; j++){
            min = Math.min(min, matrix[0][j]);
        }

        return min;

    }

    public static void main(String[] args) {
        SolutionA s = new SolutionA();
        int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
        System.out.println(s.minFallingPathSum(matrix));
    }
}
