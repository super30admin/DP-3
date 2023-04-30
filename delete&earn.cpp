// Time Complexity :O(N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach
// Here approach is similar to the House Robber , Assuming a 2D vector with columns 0 & 1 and at each row
// each point I am calculating what will be the profit if the current house is robbed or not robbed
// Here skip has the value if house not selected ,take has the value if house selected

// But as contrast to House robber here the input array need to be processed as if we select "a" we need to delete "a+1" & "a-1"
// 


class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {
        // for defining the size of an array by finding the max element in nums

        int maxi=INT_MIN;
        for(int i=0;i<nums.size();i++)
        {
            maxi=max(maxi,nums[i]);
        }

        // preprocess the array to apply dp
        vector<int>a(maxi+1);

        for(int i=0;i<nums.size();i++)
        {
            a[nums[i]]+=nums[i];
        }
        
    //   same as house robber
        int skip=0;
        int take=a[0];

        for(int i=0;i<a.size();i++)
        {
        int temp=skip;
        skip=max(skip,take);
        take=temp+a[i];
        }

        return max(skip,take);
    }
};