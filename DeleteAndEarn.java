// Time Complexity : O(n) + O(max number in arr) - n is number of elements in array.
// Space Complexity : O(max number in arr) 
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :

class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int max = Integer.MIN_VALUE;
        for(int i = 0; i<nums.length; i++) {
            if(nums[i]>max) max = nums[i];
        }

        int[] tempAr = new int[max+1];

        for(int i = 0; i<nums.length; i++){
            tempAr[nums[i]] = tempAr[nums[i]] + nums[i];
        }

        int skip = 0;
        int take = 0;
        int temp = 0;

        for(int i = 0; i<tempAr.length; i++){
            temp = skip;
            skip = Math.max(skip, take);
            take = temp+tempAr[i];
        }

        return Math.max(skip, take);

    }
}