// Time Complexity - O(n)
// Space complexity - O(n)


class Solution {
    public int deleteAndEarn(int[] nums) {
        // initializing a new dp array with maximum number of nums array + 1
        int[] dp = new int[maxNum(nums) + 1];
        // Iterating through the nums array, update the nums array with sum of total number of occurences of a particular number
        for(int i=0; i<nums.length; i++){
            dp[nums[i]] += nums[i]; 
        }
        // Initalizing C to and DC to 0
        int C = 0, DC = 0;
        int temp = -1;
        // Iterating through dp array
        // C would be sum of cuurent value in dp array and DC
        // DC would be max of temp and DC
        for(int x : dp){
            temp = C;
            C = x + DC;
            DC = Math.max(temp, DC);
        }
        return Math.max(C, DC);
    }
    
    // Method to return max number in nums array
    private static int maxNum(int[] nums){
        int max = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            if(nums[i] > max){
                max = nums[i];
            }
        }
        return max;
    }
}

// 2nd approach
// class Solution {
//     public int deleteAndEarn(int[] nums) {
//         int[] arr = new int[maxNum(nums) + 1];
//         int[][] dp = new int[maxNum(nums) + 1][2];
//         for(int i=0; i<nums.length; i++){
//             arr[nums[i]] += nums[i];
//         }
//         for(int i=1; i<dp.length; i++){
//             for(int j=0; j<dp[0].length; j++){
//                 if(j == 0){
//                     dp[i][j] = arr[i] + dp[i-1][j+1];   
//                 }else if(j == 1){
//                     dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]);
//                 }
//             }
//         }
//         return Math.max(dp[dp.length - 1][0], dp[dp.length - 1][1]);
//     }
    
//      private static int maxNum(int[] nums){
//         int max = Integer.MIN_VALUE;
//         for(int i=0; i<nums.length; i++){
//             if(nums[i] > max){
//                 max = nums[i];
//             }
//         }
//         return max;
//     }
// }

// 3rd Approach - Using HashMap
// class Solution {
//     public int deleteAndEarn(int[] nums) {
//         Map<Integer, Integer> map = new HashMap<>();
//         int maxNum = maxNum(nums);
//         int[] dp = new int[maxNum + 1];
//         for(int i=0; i<nums.length; i++){
//             dp[nums[i]] += nums[i]; 
//         }
//         for(int i=0; i<=maxNum; i++){
//              map.put(i, map.getOrDefault(i, 0) + dp[i]);
//         }
        
//         int C = 0, DC = 0;
//         int temp = -1;
//         for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//             temp = C;
//             C = entry.getValue() + DC;
//             DC = Math.max(temp, DC);
//         }
        
//         return Math.max(C, DC);
//     }
    
//     private static int maxNum(int[] nums){
//         int max = Integer.MIN_VALUE;
//         for(int i=0; i<nums.length; i++){
//             if(nums[i] > max){
//                 max = nums[i];
//             }
//         }
//         return max;
//     }
// }