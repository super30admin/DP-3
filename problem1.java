    /**
    Time Complexity : O(N + M)
    Explanation:
    - O(N) to build the frequency/points array
    - O(M) to run DP where M = max value in nums

    Space Complexity : O(M)
    Explanation:
    We use an array of size (max value + 1) for points and DP.

    Did this code successfully run on LeetCode : Yes

    Any problem you faced while coding this :
    Initially tried solving directly on nums which became complex due to
    delete constraints. Then converted the problem to House Robber:
        - Picking number i → cannot pick i-1 and i+1
    So created an array where:
        arr[i] = total points from value i
    and applied standard House Robber DP.
    */

    class Solution {



        public int deleteAndEarn(int[] nums) {
    
            int max = Integer.MIN_VALUE;
            int n = nums.length;
    
            // Find max value
            for (int i = 0; i < n; i++) {
                max = Math.max(max, nums[i]);
            }
    
            // Build points array
            int[] arr = new int[max + 1];
            for (int i = 0; i < n; i++) {
                arr[nums[i]] += nums[i];
            }
    
            int m = arr.length;
    
            // Edge case
            if (m == 1) return arr[0];
    
            int[] dp = new int[m];
            dp[0] = 0;
            dp[1] = Math.max(arr[1], 0);
    
            // House Robber DP
            for (int i = 2; i < m; i++) {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + arr[i]);
            }
    
            return dp[m - 1];
        }
    }