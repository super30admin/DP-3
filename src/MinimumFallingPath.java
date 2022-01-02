public class MinimumFallingPath {
    //Brute
    class Solution {
        public int minFallingPathSum(int[][] matrix) {
            if(matrix == null || matrix.length == 0) return 0;
            int min = 9999999;
            for(int i=0; i<matrix.length; i++)
                min = Math.min(min, helper(matrix, 0, i, matrix[0][i]));

            return min;
        }
        private int helper(int matrix[][],int row, int index, int minSoFar) {
            //base
            if(row+1 >= matrix.length || index>matrix[0].length) return minSoFar;
            //logic
            // System.out.println(matrix[row][index] + "   " + minSoFar);

            int case0 = 1011111 ;
            int case1 = 101111 ;
            int case2 = 111111;
            if(index-1 >= 0) {
                case0 = helper(matrix, row+1, index-1, minSoFar+ matrix[row+1][index-1]);
            }
            if(index+1 < matrix[0].length) {
                case2 = helper(matrix, row+1, index+1, minSoFar+ matrix[row+1][index+1]);
            }
            case1 = helper(matrix, row+1, index, minSoFar+ matrix[row+1][index]);
            return Math.min(case0, Math.min(case1, case2));
        }
    }

    //DP
    // Time Complexity : O(MN))
    // Space Complexity : O(MN)
    // Did this code successfully run on Leetcode : yes
    // Any problem you faced while coding this : no

    public int minFallingPathSum(int[][] matrix) {
            if(matrix == null || matrix.length == 0) return 0;
            int min = 9999999;
            for(int i=matrix.length-2; i>=0; i--) {
                for(int j=0; j<matrix[0].length; j++) {
                    if(j!=0 && j!=matrix[0].length-1) {
                        matrix[i][j] += Math.min(matrix[i+1][j-1],Math.min(matrix[i+1][j], matrix[i+1][j+1]));
                    }
                    if(j==0 && j!=matrix[0].length-1) {
                        matrix[i][j] += Math.min(matrix[i+1][j], matrix[i+1][j+1]);
                    }
                    if(j!=0 && j==matrix[0].length-1) {
                        matrix[i][j] += Math.min(matrix[i+1][j], matrix[i+1][j-1]);
                    }
                }
            }
            for(int j=0; j<matrix[0].length; j++) {
                min = Math.min(min, matrix[0][j]);
            }
            return min;
        }
}
