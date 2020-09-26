// Time Complexity : O(N)
// Space Complexity : O(N*N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& a) {
      int row=a.size();
      int col=a[0].size();
        
      int dp[row][col];
        
      for (int i=0;i<col;i++) {
            dp[0][i]=a[0][i]; // set the first row equal to the first row of the original matrix
        }
        
         for (int i=1;i<row;i++) { // index starts from row2 int the original matrix
            for (int j=0;j<col;j++) {
                if (j==0) { //first column condition
                    dp[i][j]=a[i][j]+ min(dp[i-1][j],dp[i-1][j+1]);
                } else if (j==col-1) { //last column condition
                    dp[i][j]=a[i][j]+ min(dp[i-1][j],dp[i-1][j-1]);
                } else { //rest of the columns
                    dp[i][j]=a[i][j]+ min( min(dp[i-1][j],dp[i-1][j+1]),dp[i-1][j-1]);
                }
            }
        }
        int mini=INT_MAX;
        for(int i=0;i<col;i++){ //loop through the last row to get the min value
            mini=min(mini,dp[row-1][i]);
        }
        // for(int i=0;i<row;i++) {
        //     for(int j=0;j<col;j++){
        //         cout<<dp[i][j]<<" ";
        //     }
        //     cout<<endl;
        // }
        return mini;
    }
};