/**
Problem: Minimum Falling path
Time Complexity: O(n^2) where n is the length of the square(n*n) array
Space Complexity: O(1) as we are modifying the array in place

Approach: Dynamic Programming
1. Since, we are allowed to choose the next element in the next row, that differs atmost by 1, we are left with just 3 choices.
2. At every row, we choose the minimum among the element below it, or, the element to the left of it in the next row, or the element to the right of it in the next row.
3. We fill up the entire matrix accordingly and then we take the minimum of the last row.
4. This minimum is the min sum of the falling path.
 */


class Solution {
    public int minFallingPathSum(int[][] A) {
        for(int i = 1; i<A.length; i++) {
            for(int j = 0; j<A.length;j++) {
                if(j == 0) { //first column
                    A[i][j] += Math.min(A[i-1][j], A[i-1][j+1]); 
                }
                else if(j==A.length-1) { //last column
                    A[i][j] += Math.min(A[i-1][j], A[i-1][j-1]);
                }
                else //all other columns in between
                    A[i][j] += Math.min(Math.min(A[i-1][j], A[i-1][j-1]), A[i-1][j+1]);
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < A.length; i++) { //find the minimum of the last row
            if(A[A.length-1][i] < min) {
                min = A[A.length-1][i];
            }
        }
        return min;
    }
}