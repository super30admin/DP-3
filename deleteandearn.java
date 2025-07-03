
// Time Complexity :O(n+max(n))
// Space Complexity :O(max(n))
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
// Approach: Create an array where each index stores the total sum of all occurrences of that number in the input.
// Iterate through this array while maintaining two values: 'take' and 'skip' for including or excluding the current index.
// At each step, update 'skip' as the maximum of previous 'take' and 'skip', and update 'take' as previous 'skip' + arr[i].
// The result is the maximum of the final 'take' and 'skip' values.

class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
        }
        int [] arr= new int[max+1];
        for(int i=0;i<nums.length;i++){
            int index=nums[i];
            arr[index]=arr[index]+nums[i];
        }
        int take=0;
        int skip=0;
        for(int i=1;i<=max;i++){
            int tempskip=skip;
            skip=Math.max(skip,take);
            take=tempskip+arr[i];
        }

        return Math.max(skip,take);

        
    }
}