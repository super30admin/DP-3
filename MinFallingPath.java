// Time Complexity : O(mn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no


public class MinFallingPath {

        public int minFallingPathSum(int[][] matrix) {
            int dp[] = new int [matrix.length];

            dp = matrix[0];

            for (int i = 1; i < matrix.length ; i++){
                for (int j = 0; j < matrix.length ; j++){

                    matrix[i][j] = matrix[i][j] +
                            Math.min( j - 1 < 0 ? Integer.MAX_VALUE: matrix[i - 1][j - 1] ,
                                    Math.min(matrix[i-1][j],  j + 1 >= matrix.length ? Integer.MAX_VALUE : matrix[i-1][j + 1]));

                }
            }

            int ans = Integer.MAX_VALUE;
            for (int j = 0 ; j < matrix.length ; j++){
                ans = Math.min(ans, matrix[matrix.length - 1][j]);
            }

            return ans;
        }

        public static void main(String[] args){
            int [][] nums = {{2,1,3},{6,5,4},{7,8,9}};
            MinFallingPath obj = new MinFallingPath();
            obj.minFallingPathSum(nums);
        }
    }

