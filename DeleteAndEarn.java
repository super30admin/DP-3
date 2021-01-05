// Time Complexity : O(Max(nums,Max(nums)))
// Space Complexity : O(Max(nums))
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

public class DeleteAndEarn{
    public int deleteAndEarn(int[] nums) {

        int max = 0;
        //find max of given array and create new array w/that length
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > max){
                max = nums[i];
            }
        }

        int[] dp = new int[max + 1];

        //fill in values for each respective number based on given array
        for(int i = 0; i < nums.length; i++){
            dp[nums[i]] += nums[i];
        }

        //solve like house rob problem
        int skip = 0;
        int take = 0;

        for(int i = 0; i < dp.length; i++){
            int temp = skip;

            skip = Math.max(temp,take);
            take = temp + dp[i];
        }

        return Math.max(skip,take);


    }
}