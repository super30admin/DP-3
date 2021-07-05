import java.util.*;
public class MinimumFallingPathSum {
        public int minFallingPathSum(int[][] matrix) {
            for (int i = 1; i < matrix.length; ++i)
                for (int j = 0; j < matrix.length; ++j)
                    matrix[i][j] += Math.min(matrix[i - 1][j], Math.min(matrix[i - 1][Math.max(0, j - 1)], matrix[i - 1][Math.min(matrix.length - 1, j + 1)]));
            return Arrays.stream(matrix[matrix.length - 1]).min().getAsInt();

        }
        public static void main(String[] args){
            MinimumFallingPathSum m = new MinimumFallingPathSum();
            int [][] arr = {{-19,57},{-40,5}};
            System.out.println(m.minFallingPathSum(arr));
        }
    }

