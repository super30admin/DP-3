// Time Complexity :length of nums + maxElement in nums
// Space Complexity :-do-
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class DeleteAndEarn {
         // recursive solution
         //Time complexity 2^n(where n is the max value in nums)
         //Space complexity : number of recursive calls  = n maximum number in nums
         public int deleteAndEarnRecursive(int[] nums) {
             //we need to fix the data and make it predictable
             // find max value
             int max = Integer.MIN_VALUE;
             for(int i = 0; i < nums.length; i++) {
                 max = Math.max(max, nums[i]);
             }

             int[] arr = new int[max + 1];
             for(int i = 0; i < nums.length; i++){
                 arr[nums[i]]+=nums[i];
             }

             return helper(arr, 0, 0);

         }

         private int helper(int[] arr, int index, int earnings) {

             if(index >= arr.length) {
                 return earnings;
             }


             //logic
             // case1: choose current value
             int case1 = helper(arr, index + 2, earnings + arr[index]);
             //case2: not choose current value
             int case2 = helper(arr, index + 1, earnings);

             return Math.max(case1, case2);
         }

         // dp solution
         //Time complexity n(where n is the max value in nums)
         //Space complexity : n maximum number in nums
         public int deleteAndEarnDpTabulation(int[] nums) {
             //we need to fix the data and make it predictable
             // find max value
             int max = Integer.MIN_VALUE;
             for(int i = 0; i < nums.length; i++) {
                 max = Math.max(max, nums[i]);
             }

             int[] arr = new int[max + 1];
             for(int i = 0; i < nums.length; i++){
                 arr[nums[i]]+=nums[i];
             }

             int[] dp = new int[arr.length];
             dp[1] = Math.max(dp[0], arr[1]);

             for(int index = 2; index <= max; index++) {
                 dp[index] = Math.max(dp[index - 1], arr[index] + dp[index -2]);
             }

             return dp[max];
         }

        // dp solution space optimized
        //Time complexity n(where n is the max value in nums)
        //Space complexity : constant
        public int deleteAndEarn(int[] nums) {
                //we need to fix the data and make it predictable
                // find max value
                int max = Integer.MIN_VALUE;
                for(int i = 0; i < nums.length; i++) {
                        max = Math.max(max, nums[i]);
                }

                int[] arr = new int[max + 1];
                for(int i = 0; i < nums.length; i++){
                        arr[nums[i]]+=nums[i];
                }

                int temp1 = 0;
                int temp2 = Math.max(temp1, arr[1]);
                int currMax = temp2;
                for(int index = 2; index <= max; index++) {
                        currMax = Math.max(temp2, arr[index] + temp1);
                        temp1 = temp2;
                        temp2 = currMax;
                }

                return currMax;
        }
}