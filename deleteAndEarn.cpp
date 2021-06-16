"""
Intuition:  Check greedy. Greedy will fail.

We will have to browse all possible comvbinations. (Be exhaustive)

We first group all the common elements together. We can then either take or skip the current element. 
This is simiar to the house robber pattern.
#####################################################################
For DP Approach:
Time Complexity : O(Max(N)), max element in N
Space Complexity : O(Max(N)), max element in N
#####################################################################
"""
class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {
        int maxEl = *max_element(nums.begin(), nums.end());
        int preprocessed[maxEl+1];
        for ( int i =0 ; i <= maxEl ; i++){
            preprocessed[i] = 0;
        }

        for ( auto el: nums){
            preprocessed[el] += el;
        }

        int skip = 0, take = 0;
        int previousSkip;
        for ( int i =1 ; i <= maxEl ; i++){
            previousSkip = skip;
            skip = max(previousSkip, take);
            take = previousSkip + preprocessed[i];
        }
        return max(skip, take);
    }
};