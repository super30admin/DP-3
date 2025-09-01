//Time Complexity: O(n ^ 2)
//Space Complexity: O(1)
//Did this code successfully run on Leetcode : Yes
//Approach: There are only 3 cases to worry about here as the problem mentions, for col 0, choose col 0, 1
//for col = n - 1, choose col n - 1, n - 2
//for other cases, choose the min of i - 1, i, i - 2 values (this case will be applicable for n >= 3)
//No extra space is being used because we are updating the input in place which will act as the dp matrix for us
public class MinFallingPathSum {

    /**
     *
     * @param matrix the matrix to find the min falling path sum from
     * @return       the min falling path sum
     */
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (j == 0) {
                    matrix[i][j] += Math.min(matrix[i + 1][j], matrix[i + 1][j + 1]);
                } else if (j == matrix.length - 1) {
                    matrix[i][j] += Math.min(matrix[i + 1][j], matrix[i + 1][j - 1]);
                } else {
                    matrix[i][j] += Math.min(matrix[i + 1][j], Math.min(matrix[i + 1][j + 1], matrix[i + 1][j - 1]));
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int j : matrix[0]) {
            min = Math.min(min, j);
        }

        return min;
    }

    public static void main(String[] args) {
        final MinFallingPathSum minFallingPathSum = new MinFallingPathSum();
        System.out.println(minFallingPathSum.minFallingPathSum(new int[][] {
                {2, 1, 3},
                {6, 5, 4},
                {7, 8, 9}
        })); //return 13

        System.out.println(minFallingPathSum.minFallingPathSum(new int[][] {
                {-19, 57},
                {-40, -5}
        })); //return -59
    }
}
