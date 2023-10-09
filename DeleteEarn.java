// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class DeleteEarn {
    class Solution {
        public int deleteAndEarn(int[] nums) {
            int n = nums.length;
            if(n == 1) return nums[0];
            int max = Integer.MIN_VALUE;
            for(int num : nums){
                if(num > max){
                    max = num;
                }
            }

            int dp[] = new int[max + 1];

            for(int num : nums){
                dp[num] += num;
            }

            int prev = dp[0], cur = Math.max(dp[0], dp[1]);
            int dpLen = dp.length;
            for(int i = 2; i < dpLen; i++){
                int temp = cur;
                cur = Math.max(cur, (prev + dp[i]));
                prev = temp;
            }
            return cur;
        }
    }
}
