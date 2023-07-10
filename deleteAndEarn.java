// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }

        int max = 0;
        for(int num : nums){
            max = Math.max(max, num);
        }

        int[] arr = new int[max+1];
        for(int i=0; i<nums.length; i++){
            arr[nums[i]] += nums[i];
        }

        // int[] dp = new int[max+1];
        int prev = arr[0];
        int curr = Math.max(arr[0], arr[1]);

        for(int i=2; i<arr.length; i++){
            int tmp = curr;
            curr= Math.max(curr, arr[i] + prev);
            prev = tmp;
        }

        return curr;
    }
}