// TC: O(MAX(max(n),n))
// SC: O(max(max(n)))

class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        int max = Integer.MIN_VALUE;
        for(int num : nums){
            max = Math.max(max,num);  //identify the max element in the array
        }
        int[] dp = new int[max+1];  // initialise 1-D array of length max element+1
        
        for(int num : nums){
            dp[num] = dp[num] + num;  // add the number to its index
        }
        
        int skip=0,take=dp[0];   
        for(int i=1;i<max+1;i++){
            int temp = skip;  // store skip in temp to be used in take
            skip = Math.max(skip,take);  // get maximum of previous two values
            take = temp + dp[i];  // store take as previous skip + current value
        }
        return Math.max(skip,take);  // return maximum of the two
    }
}