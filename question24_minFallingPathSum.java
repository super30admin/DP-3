package DynamicProgramming3;

public class question24_minFallingPathSum {

    /*
        Time Complexity: O(m + n)
        Space Complexity: O(m + n)
    */
    public static int minFallingPathSum(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col + 2];

        // Fill the first row of the matrix
        for(int i = 1 ; i <= col ; i++) {
            dp[0][i] = matrix[0][i - 1];
        }

        // Fill the 1st and last column of matrix with Max values
        for(int i = 0 ; i < row ; i++) {
            dp[i][0] = Integer.MAX_VALUE;
            dp[i][col + 1] = Integer.MAX_VALUE;
        }

        //Build the dp matrix
        for(int i = 1 ; i < row ; i++) {
            for(int j = 1 ; j <= col ; j++) {
                // find the minimum neighbor
                int minNeigh = Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
                minNeigh = Math.min(minNeigh, dp[i - 1][j + 1]);
                dp[i][j] = matrix[i][j-1] + minNeigh;
            }
        }
        //Minimum Path Sum is the minimum of the last row in the dp matrix
        int min = Integer.MAX_VALUE;
        for(int i = 1 ; i <= col ; i++) {
            min = Math.min(min, dp[row - 1][i]);
        }
        return min;
    }

    public static void main(String[] args) {
        int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
        System.out.println(minFallingPathSum(matrix));
    }
}
