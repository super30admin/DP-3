// Time Complexity : O(Max(maxElement, numOfElements))
// Space Complexity : O(MaxElement)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach: Transform the input into freq array, from 0 to maxElement
// Then we need to cannot choose concurrent elements in array, which is similar to House robber problem.
public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        if(nums.length==0 || nums==null) return 0;

        //transform
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max=Math.max(nums[i],max);
        }

        int[] dp= new int[max+1];

        for(int num:nums){
            dp[num]+=num;
        }


        int skip=0;
        int take=dp[0];

        for(int i=1;i<dp.length;i++){
            int temp=Math.max(skip,take);
            take=skip+dp[i];
            skip=temp;
        }

        return Math.max(skip,take);
    }
}
