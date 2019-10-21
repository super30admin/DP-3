/*
931. Minimum Falling Path Sum
Time Complexity: O(n^2)
Space Complexity: O(n^2) where n in the length of the array a

*/

class Solution {
    public int minFallingPathSum(int[][] a) {
        int[][] dp = new int[a.length][a.length];
        int n = a.length;

        for(int i=0; i<dp.length; i++)
            dp[0][i] = a[0][i];

//         dp[0][0] = a[0][0];
//         dp[0][1] = a[0][1];
//         dp[0][2] = a[0][2];

        for(int i=1; i<dp.length; i++){
            for(int j=0; j<dp.length; j++){
                if(j==0)
                    dp[i][j] = a[i][j] + Math.min(dp[i-1][j], dp[i-1][j+1]);
                else if(j == dp.length - 1)
                    dp[i][j] = a[i][j] + Math.min(dp[i-1][j], dp[i-1][j-1]);
                else
                    dp[i][j] = a[i][j] + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i-1][j+1]));

            }
        }
        int min = Integer.MAX_VALUE;
        for(int i=0; i<dp.length; i++){
            if(dp[n-1][i] < min)
                min = dp[n-1][i];
        }
        return min;
    }
}

