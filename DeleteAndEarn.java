// Time Complexity: O(n)
// Space Complexity: O(n)
// Approach: This is similar to house robber problem except we prepross the array and since it has subproblems, we could
// use dynamic programming with 1D array to achieve linear time complexity
class Solution {
    public int deleteAndEarn(int[] nums) {

        //Validate the inputs
        if (nums == null || nums.length == 0){
            return 0;
        }

        int max = 0;
        for (int num: nums){
            max = Math.max(max, num);
        }

        int n = nums.length;
        int[] arr = new int[max+1];

        //Create preprocessed frequency array
        for(int num: nums){
            arr[num] += num;
        }

        int[] dp = new int[max+1];

        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);

        for (int i=2; i<= max; i++){
            dp[i] = Math.max(dp[i-1], arr[i] + dp[i-2]);
        }

        return dp[max];
    }
}