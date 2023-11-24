//  Time Complexity: 3 * O(n)
//  Space Complexity: O(m) where m is maximum of the array
class Solution {
    public int deleteAndEarn(int[] nums) {

        if(nums.length == 1) return nums[0];

        int max = Integer.MIN_VALUE;

        // Find the max value
        for(int i=0; i< nums.length; i++)
            max = Math.max(max, nums[i]);


        int dp[] = new int[max+1];

        // Create a dp with points
        for(int i=0; i<nums.length; i++)
            dp[nums[i]] += nums[i];


        // Same as house robber problem
        int prev = dp[0];
        int curr =  Math.max(dp[0], dp[1]);

        for(int i=2; i< dp.length; i++){
            int temp = curr;
            curr = Math.max(curr, dp[i] + prev);
            prev = temp;
        }
        return curr;
        
    }
}