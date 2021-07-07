// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class MinimumFallingPathSum {
    public static int minFallingPathSum(int[][] A) {
        // Time Complexity: O(n + n^2 + n) = O(n^2)
        // Space Complexity: O(n)
    /*By looking at the example, we get to knoew that we only deal with max of three         elements, [i-1][j-1]
                [i-1][j+1]
                [i-1][j]
    so, we first
    1. create dp[][] to store min sum of elements till that index
    2. fill frst row of DP with elements of A
    3. iteratre from i=1 to i<n and for j=0 to j<n
    4. For boundary conditions, we check if j-1>=0 && j+1<n and calculate min sum
    5. Update dp[i][j] with sum of min taken from above and A[i][j].
    6. Return min from last row.
    */
        int n = A.length;
        int dp[][] = new int[n][n];

        for(int i = 0; i<n; i++){
            dp[0][i] = A[0][i];
        }

        for(int i = 1 ; i < n ; i++){
            for(int j = 0; j<n; j++){
                int temp = dp[i-1][j];
                if(j-1 >= 0){
                    temp = Math.min(temp, dp[i-1][j-1]);
                }
                if(j+1 < n){
                    temp = Math.min(temp, dp[i-1][j+1]);
                }

                dp[i][j] = A[i][j] + temp;
            }
        }

        int min = dp[n-1][0];

        for(int i=1 ; i < n; i++){
            if(dp[n-1][i] < min){
                min = dp[n-1][i];
            }
        }

        return min;
    }

    public static void main(String args[]){
        int[][] A = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(minFallingPathSum(A));
    }
}
