/*
 ? Problem: House Robber
 * Time Complexity : O(N + M)  --> N = input array length
 * Space Complexity : O(M)  --> M = max number in the input array
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
*/

#include <vector>

class Solution {
public:
    int deleteAndEarn(std::vector<int>& nums) {
        int maxNum = *max_element(nums.begin(), nums.end());

        // Create a vector to store total points for each number - bucket/counting sort variant
        std::vector<int> points(maxNum + 1, 0);
        for (int num : nums) {
            points[num] += num;
        }

        std::vector<int> dp(maxNum + 1, 0);
        dp[1] = points[1];
        for (int i = 2; i <= maxNum; i++) {
            dp[i] = std::max(dp[i - 1], dp[i - 2] + points[i]);
        }

        return dp[maxNum];
    }
};