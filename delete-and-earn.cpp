/*The idea is to transform the problem into a simplified version where you can earn points by deleting numbers, and then solve it using dynamic programming.
Create an array sortedArr to accumulate the points for each unique number.
Use dynamic programming to find the maximum points that can be earned by either deleting or keeping each number.

Time Complexity: O(N), where N is the maximum number in the input array. The loop iterates through the input array once to create sortedArr, and then another loop iterates through the dp array.
Space Complexity: O(N), where N is the maximum number in the input array. This is due to the creation of sortedArr and dp arrays of size N.*/
#include<bits/stdc++.h>
using namespace std;
class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {
        int maxi=0;
        for(int i=0;i<nums.size();i++){
            maxi=max(maxi,nums[i]);
        }
        vector<int> sortedArr(maxi + 1, 0);
        for(int i=0;i<nums.size();i++){
            sortedArr[nums[i]]+=nums[i];
        }
        vector<int> dp(maxi + 1, 0);
        dp[0]=sortedArr[0];
        dp[1]=max(sortedArr[0],sortedArr[1]);
        for(int i=2;i<=maxi;i++){
            dp[i]=max(dp[i-1],sortedArr[i]+dp[i-2]);
        }
        return dp[maxi];
    }
};