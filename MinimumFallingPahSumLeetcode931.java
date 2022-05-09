public class MinimumFallingPahSumLeetcode931 {

 /* Solution 1 * Basic Brute force Recursion */
    //Time Complexity : exponential.
    //Space Complexity : O(depth * width of the tree) spoce for recusrion.
    //leetcode: Yes, fails at brute force time out exceed.

        public int minFallingPathSum(int[][] matrix) {
            int answer =  100000;
            if (matrix == null || matrix[0].length == 0) {
                return 0;
            }
            int rows = matrix.length;
            int cols = matrix[0].length;
            for (int i = 0; i < cols; i++) {
                answer = Math.min(answer, helper(matrix, 0, i, rows, cols));
            }
            return answer;
        }

        public int helper (int[][] matrix, int r, int c, int maxrow, int maxcol) {

            int left_dig = 0, down = 0, right_dig = 0, value = 0;
            if (c >= maxcol || c < 0) {
                return 100000;
            }
            //we reached the last row take the value of that cell (last row and whicever column we are at no need to go down)
            //if i don't do that and let the first base condition hit it will give wrong answer
            // because it will take max value there and then whatever we add to it in left, right and down
            // it takes min from there so we have already begun with the wrong answer on the leaf nodes.
            if (r == maxrow -1) {
                return matrix[r][c];
            }

            if (r >= 0 && r < maxrow && c >= 0 && c < maxcol) {
                left_dig  = matrix[r][c] + helper(matrix, r+1, c-1, maxrow, maxcol);
                down      = matrix[r][c] + helper(matrix, r+1, c, maxrow, maxcol);
                right_dig = matrix[r][c] + helper(matrix, r+1, c+1, maxrow, maxcol);
            }

            return Math.min(down, Math.min(left_dig, right_dig));
        }


        /* Solution 2 using a dp array for memoization */
        //Time Complexity: O(mn)
        //Space complexity O(mn)
        //Leetcode : yes
        Integer [][]dp;
        public int minFallingPathSum1(int[][] matrix) {
            int answer =  100000;
            if (matrix == null || matrix[0].length == 0) {
                return 0;
            }
            int rows = matrix.length;
            int cols = matrix[0].length;
            dp = new Integer[rows][cols];
            for (int i = 0; i < cols; i++) {
                answer = Math.min(answer, helper1(matrix, 0, i, rows, cols));
            }
            return answer;
        }

        public int helper1(int[][] matrix, int r, int c, int maxrow, int maxcol) {

            int left_dig = 0, down = 0, right_dig = 0, value = 0;
            if (c >= maxcol || c < 0) {
                return 100000;
            }
            //we reached the last row take the value of that cell (last row and whicever column we are at no need to go down)
            //if i don't do that and let the first base condition hit it will give wrong answer because it will take max value there and then whatever we add to it in left, right and down it takes min from there so we have already begun with the wrong answer.
            if (r == maxrow -1) {
                return matrix[r][c];
            }

            if (dp[r][c] != null) {
                return dp[r][c];
            }

            if (r >= 0 && r < maxrow && c >= 0 && c < maxcol) {
                left_dig  = matrix[r][c] + helper1(matrix, r+1, c-1, maxrow, maxcol);
                down      = matrix[r][c] + helper1(matrix, r+1, c, maxrow, maxcol);
                right_dig = matrix[r][c] + helper1(matrix, r+1, c+1, maxrow, maxcol);
            }

            dp[r][c] = Math.min(down, Math.min(left_dig, right_dig));
            return dp[r][c];
        }
}
