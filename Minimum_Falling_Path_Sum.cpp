/*
Time Complexity: O(n^2)
Space Complexity: O(1)
Did this code successfully run on Leetcode :yes
Any problem you faced while coding this : no
*/
class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& matrix) {
        int mx = matrix.size();
        for(int i = 1; i < mx; i++){
            for(int j = 0; j < mx; j++){
                int dl = j==0 ? INT_MAX: matrix[i-1][j-1];
                int dc = matrix[i-1][j];
                int dr = j==mx-1 ? INT_MAX: matrix[i-1][j+1];
                matrix[i][j] +=  min(dl,min(dc,dr));
            }
        }
        int ans = INT_MAX;
        for(int j = 0; j<mx;j++){
            ans=min(ans,matrix[mx-1][j]);
        }
        return ans;
    }
};