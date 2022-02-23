//                           Top-Down               Bottom-Up
// Time Complexity:           O(n^2)                 O(n^2)
// Space Complexity:          O(n^2)                  O(n)
// where n is number of length of matrix
// Yes, this code ran successfully
// No, I didn't face any problem in this problem statement

package src;

import java.util.Arrays;

public class MinimumFallingPathSum {
    public static void main(String[] args) {
        MinimumFallingPathSum mfps = new MinimumFallingPathSum();
        int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
        System.out.println("Minimum sum:"+mfps.minFallingPathSum(matrix));
    }
    public int minFallingPathSum(int[][] matrix) {

        int n = matrix.length;

        int[][] dp = new int[n][n];
        for(int i=0; i<n; i++)
        {
            int[] temp = new int[n];
            Arrays.fill(temp,-1);
            dp[i] = temp;
        }

        int minVal = Integer.MAX_VALUE;
        for(int i=0; i<n; i++)
        {
            minVal = Integer.min(minVal,matrix[0][i] + minFallingPathSum(matrix, 1, i, dp));
        }

// ******************** Another Method ********************
//        int[] ans = new int[n];
//        for(int i=0; i<n; i++)
//        {
//            ans[i] = matrix[0][i] + minFallingPathSum(matrix, 1, i, dp);
//        }
//        int minVal = ans[0];
//        for(int i:ans)
//            minVal = Math.min(minVal, i);

        return minVal;

// ******************** Bottom-Up Approach ********************
//        int n = matrix.length;
//
//        int[] prev = matrix[0];
//
//        for(int i=1; i<n; i++)
//        {
//            int[] cur = matrix[i];
//            for(int j=0; j<n; j++)
//            {
//                int min = prev[j];
//                if(j-1>=0)
//                    min = Math.min(min, prev[j-1]);
//                if(j+1<=m-1)
//                    min = Math.min(min, prev[j+1]);
//                cur[j] = min + cur[j];
//            }
//            prev = cur;
//        }
//
//        int minVal = prev[0];
//        for(int i:prev)
//            minVal = Math.min(minVal, i);
//
//        return minVal;

    }

    private int minFallingPathSum(int[][] matrix, int index, int prevNumber, int[][] dp)
    {
        if(index == matrix.length)
            return 0;

        if(dp[index][prevNumber]!=-1)
            return dp[index][prevNumber];

        int min = Integer.MAX_VALUE;

        for(int i=0; i<matrix[0].length; i++)
        {
            if(Math.abs(i-prevNumber)<=1)
                min = Math.min(min, matrix[index][i] + minFallingPathSum(matrix, index+1, i, dp));
        }
        return dp[index][prevNumber] = min;
    }
}
