// Time Complexity : O(n) + O(max(n))
// Space Complexity : O(max(n))
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : Yes

// Your code here along with comments explaining your approach

class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        int[] arr = new int[max + 1];

        for (int num : nums) {
            arr[num] = arr[num] + num;
        }

        // house robber on arr
        int prev = arr[0];
        int curr = Math.max(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            int temp = curr;
            curr = Math.max(temp, arr[i] + prev);
            prev = temp;
        }
        return curr;

    }
}