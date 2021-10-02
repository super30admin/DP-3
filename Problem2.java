// Time Complexity : O(N * M)
// Space Complexity : O(~1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Problem2 {

    public static int minFallingPathSum(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        if(matrix.length == 1)  return getMin(matrix[0]);

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int stop_going_out_of_bounds = matrix[i][j] + matrix[i-1][j];
                if(j - 1 >= 0)
                    stop_going_out_of_bounds = Math.min(stop_going_out_of_bounds, matrix[i][j] + matrix[i-1][j-1]);
                if(j + 1 < matrix[0].length)
                    stop_going_out_of_bounds = Math.min(stop_going_out_of_bounds, matrix[i][j] + matrix[i-1][j+1]);

                matrix[i][j] = stop_going_out_of_bounds;

            }
        }

        return getMin(matrix[matrix.length - 1]);
    }

    public static int getMin(int[] matrix){
        int min = Integer.MAX_VALUE;
        for(int x : matrix)
            min = Math.min(min, x);
        return min;
    }

    public static void main(String[] args) {
        System.out.println(minFallingPathSum(new int[][]{{2,1,3}, {6,5,4}, {7,8,9}})); // 13
        System.out.println(minFallingPathSum(new int[][]{{-48}})); // -48
    }

}
