/*
class Solution:
    def minFallingPathSum(self, A: List[List[int]]) -> int:
        if A is None or len(A) == 0:
            return 0
        min_value = float('inf')
        rows = len(A)
        cols = len(A[0])
        for i in range(1, rows):            # this prob is similar to paint house prob and is using same logic
            for j in range(cols):
                if j == 0:
                    A[i][j] += min(A[i-1][j], A[i-1][j+1])
                    
                elif j == cols - 1:
                    A[i][j] += min(A[i-1][j], A[i-1][j-1])
                    
                else:
                    A[i][j] += min(A[i-1][j], min(A[i-1][j-1], A[i-1][j+1]))
        for i in range(cols):                  
            min_value = min(min_value, A[rows-1][i])
           
        return min_value
*/

// Time Complexity : O(rows * cols)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: I started from row 1 and compared it with previous row's same col, 
// one col before and one col after. For last row I ran for loop to get min value

class Solution {
    public int minFallingPathSum(int[][] A) {
        if (A == null || A.length == 0){
            return 0;
        }
        
        int rows = A.length, cols = A[0].length;
        
        for (int i=1; i<rows; i++){
            for (int j=0; j<cols; j++){
                if (j == 0){
                    A[i][j] += Math.min(A[i-1][j], A[i-1][j+1]);
                }
                else if(j == cols -1){
                    A[i][j] += Math.min(A[i-1][j], A[i-1][j-1]);
                }
                else{
                    A[i][j] += Math.min(A[i-1][j], Math.min(A[i-1][j-1], A[i-1][j+1]));
                }
            }
        }
        
        int min_value = Integer.MAX_VALUE;
        for (int i=0; i<cols; i++){
            min_value = Math.min(min_value, A[rows-1][i]);
        }
        
        return min_value;
    }
}