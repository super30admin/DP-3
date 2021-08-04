// Time Complexity : O(N)+O(max element)
// Space Complexity :O(max element)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {
        if(nums.empty() || nums.size() == 0){
            return 0;
        }
        int maximum=0;
        for(int i=0; i<nums.size(); i++){
            maximum = max(maximum, nums[i]);
        }
        vector<int> res(maximum+1);
        for(int i=0; i<res.size(); i++){
            res[i] = 0;
        }
        for(int i=0; i<nums.size(); i++){
            res[nums[i]] += nums[i];
        }
        int skip=0, take=res[0];
        for(int i=0; i<res.size(); i++){
            int temp = skip;
            skip = max(skip, take);
            take = temp + res[i];
        }
        return max(skip, take);
    }
};
