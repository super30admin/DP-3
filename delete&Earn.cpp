//time complexity: O(n)
//space complexity:O(n)
//approach: dp
//solved on leetcode? yes
//problem faced? yes, I knew that it was similar to house robber but still couldnt code it so I saw a solution
class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {
        int maxi=0;
        if(nums.size()==0)
            return 0;
        if(nums.size()==1)
            return nums[0];
        int dp[10001];
        memset(dp,0,size(dp));
        for(int i=0; i<nums.size(); i++)
        {
            dp[nums[i]]++;
            maxi=max(maxi,nums[i]);
        }
        for(int i=2; i<=maxi; i++)
        {
            dp[i]=max(dp[i-1],dp[i-2]+dp[i]*i);
        }
        
        return dp[maxi];
    }
};