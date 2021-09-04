time complexity: O(n+k)
space complexity: O(1)

class Solution { //
    public int deleteAndEarn(int[] nums) {
       int[] dp = new int[100001]; //creating an array
        
//bucket sort
        for (int num : nums) {
            dp[num] += num;
        }
         
        int prevTake = 0;
        int prevSkip = 0; 
         
        for (int i = 1; i <= 10000; i++) {
            int currTake = prevSkip + dp[i];
            int currSkip = Math.max(prevSkip, prevTake); //getting the max value
             
            prevTake = currTake;
            prevSkip = currSkip;
        }
         
        return Math.max(prevTake, prevSkip);
    }
}