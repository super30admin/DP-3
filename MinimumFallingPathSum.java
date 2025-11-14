/*
 Approach: Minimum Falling Path Sum (Top-down with memoization)
 - Problem: For each cell in the first row, recursively explore falling paths (down, down-left, down-right) and take the minimum path sum.
 - Use memoization (`memo[row][col]`) to avoid recomputing overlapping subproblems.
 - This is a straightforward DFS + DP (top-down) solution.

 Time Complexity: O(N^2) where N = matrix.length (each cell's result is computed once and there are N*N cells).
 Space Complexity: O(N^2) for the memo table and O(N) recursion depth (stack) in the worst case.
 LeetCode: https://leetcode.com/problems/minimum-falling-path-sum/ (Problem 931)
*/

import java.util.Arrays;

public class MinimumFallingPathSum {
    int[][] memo;
    public int minFallingPathSum(int[][] matrix){
        memo= new int[matrix.length][matrix.length];
        for (int[] ints : memo) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i< matrix.length; i++){
            int current = helper(matrix, 0, i);
            min = Math.min(current, min);
        }
        return  min;
    }

    private int helper(int[][] matrix, int rowIndex, int columnIndex) {
        if(rowIndex == matrix.length) return 0;

        if(memo[rowIndex][columnIndex] != Integer.MAX_VALUE) return memo[rowIndex][columnIndex];
        int caseLeft = Integer.MAX_VALUE;
        int caseRight = Integer.MAX_VALUE;

        int caseBelow = helper(matrix, rowIndex + 1, columnIndex) + matrix[rowIndex][columnIndex];
        if (columnIndex - 1 >= 0)
            caseLeft = helper(matrix, rowIndex + 1, columnIndex - 1)+ matrix[rowIndex][columnIndex];
        if (columnIndex + 1 < matrix.length)
            caseRight = helper(matrix, rowIndex + 1, columnIndex + 1) + matrix[rowIndex][columnIndex];

        int min=  Math.min(caseBelow, Math.min(caseLeft, caseRight));
        memo[rowIndex][columnIndex] = min;
        return min;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumFallingPathSum().minFallingPathSum(new int[][]{{-19,57},{-40,-5}}));
        System.out.println(new MinimumFallingPathSum().minFallingPathSum(new int[][]{{2,1,3},{6,5,4},{7,8,9}}));

    }
}
