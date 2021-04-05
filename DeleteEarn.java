// Time Complexity : O(2^n) where is the length of the array
// Space Complexity : O(n) n is the sisze of the stack and n is the size of the maxArray
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int deleteAndEarn(int[] arr) {
        int max = -1;
        for(int i=0;i<arr.length;i++) {
            max = Math.max(max, arr[i]);
        }
        // construct an array of length max + 1
        int [] nums = new int[max + 1];
        for(int i=0;i<arr.length;i++) {
            nums[arr[i]]++;
        }

        return houseRobber(nums, 0);
    }
    public int houseRobber(int [] nums, int start) {
        if(start == nums.length) {
            return 0;
        }
        // either rob the current house or move to the next house without robbing the currenthouse
        if(start + 2 <= nums.length) {
            return Math.max(nums[start]*start + houseRobber(nums, start + 2), houseRobber(nums, start + 1));
        }
        // just rob the current house
        else {
            return nums[start]*start + houseRobber(nums, start + 1);
        }
    }
}

// Time Complexity : O(n) where is the length of the array
// Space Complexity : O(n) n is the size of the stack and n is the size of the maxArray
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int deleteAndEarn(int[] arr) {
        int max = -1;

        for(int i=0;i<arr.length;i++) {
            max = Math.max(max, arr[i]);
        }
        int [] nums = new int[max + 1];
        for(int i=0;i<arr.length;i++) {
            nums[arr[i]]++;
        }
        Integer[] dp = new Integer[max + 1];
        return houseRobber(nums, 0, dp);
    }
    public int houseRobber(int [] nums, int start, Integer[] dp) {
        // if start goes out of bound
        if(start >= nums.length) {
            return 0;
        }
        // see if we have already solved this subproblem
        if(dp[start] != null) {
            return dp[start];
        }
        // either rob the current house or move to the next house without robbing the currenthouse
        if(start + 2 <= nums.length) {
            return dp[start] = Math.max(nums[start]*start + houseRobber(nums, start + 2, dp), houseRobber(nums, start + 1, dp));
        }
        // just rob the current house
        else {
            return dp[start] = nums[start]*start + houseRobber(nums, start + 1, dp);
        }
    }
}
