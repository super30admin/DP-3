// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach :

// In the matrix, we will need to evaluate the combination of choosing a cell based on its 3 neighbors, choose the option whichever leads to minimum path at that cell.
public class MinimumPathSum {
    public int minFallingPathSum(int[][] matrix) {

        int min = Integer.MAX_VALUE;
        int size = matrix.length;
        if(size == 1){ return matrix[0][0]; }

        for(int i = 0; i < matrix.length; i++){
            min = Math.min(min, pathSum(matrix, 0, i));
        }
        System.out.println("Min path sum with recursion: "+ min);

        min = Integer.MAX_VALUE;
        int [][] memo  = new int[size][size];
        for(int i = 0; i < matrix.length; i++){
            min = Math.min(min, pathSumMemo(matrix, 0, i, memo));
        }
        System.out.println("Min path sum with memoization: "+ min);

        min = pathSumTabulation(matrix);
        System.out.println("Min path sum with tabulation: "+ min);

        min = pathSumSpaceOptimization(matrix);
        System.out.println("Min path sum with space optimization: "+ min);
        return min;
    }

    private int pathSum(int[][] matrix, int row, int col) {
        // Time Complexity : O(3^N), where N is the size of the matrix and at every recursion call we have 3 options to choose from
        // Space Complexity : O(N), we will need to evaluate each row, thus it will on the stack frame till
        // N rows of values are evaluated
        int size = matrix.length;
        if(row >= size || row <0) return Integer.MAX_VALUE;
        if(col >= size || col <0) return Integer.MAX_VALUE;

        int min = Integer.MAX_VALUE;
        int currentSum = matrix[row][col];

        min = Math.min(min,  pathSum(matrix, row + 1, col-1));
        min = Math.min(min,  pathSum(matrix, row + 1, col));
        min = Math.min(min, pathSum(matrix, row + 1, col+1));

        if(min == Integer.MAX_VALUE){
            return currentSum;
        }
        return currentSum + min;
    }

    private int pathSumMemo(int[][] matrix, int row, int col, int[][] memo) {
        // Time Complexity : O(N^2)
        // Space Complexity : O(N)
        int size = matrix.length;
        if(row >= size || row <0) return Integer.MAX_VALUE;
        if(col >= size || col <0) return Integer.MAX_VALUE;

        if(memo[row][col] != -1){
            return memo[row][col];
        }
        int min = Integer.MAX_VALUE;
        int currentSum = matrix[row][col];

        if(row < size-1) {
            if (col > 0) {
                min = Math.min(min, pathSum(matrix, row + 1, col - 1));
            }
            min = Math.min(min, pathSum(matrix, row + 1, col));

            if (col < size+1) {
                min = Math.min(min, pathSum(matrix, row + 1, col + 1));
            }
        }
        if(min == Integer.MAX_VALUE){
            memo[row][col] = currentSum;
            return currentSum;
        }

        memo[row][col] = currentSum + min;
        return currentSum + min;
    }

    private int pathSumTabulation(int[][] matrix) {
        // Time Complexity :  O(N^2)
        // Space Complexity : O(N^2)
        // Evaluate at each cell, the minimum of 3 choices and add it to the current cell value.
        int size = matrix.length;
        int[][] table = new int[size+1][size];

        for (int i = 1; i <= size; i++) {
            for (int j = 0; j < size; j++) {
                int min = Integer.MAX_VALUE;
                min = Math.min(min, table[i-1][j]);
                if(j > 0){
                    min = Math.min(min, table[i-1][j-1]);
                }

                if(j < size-1){
                    min = Math.min(min, table[i-1][j+1]);
                }
                table[i][j] = matrix[i-1][j] + min;
            }
        }

        // The last row will have the minimum values for each cell, thus get the min out of those values too.
        int result = table[size][0];
        for(int i = 0; i < size; i++){
            result = Math.min(result, table[size][i]);
        }
        return result;
    }

    private int pathSumSpaceOptimization(int[][] matrix) {
        // Time Complexity : O(N^2)
        // Space Complexity : O(N)
        // In each loop in the previous solution, we need the previous row values and the current row values to evaluate minimum.
        // Thus instead of having entire matrix, we can keep the values in 2 rows and update them once the inner loop is done.
        int size = matrix.length;
        int[] prevRow = new int[size];

        for (int i = 0; i < size; i++) {
            int[] currentRow = new int[size];
            for (int j = 0; j < size; j++) {
                int min = Integer.MAX_VALUE;
                min = Math.min(min, prevRow[j]);
                if(j > 0){
                    min = Math.min(min, prevRow[j-1]);
                }

                if(j < size-1){
                    min = Math.min(min, prevRow[j+1]);
                }
                currentRow[j] = matrix[i][j] + min;
            }
            prevRow = currentRow;
        }

        int result = prevRow[0];
        for(int i = 0; i < size; i++){
            result = Math.min(result, prevRow[i]);
        }
        return result;
    }
}
