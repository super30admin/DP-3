class DeleteAndEarn {

    // Time Complexity : 0(max(n,k)) Where n is the length of the array and k is the maximum element in the array
// Space Complexity : 0(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: First, I found ou the maximum value in the array nums. Then i
    //created an array named Dp to store the total sum of the total occurence of each element. Eg, if 2 occurs 3 times, then
    //the sum would be 6. After that I applied normal Robberr's problem's solution to my dp array.


    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int length = nums.length;
        int max = Integer.MIN_VALUE;
        for(int num: nums){
            max = Math.max(max,num);
        }
        int[] dp = new int [max + 1];
        for(int num: nums){
            dp[num] = dp[num] + num;
        }
        int skip = 0;
        int take = dp[0];
        for(int i = 1; i< dp.length; i++){
            int temp = skip;
            skip = Math.max(skip, take);
            take = temp + dp[i];
        }
        return Math.max(skip,take);
    }
}