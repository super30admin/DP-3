// Time Complexity : O(n) + O(max(n)))

// Space Complexity : O(max(n))

// Did this code successfully run on Leetcode : YES

// Appoarch: Preprocessing - first iterated through the array and found the max size
// then created a array of size+1. Iterated through max array and stored the occurances
// in them. Then did tabulation using the new array.

// 740. Delete and Earn

#include <bits/stdc++.h>
using namespace std;


class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {
        int n = nums.size();
        int maxSize = INT_MIN;
        for(int num : nums){
            maxSize = max(maxSize,num);
        }
        vector<int> arr(maxSize+1);
        for(int num : nums){
            arr[num] += num;
        }
        int prev = arr[0];
        int curr = arr[1];
        for(int i=2;i<arr.size();i++){
            int temp = curr;
            curr = max(curr,prev+arr[i]);
            prev = temp;
        }
        return curr;
    }
};