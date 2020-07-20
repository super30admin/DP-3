/**
Problem: Delete And Earn
Time Complexity: O(max(nums)) where max(nums) is the maximum of nums array, as this is the size of the array we create.
Space Complexity: O(max(nums)) where max(nums) is the maximum of nums array.


Approach: Dynamic Programming
1. At first, we find the maximum of the given array of numbers, and create a new array with this size.
2. In this array, we compute the total value earned at a particular index.(i.e, for example there are three 7s, it places them at position 7, and adds them up(21)).
3. Now, we create a new DP matrix, with rows as the indices of the newly created array. 
4. We are presented with two choices, either choose that particular element or do not. If you do not choose, 
then we are free to choose the max of either choosing the previous element or not choosing the previous element.
5. However, if we choose that particular element, then we add its current value to the value we obtain by NOT choosing the previous element.
Return the maximum of the last row.(here's where our max sum lies)
 */

class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        int maximum = Integer.MIN_VALUE;
        for(int i = 0; i<nums.length; i++) {
                maximum = Math.max(nums[i],maximum); //calculate the maximum of the given array.     
        }
        int[] earned = new int[maximum+1];
        for(int num: nums) {
            earned[num] += num; // earned array represents the values earned(
        }
        int dp[][] = new int[maximum+1][2];
        for(int i = 1; i<dp.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]); // not chosen
            dp[i][1] = earned[i] + dp[i-1][0];//chosen
        }
        return Math.max(dp[maximum][0], dp[maximum][1]); //return the maximum of both
    }
}