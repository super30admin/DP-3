// Time Complexity :O(max(m,n))where n is the length of the given array and m is the maximum element in that array.
// Space Complexity :O(m)m is the maximum element in the given array.
// Did this code successfully run on Leetcode :yes
/*Here, we are using an extra array of size equal to maximum value in the given array
to store the sum that each no. as this helps in keep track of the same number which when does not appear
 in a consecutive manner.skip variable denotes the number is skipped which means we can consider
the max(previous skip + previous take )value. take variable denotes that the number is picked,
which means that the previous number is not picked so, the take value is current number value +
previous skip */


class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;
        int max=Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++)
            max=Math.max(max,nums[i]);

        int[] dp=new int[max+1];
        for(int i=0;i<nums.length;i++){
            dp[nums[i]]=dp[nums[i]]+nums[i];
        }

        int skip=0,take=dp[0];
        for(int i=1;i<max+1;i++){
            int temp=skip;
            skip=Math.max(skip,take);
            take=temp+dp[i];

        }

        return Math.max(skip,take);
    }
}
