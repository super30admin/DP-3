// Time Complexity : O(n) + O(max)
// Space Complexity :O(max)
// Did this code successfully run on Leetcode : yes

// linear Dp, here we cannot proceed forward with the given array. so we need to extract some other array to proceed furthur.
// As we are adding values that are same , we can proceed to add all same numbers and store at their indices only, so that our next contraint 
// also can be taken care of i.e., not selecting nums[i] - 1 and nums[i] + 1 if we select nums[i]


class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {
        if(nums.empty() || nums.size()==0){
            return 0;
        }
        int maxValue = INT_MIN;
        for(int i=0;i<nums.size();i++){
            maxValue = max(maxValue,nums[i]);
        }
        vector<int>v(maxValue+1,0);
        for(int i=0;i<nums.size();i++){
            int index = nums[i];
            v[index] = v[index] + nums[i];
        }
        vector<int>dp(3 ,0);
        dp[1] = v[1];
        for(int i=2;i<maxValue+1;i++)
        {
            dp[i % 3] = max(dp[(i-1) % 3], dp[(i-2) % 3] + v[i]);
        }
        return dp[maxValue % 3];
        
    }
};