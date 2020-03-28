// Time Complexity : O(n+max(n)+1)
// Space Complexity :O(max(n))
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

class deketeNum {
    public int deleteAndEarn(int[] nums) {
        //edge case 
        if(nums==null || nums.length==0) return 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<nums.length;i++)
        {
            max = Math.max(max, nums[i]);
        }
        int[] memo =  new int [max+1];
        for(int num:nums)
        {
            memo[num]+=num;   
        }
        int skip = 0, notSkip = 0;
        for(int i = 0 ; i < memo.length;i++)
        {
            int temp = skip;
            skip = Math.max(skip,notSkip);
            notSkip= temp+memo[i];
        }
        return Math.max(skip,notSkip);
        
    }
}