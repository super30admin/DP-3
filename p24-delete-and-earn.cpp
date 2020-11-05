// Time complexity is O(m)+O(n) where m is length of nums and n is len of arr
// Space complexity is O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
public:
    
    int deleteAndEarn(vector<int>& nums) {
        if(nums.size() == 0) return 0;
        int maxNum = INT_MIN;
        for(int i = 0; i < nums.size(); i++) {
            maxNum = max(nums[i], maxNum);
        }
        vector<int> temp(maxNum+1, 0);
        for(int i = 0; i < nums.size(); i++) {
            temp[nums[i]] += nums[i];
        }
        
        vector<vector<int>> dp(temp.size(), vector<int>(2,0));
        int rows = temp.size();
        dp[0][1] = temp[0];
        for(int i = 1; i < rows; i++){
            for(int j = 0; j < 2; j++) {
                if(j == 0)
                    dp[i][j] = max(dp[i-1][0], dp[i-1][1]);
                else
                    dp[i][j] = dp[i-1][0] + temp[i];
            }
        }
        return max(dp[rows-1][0], dp[rows-1][1]);
    }
};
