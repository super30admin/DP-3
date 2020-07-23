// Time Complexity : O(N) where N=Number of anagrams each having length K
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {
        int maxi = 0;
        if(nums.size()==0)
            return 0;
        for(int i=0;i<nums.size();i++)
        {
            if(nums[i] > maxi)
                maxi = nums[i];
        }
        vector<int> nums2(maxi+1,0);
        
        for(int i=0;i<nums.size();i++)
        {
            nums2[nums[i]] = nums2[nums[i]] + nums[i];
        }

        int dont = 0;
        int take = nums2[0];
        for(int i=1;i<nums2.size();i++)
        {
            int temp = dont;
            dont = max(dont,take);
            take = temp + nums2[i];
        }

        return max(dont,take);

    }
};
