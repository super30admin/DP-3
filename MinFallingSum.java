// Time Complexity : O(R * C) where R = no of Rows, C = no of Columns
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
//1. We can only consider minimum element from the previous row and add it to the current element.
//2. If the current element is the first element in the row then it has only two posibilities to find 
//the minimum element. Similarly for the last element in the matrix.
//3.Other than that every element has 3 posibilities to find the minimun element in the row.

public class MinFallingSum {

    public int minFallingPathSum(int[][] A) {

        if (A.length == 0)
            return 0;

        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (j == 0) {
                    A[i][j] += Math.min(A[i - 1][j], A[i - 1][j + 1]);
                } else if (j == A[0].length - 1) {
                    A[i][j] += Math.min(A[i - 1][j - 1], A[i - 1][j]);
                } else {

                    A[i][j] += Math.min(A[i - 1][j - 1], Math.min(A[i - 1][j], A[i - 1][j + 1]));
                }
            }

        }
        int min = A[A.length - 1][0];
        for (int j = 1; j < A[0].length; j++) {
            min = Math.min(min, A[A.length - 1][j]);
        }

        return min;
    }

    public static void main(String args[]) {
        MinFallingSum obj = new MinFallingSum();
        int[][] arr = { { 51, 24 }, { -50, 82 } };
        System.out.println(obj.minFallingPathSum(arr));

    }
}
