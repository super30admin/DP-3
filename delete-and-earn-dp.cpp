// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

#include <iostream>
#include <vector>
#include <unordered_map>
  
using namespace std; 

class Solution {
public:
    int deleteAndEarn(std::vector<int>& nums) {
        std::unordered_map<int, int> count;
        int maxNum = 0;
        for (int num : nums) {
            count[num]++;
            maxNum = std::max(maxNum, num);
        }

        std::vector<int> dp(maxNum + 1);
        dp[1] = count[1];

        for (int i = 2; i <= maxNum; ++i) {
            dp[i] = std::max(dp[i - 1], dp[i - 2] + count[i] * i);
        }

        return dp[maxNum];
    }
}