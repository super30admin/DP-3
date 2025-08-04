public class Problem2 {
    //We start from the second-last row and update each cell by adding the minimum of the three possible paths from the row below.By the time we reach the top row, each cell holds the minimum falling path sum starting from that position.
    //TC is O(nxn) and SC is O(1)
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col < n; col++) {
                int down = matrix[row + 1][col];
                int downLeft = col > 0 ? matrix[row + 1][col - 1] : Integer.MAX_VALUE;
                int downRight = col < n - 1 ? matrix[row + 1][col + 1] : Integer.MAX_VALUE;
                matrix[row][col] += Math.min(down, Math.min(downLeft, downRight));
            }
        }
        int min = Integer.MAX_VALUE;
        for (int val : matrix[0]) {
            min = Math.min(min, val);
        }
        return min;
    }

}
