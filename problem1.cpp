// Time Complexity : O(n+max(n))
// Space Complexity : O(max(n))
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// First, calculate the total earnings associated with each number and store it in an array
// Using this array, apply the same logic as house robber, where picking a number eliminates its neighbors
// Use 2 variables, prev and curr to reduce space usage

class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {
        int maxVal = INT_MIN;
        for(int& num : nums) {
            maxVal = max(maxVal, num);
        }
        vector<int> earnings(maxVal + 1, 0);

        for(int& num : nums) {
            earnings[num]+= num;
        }

        int prev = earnings[0];
        int curr = max(earnings[0], earnings[1]);
        
        for(int i=2; i<=maxVal; i++) {
            int temp = curr;
            curr = max(curr, earnings[i] + prev); // max(no pick, pick)
            prev = temp;
        }

        return curr;
    }
};