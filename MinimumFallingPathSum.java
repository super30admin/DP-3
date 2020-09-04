/*
931. Minimum Falling Path Sum - MEDIUM
https://leetcode.com/problems/minimum-falling-path-sum/

Approach:
1. For every element at [i,j] - the minimum sum can be from 3 values - [i-1, j-1], [i-1, j] or [i-1, j+1]
2. Calculate the mimimum sum for all elements in the matrix
3. Final answer is the minimum of the all values in the last row
4. Keep in mind, edge cases for columns - ( < 0 ) and ( > col )
(Very similar to Paint House)

TC: O(n^2) - n: dimension of square matrix
SC: O(1), constant space, we are modifying the original array
Did this code successfully run on Leetcode: Yes
Any problem you faced while coding this: No
*/

public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] A) {
        
        if (A == null || A.length == 0 || A[0].length == 0) {
            return 0;
        }
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                A[i][j] += getMinFromPreviousRow(A[i-1], j);
            }
        }
        
        return getMin(A[A.length-1]);
    }
    
    public int getMinFromPreviousRow(int[] a, int index) {
        int min = a[index];
        if (index - 1 >= 0) {
            min = Math.min(a[index-1], min);
        }
        if (index + 1 < a.length) {
            min = Math.min(a[index+1], min);
        }
        return min;
    }
    
    public int getMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        
        for (int num: nums) {
            min = Math.min(min, num);
        }
        return min;
    }
}
