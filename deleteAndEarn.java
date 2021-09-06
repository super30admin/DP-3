// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes.
// Any problem you faced while coding this : Understanding the DP solution took some time (especially the last loop), need to improve.


public class deleteAndEarn{
    public int deleteAndEarn(int[] nums) {
        //null case
        if(nums == null || nums.length < 0) return 0;
        int max = Integer.MIN_VALUE;
        
        for(int num : nums) {
            max = Math.max(num, max);
        }

        int[] dp = new int[max + 1];
        for(int num : nums) {
            dp[num] += num;
        }

        int choose = 0, notChoose = 0;
        for(int i = 1; i < dp.length; i++) {
            int temp;
            temp = notChoose;
            notChoose = Math.max(choose, notChoose);
            choose = temp + dp[i]; //the temp plus the element at the i-th index
        }
        return Math.max(choose, notChoose);

    }
}