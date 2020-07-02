/* Problem2- Minimum Falling Path Sum(DP-3)

/*Approach: Top Down Dynamic Programming Approach
// Time Complexity : O(m*n) where m-columns, n-rows (here we can have any number of columns)
// Space Complexity : O(m*n) else we will be considering separate matrix
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
//Here we are calculating the minimum path sum with considering all the choices
//from next row by atmost one. Here, we will use DP and not greedy approach, since
//in DP, we will explore all possible solutions(in brute force) and then we optimize
//while in greedy, we just have to find min/max and that would decide the whole optimal solution
//Here there are 3 cases to consider: 1)if first column is selected, explore min of [row-1][column] and [row+1][column+1]
//2) if middle columns are considered, explore min of [row-1][column-1], [row-1][column], [row-1][column+1]
//3) if last column is selected, explore min of [row-1][column-1] and [row-1][column]
*/

class Solution {
    public int minFallingPathSum(int[][] A) {
        //edge case
        if(A == null || A.length == 0) return 0;
        int min = Integer.MAX_VALUE;
        int m = A.length;
        int n = A[0].length;
        for(int i = 1; i < m; i++){
            for(int j = 0; j < n; j++){
                //Case 1) if first column
                if(j == 0){
                    A[i][j] = A[i][j] + Math.min(A[i-1][j], A[i-1][j+1]);
                } else if(j == n-1) {
                    A[i][j] = A[i][j] + Math.min(A[i-1][j-1], A[i-1][j]);
                } else {
                    A[i][j] = A[i][j] + Math.min(Math.min(A[i-1][j-1], A[i-1][j]), A[i-1][j+1]);
                }
            }
        }
        for(int i = 0; i < n; i++){
            if(min > A[m-1][i]){
                min = A[m-1][i];
            }
        }
        return min;
    }
}
