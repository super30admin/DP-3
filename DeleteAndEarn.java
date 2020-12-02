/** Given an array nums of integers, you can perform operations on the array.
* In each operation, you pick any nums[i] and delete it to earn nums[i] points. After, you must delete every element equal to nums[i] - 1 or nums[i] + 1.
* Space complexity O(max(size of nums array, size of dp array)). Time complexity O(n)
*
*/
class Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i< nums.length; i++)
        {
            if (nums[i] > max )
            {
                max = nums[i];
            }
        }
        int [] dp = new int [max+1];
        for (int num : nums)
        {
            dp[num] += num;               
        }
        int skip = 0, rob = dp[0];
        for (int i = 1; i< dp.length; i++)
        {
            int temp = skip;
            skip = Math.max(skip,rob);
            rob = temp + dp[i];
        }
        return Math.max(skip, rob);
    }
}
