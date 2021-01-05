// https://leetcode.com/problems/minimum-falling-path-sum/
// Time Complexity : O(rows*cols)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
class Solution {
    public int minFallingPathSum(int[][] A) {
        if (A == null || A.length == 0)
            return 0;

        int min = Integer.MAX_VALUE;
        for (int i = A.length - 2; i >= 0; i--) {
            for (int j = 0; j < A[0].length; j++) {
                min = A[i + 1][j];
                for (int diff : new int[] { -1, 1 }) {
                    int currCol = j + diff;
                    if (currCol >= 0 && currCol < A[0].length)
                        min = Math.min(A[i + 1][currCol], min);
                }
                A[i][j] += min;
            }
        }

        min = A[0][0];
        for (int j = 1; j < A[0].length; j++)
            min = Math.min(min, A[0][j]);

        return min;
    }
}