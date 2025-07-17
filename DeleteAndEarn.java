/**
Similar to House robber problem of choose or not choose ie. skip and take
Create a new array of max + 1 length. If 3 is repeated 4 times in input, then in this array arr[3] = 12
If chossing, should ignore the neighbors. Can use a 2D array with 2 columns for skip and take or just use 2 variables.
 */
class Solution {
    public int deleteAndEarn(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            max = Math.max(max, nums[i]);
        }

        int arr[] = new int[max + 1];

        for (int i = 0; i < nums.length; ++i) {
            int index = nums[i];
            arr[nums[i]] += nums[i];
        }

        int skip = 0;
        int take = 0;
        for (int i = 0; i < arr.length; ++i) {
            int tempSkip = skip;
            skip = Math.max(skip, take);
            take = tempSkip + arr[i];
        }

        return Math.max(skip, take);
        
    }
}