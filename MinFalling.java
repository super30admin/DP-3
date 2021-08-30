// Time Complexity : O(rows * columns)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Approch: Used the house-paint approch by adding the  min of adjacent to the above element
/**
 * Given an n x n array of integers matrix, return the minimum sum of any
 * falling path through matrix.
 * 
 * A falling path starts at any element in the first row and chooses the element
 * in the next row that is either directly below or diagonally left/right.
 * Specifically, the next element from position (row, col) will be (row + 1, col
 * - 1), (row + 1, col), or (row + 1, col + 1).
 */

public class MinFalling {

    public int minFallingPathSum(int[][] matrix) {

        // invalied case
        if (matrix == null)
            return 0;

        // bpttom-up calculations based on given criteria
        for (int i = matrix.length - 2; i >= 0; i--) {
            for (int j = 0; j < matrix[0].length; j++) {
                int prevMiddle = matrix[i + 1][j];
                int prevLeft = j == 0 ? Integer.MAX_VALUE : matrix[i + 1][j - 1];
                int prevRight = j == matrix[0].length - 1 ? Integer.MAX_VALUE : matrix[i + 1][j + 1];
                matrix[i][j] += Math.min(prevMiddle, Math.min(prevLeft, prevRight));
            }
        }

        int min = Integer.MAX_VALUE;

        // Getting the min of first row
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] < min)
                min = matrix[0][i];
        }
        return min;
    }

    public static void main(String[] args) {
        MinFalling mf = new MinFalling();

        int[][] nums = { { 2, 1, 3 }, { 6, 5, 4 }, { 7, 8, 9 } };
        System.out.println(mf.minFallingPathSum(nums));
    }
}
