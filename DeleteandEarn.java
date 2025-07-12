//TC:O(n+max) sc:O(max) 
class Solution {
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        //find max of nums
        int max = 0;
        for(int i = 0 ; i <n ; i++){
            max = Math.max(max , nums[i]);
        }
        //build a frequency array of size max+1 as 0 is also included
        int[] arr = new int[max+1];
        for(int num : nums){
            arr[num] += num;
        }
         int prev= arr[0]; 
        int curr= Math.max(arr[0] , arr[1] + 0); 
        for(int i = 2 ; i <=max ; i++){
            int temp = curr; 
            curr  = Math.max(curr , arr[i] + prev);
            prev = temp;

        }
        return curr;
        

    }
}


//TC : O(n) SC:O(n)
// class Solution {
//     public int deleteAndEarn(int[] nums) {
//         int n = nums.length;
//         //find max of nums
//         int max = 0;
//         for(int i = 0 ; i <n ; i++){
//             max = Math.max(max , nums[i]);
//         }
//         //build a frequency array of size max+1 as 0 is also included
//         int[] arr = new int[max+1];
//         for(int num : nums){
//             arr[num] += num;
//         }
//         int[] dp = new int[max + 1];
//         dp[0] = arr[0];
//         dp[1] = Math.max(arr[0], arr[1]);

//         for (int i = 2; i <= max; i++) {
//             dp[i] = Math.max(dp[i - 1], arr[i] + dp[i - 2]);
//         }

//         return dp[max];

//     }
// }