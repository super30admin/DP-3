// Time Complexity : O(n)
// Space Complexity :  O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this - 

class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {
        
        vector<int> lookup(40010, 0);
        int i;
        
        for(i = 0; i < nums.size(); i++)
        {
            lookup[nums[i]] += nums[i];   
        }
        
        int max_num = 0;
        
        for(i = 0; i <= 40000; i++)
        {
            if(i > 3)
            {
                lookup[i] = max(lookup[i]+lookup[i-2], lookup[i]+lookup[i-3]);
            }
            else if(i > 2)
            {
                lookup[i] = lookup[i] + lookup[i-2];
            }
            
            max_num = max(max_num, lookup[i]);
        }
        
        return max_num;
    }
};