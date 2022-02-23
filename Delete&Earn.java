// Time Complexity : O(n) + O(max(n))
// Space Complexity : O(max(n))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    int max = 0;
    public int deleteAndEarn(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max){
                max = nums[i];
            }
        }
        int[] arr = new int[max+1];
        for(int i=0;i<nums.length;i++){
            arr[nums[i]] = arr[nums[i]]+nums[i];
        }
        int skip=0;
        int take=0;
        for(int i=0;i<=max;i++){
            int temp = skip;
            skip = Math.max(skip,take);
            take = arr[i]+ temp;
        }
        return Math.max(skip,take);
    }
}