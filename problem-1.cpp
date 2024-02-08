// 740. Delete and Earn
// Time Complexity : O(n + max)
// Space Complexity : 10001
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
    
Iterates through the input array nums, accumulating points for each element while keeping track of the maximum element encountered. 
Then, iterating through the dynamic programming array, updating each element with the maximum points achievable considering whether 
to include or exclude the current element. Finally, returns the maximum points achievable from the last element of the dynamic programming 
array, which represents the maximum points earned by making optimal choices.

*/

class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {
        int dp[10001] = {0}, maxi = 0;
        for(int i = 0; i < nums.size(); i++)
        {
            dp[nums[i]] += nums[i];
            maxi = max(nums[i], maxi);
        }
        for(int i = 2; i <= maxi; i++)
            dp[i] = max(dp[i-1],dp[i] + dp[i-2]);

        return dp[maxi];
    }
};