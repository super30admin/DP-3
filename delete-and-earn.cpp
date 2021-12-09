//Time complexity : O(max(m , n)) where m is the max_element in input array
//Space complexity : O(max_element)
//Leetcode : Yes
//Approach :
            // Calculate number of occurences of each element in the array
            // Make sure to calculate 0s as well
            // Once array is generated, calculate maximum earnings by including and excluding all the elements

class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {
        if(nums.size() == 0)
            return 0;
        
        vector<int> sum(*max_element(nums.begin(), nums.end()) + 1);
        for(int i = 0 ; i < nums.size(); i++)
        {
            sum[nums[i]] += nums[i];
        }
        
        int tempSkip = 0;
        int skip = 0;
        int take = 0;
        
        for(int i = 0 ; i < sum.size(); i++)
        {
            tempSkip = skip;
            skip = max(skip , take);
            take = tempSkip + sum[i];
        }
        
        return max(skip, take);
    }
};