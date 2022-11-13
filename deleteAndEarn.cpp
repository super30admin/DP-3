// Time Complexity : O(max(n, max(nums))) i.e., we loop through the array of size 100 if there are 100 numbers in the array or if there is just 1 number which is 100
// Space Complexity : O(n) we are using additional space of n to store the extra array and the dp array (columns are constant - 2)
// Did this code successfully run on Leetcode : Yes

/*
top down, we add the max of the 2 choices we have if we are not picking the number, and the "didn't pick" option and the nums total of the repeated numbers if we are picking it
*/

class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {
        if(nums.size() == 0)
            return 0;
        //we create another vector with the combine total of the nums for that index and leave it 0 if that number is not present
        //first get the maximum number from the array to get temp array size
        int max_num = *max_element(nums.begin(), nums.end());
        vector<int> updated_nums (max_num+1,0);
        for(int n:nums)
            updated_nums[n] += n;
        vector<vector<int>> dp (max_num+1, vector<int>(2,0));
        //so we have two options now, pick or don't pick 
        //we will go top-down as we have 0th case as throw away to use
        for(int i=1; i<max_num+1; i++){
            dp[i][0] = max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = updated_nums[i]+dp[i-1][0];
        }
        return (max(dp[max_num][0], dp[max_num][1]));
    }
};