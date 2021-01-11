// Time Complexity : O(max(max(nums), nums))
// Space Complexity : O(max(nums))
// Did this code successfully run on Leetcode : Yes


class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int max = 0;
        for(int num: nums)
            max = Math.max(max, num);
        
        int[] arr = new int[max + 1];
        for(int num: nums)
            arr[num] =  arr[num] + num;
        
        int skip = 0; int take = arr[0];
        for(int i =1; i < arr.length; i++){
            int temp = skip;
            skip = Math.max(skip, take);
            take = temp + arr[i];
        }
        return Math.max(skip, take);
    }
}