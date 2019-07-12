// Time Complexity :O(n*n) --> beacuse of nested for loop for square matrix
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
public class minFallingPathSum {
    public static int minFallingPathSum(int[][] A) {
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (j == 0)
                    A[i][j] += Math.min(A[i - 1][j + 1], A[i - 1][j]);
                else if (j == A[0].length - 1)
                    A[i][j] += Math.min(A[i - 1][j - 1], A[i - 1][j]);
                else
                    A[i][j] += Math.min(Math.min(A[i - 1][j - 1], A[i - 1][j]), A[i - 1][j + 1]);
            }
        }
        int min = 99999;
        for (int i = 0; i < A[0].length; i++)
            min = Math.min(min, A[A.length - 1][i]);
        return min;
    }
        public static void main(String[] args) {
        int[][] nums = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(minFallingPathSum(nums));
    }
}
