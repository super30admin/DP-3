// Problem - Delete and earn
//  Time Complexity : O(n)
//  Space Complexity : O(n)
//  Did this code successfully run on Leetcode : Yes
//  Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// 1. We first group the values in a new array
// 2. Now this converts to a house robber problem where we cannot take adjacent
// values
// 3. We use two variables to keep track of currMax and prev and then return the
// curr

#include <bits/stdc++.h>
using namespace std;
class Solution {
public:
  int deleteAndEarn(vector<int> &nums) {
    int n = (int)nums.size();
    int SIZE = 1e4;
    vector<int> newnums(SIZE + 1, 0);
    for (int i = 0; i < n; i++) {
      newnums[nums[i]] += nums[i];
    }

    int prev = newnums[0];
    int curr = newnums[1];

    for (int i = 2; i <= SIZE; i++) {
      int temp = curr;
      curr = max(curr, newnums[i] + prev);
      prev = temp;
    }

    return curr;
  }
};
