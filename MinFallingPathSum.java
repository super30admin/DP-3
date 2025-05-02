//Time Complexity: m*n
// Space Complexity: O(n)
class Solution {
    public int minFallingPathSum(int[][] A) {
        int n=A.length;
        int dp[] = new int[n];
        for(int j=0;j<n;j++){
            dp[j]=A[n-1][j];
        }
        for(int i=n-2;i>=0;i--){
            int left = 0;
            for(int j=0;j<n;j++){
                int temp = dp[j];
                if(j == 0){
                    dp[j]=A[i][j]+Math.min(dp[j],dp[j+1]);
                } else if(j== n - 1){
                    dp[j]=A[i][j]+Math.min(dp[j],left);
                } else {
                    dp[j]=A[i][j]+Math.min(dp[j],Math.min(dp[j+1],left));
                }
                left = temp;
            }
        }
        int min=Integer.MAX_VALUE; 
        for(int j=0;j<n;j++){
            if(min>dp[j]) min=dp[j];
        }
        return min;
    }
 }