// Time Complexity : O(n^2) where n is number of rows and columns
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Had to revise basic syntax

// ## Problem2 (https://leetcode.com/problems/minimum-falling-path-sum/)
// Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.
// A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right.
// Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).

// Example 1:
// Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
// Output: 13
// Explanation: There are two falling paths with a minimum sum as shown.

// Example 2:
// Input: matrix = [[-19,57],[-40,-5]]
// Output: -59
// Explanation: The falling path with a minimum sum is shown.

// Constraints:
// n == matrix.length == matrix[i].length
// 1 <= n <= 100
// -100 <= matrix[i][j] <= 100

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        // Base case: matrix is null or empty
        if (matrix == null || matrix.length == 0){
            return 0;
        }
        int n = matrix.length;

        // Starting from second last row and going upward
        for (int i = n - 2; i >= 0; i--){
            for (int j = 0; j < n; j++){
                if (j == 0){ // If in first column => going down or down-right only
                    matrix[i][j] += Math.min(matrix[i + 1][j], matrix[i + 1][j + 1]);
                }
                else if (j >= n - 1){ // If in last column => going down or down-left only
                    matrix[i][j] += Math.min(matrix[i + 1][j], matrix[i + 1][j - 1]);
                }
                else{ // Else => going down, down-left or down-right
                    matrix[i][j] += Math.min(matrix[i + 1][j], 
                        Math.min(matrix[i + 1][j + 1], matrix[i + 1][j - 1]));
                }
                
            }
        }

        // Calculating minimum value in the first row and returning the result
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++){
            min = Math.min(min, matrix[0][i]);
        }

        return min;
    }
}