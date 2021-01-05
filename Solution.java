// Time Complexity : O(max(nums, n))
// Space Complexity : o(nums)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for(int num: nums)
        {
            max = Math.max(num, max);
        }
        int[] arr = new int[max+1];
        
        for(int num: nums)
        {
            arr[num] += num;  
        }
        int skip = 0;
        int take = arr[0];
        for(int i=0; i <= arr.length-1; i++)
        {
            int temp = skip;
            skip = Math.max(skip, take);
            take = arr[i] + temp;
        }
        return Math.max(skip, take);
    }
}