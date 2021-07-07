//Time complexity: O(N^2)
//Space complexity: O(N^2)

class Solution {
    public int minFallingPathSum(int[][] A) {

        int max=9999;
        int result=Integer.MAX_VALUE;
        int[][] dp=new int[A.length][A[0].length+2];
        for(int i=0;i<dp.length;i++){
            dp[i][0]=max;
            dp[i][dp[0].length-1]=max;
        }
        for(int i=1;i<=dp[0].length-2;i++){
            dp[0][i]=A[0][i-1];
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length-1;j++){
                dp[i][j]=Math.min(A[i][j-1]+dp[i-1][j-1],Math.min(A[i][j-1]+dp[i-1][j],A[i][j-1]+dp[i-1][j+1]));
            }
        }
        for(int j=0;j<dp[0].length;j++){
            result=Math.min(result,dp[dp.length-1][j]);
        }
        return result;
    }
}