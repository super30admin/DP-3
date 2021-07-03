//time n
//space n

class Solution {
    public int deleteAndEarn(int[] nums) {

        int max = Integer.MIN_VALUE;

        for(int n : nums)
        {
            max = Math.max(n,max);
        }

        int[] arr = new int[max+1];

        for(int n : nums)
        {
            arr[n] += n;
        }

        int[] dp = new int[max+1];

        dp[0] = arr[0];
        dp[1] = Math.max(arr[0],arr[1]);


        for(int i=2 ; i<arr.length ; i++)
        {
            dp[i] = Math.max(dp[i-1] , arr[i]+dp[i-2]);
        }

        return dp[dp.length-1];
    }
}
