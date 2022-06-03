//Time Complexity- O(n)
//Space Complexity- O(n)

class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {
        
        int max_element=INT_MIN;
        for(int num:nums){
            max_element=max(max_element,num);
        }
        
        vector<int> dp(max_element+1,0);
        for(int i=0;i<nums.size();i++){
            dp[nums[i]]++;
        }
        
        int ans=INT_MIN;
        for(int i=2;i<dp.size();i++){
            dp[i]=max(dp[i-1],dp[i-2]+i*dp[i]);
        }
        
        return dp[max_element];
    }
};