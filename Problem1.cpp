//Time Complexity:O(N)
//Space Complexity:O(N) hash map

class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {
    map<int,int> newmap;
    int max_value = 0;
    for(int i=0;i<nums.size();i++)
    {
        newmap[nums[i]]++;
        if(nums[i]>max_value)
        max_value = nums[i];
     }
    
    vector<int> dp(max_value+1);
    
    dp[1] = newmap[1];
    
    for(int i=2;i<=max_value;i++)
    {
        dp[i] = max(i*newmap[i]+dp[i-2], dp[i-1]);
    }
    return dp[max_value];
    }
};