// Time Complexity : O(n)
// Space Complexity : O(n) extra array used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Delete and Earn

#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {
        if(nums.empty())
            return 0;
        
        int max = 0;
        for(int i = 0; i < nums.size(); i++){
            max = std::max(max, nums[i]);
        }
        
        vector<int> arr(max + 1);
        
        for(int i = 0; i < nums.size(); i++){
            arr[i] = arr[i] + nums[i];
        }
        
        int skip = 0;
        int take = arr[0];
        
        for(int i = 0; i < arr.size(); i++){
            int temp = skip;
            skip = std::max(skip,take);
            take = temp + arr[i];
        }
        
        return std::max(skip,take);
    }
};