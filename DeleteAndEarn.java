// Approach: Construct sum array and follow house robber pattern to find max points.
// Time complexity: Max(O(max number in nums), O(nums.length))
// Space complexity: O(max number in nums) for sum array
class Solution {
    public int deleteAndEarn(int[] nums) {
        // Find max element in nums
        int max = nums[0];
        for (int num: nums) {
            max = Math.max(max, num);
        }
        // Construct sum array
        int[] sum = new int[max + 1];
        for (int num: nums) {
            sum[num] += num;
        }
        // Choose non adjacent elements in sum
        int pre = sum[0];
        int cur = Math.max(sum[0], sum[1]);
        for (int i = 2; i < sum.length; i ++) {
            int temp = cur;
            cur = Math.max(cur, pre + sum[i]);
            pre = temp;
        }
        return cur;
    }
}