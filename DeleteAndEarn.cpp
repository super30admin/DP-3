//Time Complexity O(numberOfCoins*amount)
//Space Complexity O(numberOfCoins*amount)

// Problem successfully compiled on leetcode
// No Problems faced while figuring out the logic

#include<vector>
#include<iostream>
using namespace std;

class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {
        int maxi=INT_MIN;
        for(int i=0;i<nums.size();i++)
        {
            if(nums[i]>maxi)
                maxi=nums[i];
        }
        int indexToSum[maxi+1];
        for(int i=0;i<maxi+1;i++)
        {
            indexToSum[i]=0;
        }
        
        for(int i=0;i<nums.size();i++)
        {
            int index=nums[i];
            indexToSum[index]+=nums[i];
        }
        
        int dp[maxi+1][2];
        dp[0][0]=0;
        dp[0][1]=0;
        
        for(int i=1;i<maxi+1;i++)
        {
            dp[i][0]=max(dp[i-1][0],dp[i-1][1]);
            dp[i][1]=dp[i-1][0]+indexToSum[i];
        }
        return max(dp[maxi][0],dp[maxi][1]);
        
    }
};