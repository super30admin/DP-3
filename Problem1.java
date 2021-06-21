// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums == null)
            return 0;
        int max = 0;
        // find max
        for(int num : nums) {
            max = Math.max(max, num);
        }

        // declare arr
        int[] arr = new int[max + 1];

        // fill arr (arr[index] should have total of all occurences)
        for(int i = 0; i < nums.length; i++) {
            int index = nums[i];
            arr[index] += nums[i];
        }

        // skip/take
        int skip = 0;
        int take = arr[0];
        for(int i = 0; i < arr.length; i++) {
            int temp = skip;
            skip = Math.max(take, skip);
            take = temp + arr[i];
        }
        return Math.max(skip, take);
    }
}