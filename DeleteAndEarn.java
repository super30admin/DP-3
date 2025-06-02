//Problem: Delete and Earn
// Time Complexity : O(n) + O(max(n))
// Space Complexity : O(max(n))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Using DP Approach - bottom-up approach
class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        
        int max = Integer.MIN_VALUE;
        int n = nums.length;
        for(int i=0; i<n; i++){     //O(n)
            max = Math.max(max, nums[i]);
        }

        int[] arr = new int[max+1];
        for(int num : nums){
            arr[num] += num;
        }

        int prev = arr[0];
        int curr = Math.max(arr[0], arr[1]);
        for(int i=2; i<arr.length; i++){  // O(max(n))
            int temp = curr;
            curr = Math.max(curr, prev+ arr[i]);
            prev = temp;
        }

        return curr;
    }
}