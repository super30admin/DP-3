// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

public int deleteAndEarn(int[] nums) {
    if(nums == null || nums.length == 0) return 0;
    //intializing a max variable to calculate the highest element in the input
    int max = Integer.MIN_VALUE;

    //finding the highest element
    for(int num : nums){
        max = Math.max(max,num);
    }
    //initializing the dp array
    int[] dp = new int[max+1];

    //filling all the profit for the all indexes(number in the input) 
    for(int num : nums){
        dp[num] = dp[num] + num;
    }
    //using 2 variables to calculate the max profit as we have to skip the adjacent elements
    int skip=0, take=dp[0];

    for(int i=1;i<max +1;i++){
        int temp = skip;
        skip = Math.max(skip,take);
        take = temp + dp[i];
    }

    return Math.max(skip,take);
}