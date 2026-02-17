// Recursive brute force O(2^n) time, O(n) space
// class Solution {
//     public int deleteAndEarn(int[] nums) {
//         int maxLen = 0; // maxLen will be largest element in nums
//         for (int num : nums) {
//             maxLen = Math.max(maxLen, num); 
//         }
//         int[] arr = new int[maxLen+1]; // +1 to include the max too

//         for (int num : nums) {
//             arr[num] += num; // precompute total points for that num
//         }

//         return helper(0, arr);
//     }
//     // Now it becomes house robber problem
//     public int helper(int i, int[] arr) {
//         if (i >= arr.length) return 0;

//         int pick = arr[i] + helper(i+2, arr);
        
//         int dontPick = helper(i+1, arr);

//         return Math.max(pick, dontPick);
//     }
// }

// Bottom up DP O(n) time, O(n) space
// class Solution {
//     public int deleteAndEarn(int[] nums) {
//         int maxLen = 0; // maxLen will be largest element in nums
//         for (int num : nums) {
//             maxLen = Math.max(maxLen, num); 
//         }
//         int[] arr = new int[maxLen+1]; // +1 to include the max too

//         for (int num : nums) {
//             arr[num] += num; // precompute total points for that num
//         }

//         int n = arr.length;
//         int[] dp = new int[n];

//         dp[0] = arr[0];
//         dp[1] = Math.max(arr[0], arr[1]);

//         for (int i = 2; i < n; i++) {
//             dp[i] = Math.max(dp[i-1], arr[i] + dp[i-2]);
//         }
//         return dp[n-1];
//     }
// }

// Bottom up DP space optimized O(n) time, O(1) space
class Solution {
    public int deleteAndEarn(int[] nums) {
        int maxLen = 0; // maxLen will be largest element in nums
        for (int num : nums) {
            maxLen = Math.max(maxLen, num); 
        }
        int[] arr = new int[maxLen+1]; // +1 to include the max too

        for (int num : nums) {
            arr[num] += num; // precompute total points for that num
        }

        int n = arr.length;

        int prev = arr[0];
        int curr = Math.max(arr[0], arr[1]);

        for (int i = 2; i < n; i++) {
            int temp = curr;
            curr = Math.max(curr, arr[i] + prev);
            prev = temp;
        }
        return curr;
    }
}