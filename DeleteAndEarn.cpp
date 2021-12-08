// Time Complexity : max(O(n), O(largest element))
// Space Complexity : O(largest element)
// Did this code successfully run on Leetcode : yes


// Your code here along with comments explaining your approach
/* Create a sum array to store sum for each element by adding all occurences of that element.
 * For every element in sum we have two choices either to take or skip element.
 * If we skip the element then the max sum we get is max of previous element skip and take amount.
 * If we take the element then the total max sum is previous element skip value + current sum value.
 * Return the max of take and skip.
 */


class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {  
        if (nums.size() == 0)
            return 0;
        
        int skip, take;
        skip = take = 0;
        int m = *max_element(nums.begin(), nums.end());
        int sum[m + 1];
        
        for (int i = 0; i < m + 1; i++)
        {
            sum[i] = 0;
        }
        
        for (int i = 0; i < nums.size(); i++)
        {
            sum[nums[i]] += nums[i];
        }
        
        int new_skip, new_take;
        for (int ele : sum)
        {
            new_skip = max(skip, take);
            new_take = skip + ele;
            
            skip = new_skip;
            take = new_take;
        }
        
        return max(skip, take);
    }
};