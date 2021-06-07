// Time Complexity : O(3n) ~ O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    int maxValue = 0;
    public int deleteAndEarn(int[] nums) {
        if(nums==null) return 0;
        int max = 0;
        for(int num: nums) {
            max = Math.max(num,max);
        }
        
        int[] arr = new int[max+1];
        for(int i=0;i<nums.length;i++) {
            int index = nums[i];
            arr[index] += nums[i]; 
        }
        int skip = 0; int take = arr[0];
        for(int i=0;i<arr.length;i++) {
            int temp = skip;
            skip = Math.max(skip,take);
            take = temp + arr[i];
        }
        return Math.max(skip, take);
    }    
}