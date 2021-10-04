//Time Complexity: O(Max(len of nums, Max value in nums))
//Space Complexity: O(Max value in nums)
class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] arr = new int[getMax(nums) + 1];
        int c = 0;
        int dc = 0;
        for(int x: nums) arr[x] += x;

        for(int x: arr)
        {
            int temp = dc;
            dc = Math.max(c,dc);
            c = temp + x;
        }
        return Math.max(c,dc);
    }
    private int getMax(int[] nums)
    {
        int max = Integer.MIN_VALUE;
        for(int x: nums) max = Math.max(x, max);
        return max;
    }
}