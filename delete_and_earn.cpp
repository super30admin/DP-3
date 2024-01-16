// Time Complexity : O(n)
// Space Complexity : O(max(n))
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
// Idea here is we calculate total points earned in each case and we take the min value.

#include<vector>
#include <limits>

class Solution {
public:
    int deleteAndEarn(std::vector<int>& nums) {
        int n = nums.size();

        if(n == 0)
        {
            return 0;
        }
        if(n < 2)
        {
            return nums[0];
        }
        
        int max = INT_MIN;
        for(int i = 0; i < n; i++)
        {
            max = std::max(nums[i], max);
        }

        int arr[max+1];

        for(auto num : nums)
        {
            arr[num] += num;
        }

        int prev = arr[0];
        int curr = arr[1];
        int m = sizeof(arr)/sizeof(arr[0]);

        for(int i = 2; i < m; i++)
        {
            int temp = curr;
            curr = std::max(curr, arr[i]+prev);
            prev = temp;
        }
        return curr;
    }
};