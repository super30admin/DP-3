// Time Complexity :O(n+max(n)) //where n is the nums array
// Space Complexity :O(max(n)) //where n is the nums array
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

// Your code here along with comments explaining your approach
public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int max = 0;
        // first get max value in the array as array is not sorted.
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        int[] data = new int[max + 1];
        // process the data
        for (int i = 0; i < nums.length; i++) {
            data[nums[i]] += nums[i];
        }
        int skip = 0, take = 0;
        for (int i = 0; i < data.length; i++) {
            int temp = skip;
            // skip
            skip = Math.max(skip, take);
            // take
            take = temp + data[i];
        }
        return Math.max(skip, take);
    }
}
