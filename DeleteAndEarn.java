// Time Complexity : O(n*log(n)) to sort the input array of length n
// {(O(n*logn)) + (O(n)) --> O(n*logn)}
// Space Complexity :O(n) as we need to create an array of length n
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :

import java.util.Arrays;
class DeleteAndEarn {
    private int[] dp;

    public int deleteAndEarn(int[] nums)
    {
        if(nums == null || nums.length < 1) {
            return 0;
        }
        dp = new int[nums.length];
        Arrays.sort(nums); //O(nlog(n))
        return getMaxPoints(nums);
    }


    private int getMaxPoints(int[] nums)
    {
        dp[0] = nums[0];
        for(int i =1; i <nums.length; i++) {
            int case0 = dp[i-1];
            int j = i-1;
            int currentValue = nums[i];
            int profit = currentValue;
            while(j >=0 && nums[j] >= currentValue-1) {
                if(nums[j] == currentValue){
                    profit = profit + currentValue;
                }
                j--;
            }
            int case1;
            if(j == -1){
                case1 =  profit;
            }
            else{
                case1 = profit + dp[j];
            }
            dp[i] = Math.max(case0, case1);
        }
        return dp[nums.length -1];
    }

    public static void main(String[] args) {
        DeleteAndEarn obj = new DeleteAndEarn();
        int[] nums ={3, 4, 2};
        System.out.println(obj.deleteAndEarn(nums));
    }
}