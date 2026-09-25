// o( M) space complexity where M is max
// o(n + M) time complexity
class Solution {
    public int deleteAndEarn(int[] nums) {
        int m = nums.length;

     

        int max = 0;

        for(int i = 0; i <nums.length; i++){
            max = Math.max(max, nums[i]);

        }
        int[] arr = new int[max+1];


        for(int i = 0; i <nums.length; i++){

            int num = nums[i];
            arr[num] += num;
        }
           int[] dp = new int[max+1];
         dp[0] = arr[0];
         dp[1] = Math.max(arr[0], arr[1]);

         for(int i = 2; i <=max ; i++){
            dp[i] = Math.max(dp[i-1], arr[i]+dp[i-2]);
         }

         return dp[max];

        
    }
}
