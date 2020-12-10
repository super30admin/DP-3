// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes

class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {
        if(nums.size()==0){
            return 0;
        }
        int maxi = INT_MIN;
        for(int num:nums){
            maxi = max(maxi,num);
        }
        vector<int> dp(maxi+1);
        for(int num:nums){
            dp[num] = dp[num] + num;
        }
        int skip = 0, take = 0;
        for(int i=0;i<dp.size();i++){
            int temp = max(skip,take);
            take = skip + dp[i];
            skip = temp;
        }
        return max(skip,take);
    }
};
