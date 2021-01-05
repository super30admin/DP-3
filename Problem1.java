/**
 * Time complexity - O(max(nums,dp))
 * Space complexity - O(max(nums))
 * All test cases passed
 */
class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        //Finding out the max of the inpput array
        for(int n: nums)
            max = Math.max(max,n);

        //Creating the array of length max found above
        int[] dp = new int[max+1];
        dp[0] = 0;

        //Filling the dp array with numbers corresponding to the index and do sum if there are multiple occurences
        for(int i=0; i<nums.length; i++)
        {
            dp[nums[i]]=nums[i]+dp[nums[i]];
        }

        int skip = 0;
        int take = dp[0];
        //Solve it using the house robber problem algorithm
        for(int i=1; i<dp.length; i++)
        {
            int temp = take;
            take = dp[i]+skip;
            skip = Math.max(skip,temp);
        }

        return Math.max(skip,take);
    }
}