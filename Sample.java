// # DP-3
// ## Problem1: (https://leetcode.com/problems/delete-and-earn/)
// Time Complexity : O(2 ^ n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I didnt face any problem while coding this


// Your code here along with comments explaining your approach
// Brute force approach
class Solution {
    public int deleteAndEarn(int[] nums) {
        //find maximum number
        if(nums == null || nums.length == 0) return 0;
        int max =  Integer.MIN_VALUE;
        for(int num: nums){
            max = Math.max(max, num);
        }
        int[] arr = new int[max+1];
        for(int num: nums){
            arr[num] += num;
        }
        return helper(arr, 0, 0);
    }
    private int helper(int[] arr, int index, int totalAmount){
        if(arr == null) return 0;
        if(index >= arr.length) return totalAmount;
        int case1 = helper(arr, index+1, totalAmount);
        int case2 = helper(arr, index+2, totalAmount+arr[index]);
        return Math.max(case1, case2);

    }
}

// Time Complexity : O(n) + O(max(m))
// Space Complexity : O(max(m))
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I didnt face any problem while coding this

class Solution {
    public int deleteAndEarn(int[] nums) {
        //find maximum number
        if(nums == null || nums.length == 0) return 0;
        int max =  Integer.MIN_VALUE;
        for(int num: nums){ //O(n) number of elemnts in the num array
            max = Math.max(max, num);
        }
        int[] arr = new int[max+1];
        for(int num: nums){ //O(n)
            arr[num] += num;
        }
        int prev = arr[0];
        int curr = arr[1];

        for(int i=2; i<arr.length; i++){ //O(max(m)) - maximum number of elements in the array
            int temp = curr;
            curr = Math.max(curr, prev+arr[i]);
            prev = temp;
        }
        return curr;

    }
}

// ## Problem2 (https://leetcode.com/problems/minimum-falling-path-sum/)
// Time Complexity : O(n ^ 2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I didnt face any problem while coding this

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n+1][n+1];
        for(int i=n-1; i>=0; i--){
            for(int j=0; j<n; j++){
                if(j == 0){
                    dp[i][j] = matrix[i][j] + Math.min(dp[i+1][j],dp[i+1][j+1]);
                }
                else if(j == n-1){
                    dp[i][j] = matrix[i][j] + Math.min(dp[i+1][j],dp[i+1][j-1]);
                }else{
                    dp[i][j] = matrix[i][j] + Math.min(dp[i+1][j],Math.min(dp[i+1][j+1],dp[i+1][j-1]));
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < matrix.length; j++) {
            min = Math.min(min, dp[0][j]);
        }
        return min;
    }
}