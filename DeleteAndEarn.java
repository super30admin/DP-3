// Time Complexity :O(n)+O(max(n))
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int max = 0;
        for (int n : nums) {
            max = Integer.max(max, n);
        }
        int arr[] = new int[max + 1];
        for (int i = 0; i <= nums.length; i++) {
            int curr = nums[i];
            arr[curr] = arr[curr] + curr;
        }

        int prev = arr[0];
        int curr = Integer.max(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            int temp = curr;
            curr = Integer.max(curr, arr[i] + prev);
            prev = temp;
        }
        return curr;
    }
}
