// Time Complexity                              :  O(maximum of max value in the array and array size)
// Space Complexity                             :  O(max value in the array)
// Did this code successfully run on Leetcode   :  Yes
// Any problem you faced while coding this      :  No

#include <bits/stdc++.h> 
using namespace std;  

/*
Problem1: (https://leetcode.com/problems/delete-and-earn/)
*/

class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {
        int n = nums.size();
        
        if(n == 0) return 0;
        int mx = INT_MIN;
        
        // find out the max element in the array
        for(int i=0;i<n;i++) {
            mx = max(mx,nums[i]);    
        }
        // create an array whose size is greater than max element computed above by 1.
        vector<int> dp(mx+1,0);
        
        // store the sum of an element occuring multiple times or just once, in the index = element value.
        for(int i=0;i<n;i++) {
            dp[nums[i]] += nums[i];   
        }
        
        // the skip means the value was not considered.
        // take means the value was considered.
        int skip = 0, take = dp[0];
        
        for(int i=1;i<dp.size();i++) {
            int temp = skip;
            skip = max(skip, take);
            take = temp + dp[i];
        }
        
        return max(skip, take);
        
        
    }
};