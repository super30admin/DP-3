// Time Complexity : O(n+k), where k is the max element till which we are iterating
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int deleteAndEarn(int[] nums) {
        //null check
        if(nums == null || nums.length == 0)
            return 0;

        int max = nums[0];

        for(int num : nums){ //O(n)
            max = Math.max(max, num);
        }

        int[] maxArr = new int[max+1];

        for(int num : nums){ //O(n)
            maxArr[num] += num;
        }

        int prev = 0;
        int curr = maxArr[1];

        for(int i = 2; i < maxArr.length; i++){ //O(max element in nums)
            int temp = curr;
            curr = Math.max(curr, prev+maxArr[i]);
            prev = temp;
        }
        return curr;
    }
}