/* Given a square array of integers A, we want the minimum sum of a falling path through A.
* Time complexity is O(MN). Space complexity is O(1).
*/
class Solution {
    public int minFallingPathSum(int[][] A) {
        if (A == null || A.length == 0)
            return 0;
        for (int i = 1; i< A.length; i++)
        {
            for (int j = 0; j <A[0].length; j++) {
                if (j==0) {
                    A[i][j] += Math.min(A[i-1][j], A[i-1][j+1]);
                }
                else if (j == A[i].length-1) {
                    A[i][j] += Math.min(A[i-1][j-1], A[i-1][j]);
                }
                else {
                    A[i][j] += Math.min(A[i-1][j-1], Math.min(A[i-1][j], A[i-1][j+1]));
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < A[0].length; j ++)
        {
            if (A[A.length-1][j] < min)
            {
                min = A[A.length-1][j];
            }
        }
        return min;
    }
}
