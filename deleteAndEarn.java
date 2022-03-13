// Time Complexity : O(n)+O(max in the array)  where n is no. of elements in nums array
// Space Complexity :O(max in the array)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// CODE

class deleteAndEarn {
    public int DeleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int max = 0;
        for (int val : nums) {
            max = Math.max(val, max); // calculating max value in nums
        }

        int[] arr = new int[max + 1]; // making array of max+1 size
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]] += nums[i]; // storing nums array values in arr[]
        }
        // dp approach(similar to house robber)
        int skip = 0;
        int take = 0;
        for (int i = 1; i < arr.length; i++) {
            int temp = skip; // storing skip value in a temp variable as skip value is changing
            skip = Math.max(skip, take); // not choose case
            take = arr[i] + temp; // choose case
        }
        return Math.max(skip, take); // returning max of skip and take
    }
}