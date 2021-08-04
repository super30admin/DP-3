// Time Complexity : O(N) where N is the number of elements in the nums array
// Space Complexity : O(N) where N is the number of elements in the nums array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope
// Problem Link: https://leetcode.com/problems/delete-and-earn/
// Submission Link: https://leetcode.com/submissions/detail/533215756/

class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {
        int max_val = 0;
        unordered_map<int, int> nums_total;
        
        for(auto num : nums){
            max_val = max(max_val, num);
            nums_total[num] += num;
        }
        
        if(max_val == 0)
            return 0;
        
        int last_second = 0;
        int last_one = nums_total[1];
        int cur;

        for(int i = 2; i <= max_val; i++){
            cur = max(last_one, last_second + nums_total[i]);
            last_second = last_one;
            last_one = cur;
        }
        
        return last_one;
    }
};