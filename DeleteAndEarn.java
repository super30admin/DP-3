// Time Complexity : O(max(n,m)), where n is the total number of elemets in nums and m is the maximum element in nums
// Space Complexity : O(m), where m is the maximum element in nums
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;
        int max = Integer.MIN_VALUE;
        for(int num :nums){
            max = Math.max(num,max);
        }
        int [] dp = new int[max+1];
        for(int num:nums){
            dp[num]+=num;
        }
        int skip = 0;
        int take = dp[0];
        for(int i =1;i<dp.length;i++){
            int temp = skip;
            skip = Math.max(take,skip);
            take = temp+dp[i];
        }
        return Math.max(skip,take);
    }
}