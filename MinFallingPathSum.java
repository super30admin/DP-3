// Time Complexity : O(n^2) n is nums length
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.Arrays;

public class MinFallingPathSum {
    public int minFallingPathSum(int[][] A) {

        /*
            The minimum path to get to element A[i][j] is the minimum of A[i - 1][j - 1], A[i - 1][j] and A[i - 1][j + 1].
            Starting from row 1, we add the minumum path to each element. The smallest number in the last row is the miminum path sum.
        */

        for (int i = 1; i < A.length; ++i)
            for (int j = 0; j < A.length; ++j)
                A[i][j] += Math.min(A[i - 1][j], Math.min(A[i - 1][Math.max(0, j - 1)], A[i - 1][Math.min(A.length - 1, j + 1)]));
        return Arrays.stream(A[A.length - 1]).min().getAsInt();
    }
}
