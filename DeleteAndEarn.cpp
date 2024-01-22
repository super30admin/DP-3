// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
#include<vector>
#include<algorithm>
using namespace std;
class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {
        auto maxLen = max_element(nums.begin(),nums.end());
        vector<int>dp (*maxLen+1,0);
        for(int i =0;i<nums.size();i++)
        {
            dp[nums[i]]+=nums[i];
        }
        for(int i = 2;i<dp.size();i++)
        {
            dp[i] = max(dp[i-1],(dp[i-2]+dp[i]));
        }
        return dp[dp.size()-1];
        
    }
};