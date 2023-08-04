class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {
        unordered_map<int,int> mp; 
        int maxNum = nums[0];

        for(int i = 0; i < nums.size(); i++) {
            mp[nums[i]] = mp[nums[i]] + nums[i];
            if(maxNum < nums[i]) maxNum = nums[i];
        }

        vector<int> dp(maxNum+1, -1);
        dp[0] = 0; 
        dp[1] = mp[1];

        for(int i = 2; i <= maxNum; i++) {
            dp[i] = max((dp[i-2] + mp[i]), dp[i-1]);
        }


        return dp[maxNum];

    }
};