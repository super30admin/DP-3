/*

// Time Complexity : O(M+N) - > M = max_element in the array and N = number of elements in the nums array.
// Space Complexity : O(M)-> for creating the hashmap;
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
Preprocess the data to a houserobber problem.


// Your code here along with comments explaining your approach
You find the frequency of each number, store the product of frequency and the number.
Then the problem is similar to house robber problem.

*/

#include<iostream>
#include<vector>

using namespace std;

class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {
        size_t n{nums.size()};
        size_t nums_max = *max_element(nums.begin(),nums.end());
        vector<int> dp(nums_max+1,0);
        for(size_t num:nums){
            dp.at(num)+=num;
        }
        for(size_t i{2};i<=nums_max;++i){
            dp.at(i) = max(dp.at(i-1),dp.at(i)+dp.at(i-2)); // storing value if to choose or not choose that element.
        }
        return dp.at(nums_max);
    }
};