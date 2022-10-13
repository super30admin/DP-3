// Time Complexity - O(n)
// Space Complexity - O(n)
// Problems Faced - No!
// It runs on leetcode.

class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {
        int m = 0;
        for(int i = 0; i < nums.size(); i++){
            m = max(m, nums[i]);
        }
        vector<int> nums2(m+1);
        
        for(int n : nums){
            nums2[n] += n;
        }
        
        vector<int> dp(m+1);
        dp[0] = nums2[0];
        dp[1] = max(nums2[0], nums2[1]);
        for(int i = 2; i < dp.size(); i++){
            dp[i] = max(dp[i-1], nums2[i] + dp[i-2]);
        }
        
        return dp[m];
        
    }
};
