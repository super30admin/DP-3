// Time Complexity : o(n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : NO


class Solution {
public:
    int rob(vector<int>& nums) {
        int n = nums.size();
        if(n == 1) return nums[0];
        int skip = 0;
        int prevSkip;
        int took = nums[0];
        for(int i=1;i<n;i++) {
            prevSkip = skip;
            skip = max(skip, took);
            took = nums[i] + prevSkip;
        }
        return max(skip, took);
    }
    int deleteAndEarn(vector<int>& nums) {
        int n = nums.size();
        int maxx = -1;
        for(auto &x : nums) {
            maxx = max(maxx, x);
        }
        vector<int> nums2(maxx+1, 0);
        for(auto &x : nums) {
            nums2[x] += x;
        }
        
        return rob(nums2);
    }
};