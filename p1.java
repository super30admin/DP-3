//time complesity : O(n^2)
//space complexity : O(1)

class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums.length == 0 ){
            return 0;
        }

        int[] dp = new int[getmax(nums) + 1];

        for(int x: nums){
            dp[x] = dp[x] + x;
        }

        int c = 0;
        int dc = 0;

        for(int x : dp){
            int temp = dc;
            dc = Math.max(c,dc);
            c = temp + x;

        } return Math.max(c,dc);
    }
    private int getmax(int[] nums){
        int max = Integer.MIN_VALUE;
        for(int x : nums){

            max = Math.max(max,x);
        } return max;
    }
}
