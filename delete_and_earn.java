class Solution{
    public int deleteAndEarn(int[] nums){
        if(nums == null || nums.length == 0) return 0;//base case where we return 0 if we dont have anything in the nums array.
        int max = Integer.MIN_VALUE; //we store the max value in int max
        for(int num : nums){ // we go through each and every element in the array and return the value in variable num
            max = Math.max(max, num); // we store the max value after comparing the previous max value and the current value (num) while iterating through the list.
        }
        int[] dp = new int[max+1]; //we declare a dp array of size max+1 because we need the last index. we create an array of size 6 (0-5) if we have 5 as the largest element so that 5 could be stored at index 5.
        for(int num : nums){ //we will do an another pass here. we go through each and every element here and store the value in num.
            dp[num] = dp[num] + num; // we start storing the values present in the array to the dp which we created with the same index size. suppose we have 2 elements of 5 in the array nums. we create a dp array with size 6 (INDEX 0-5) and store the total sums of the element 5 present in the array at the index number of 5 in the dp array.
        }
        int skip = 0; take = dp[0]; // now we are considering 2 cases. We skip the value and we take the value.
        for(int i = 0; i < max + 1; i++){ // we go through each and every element in the dp array. we have taken max+1 because it is the length of the dp array.
            int temp = skip;
            skip = Math.max(skip, take); // if we skip a value, we take the maximum value between skip and take.
            take = temp + dp[i]; // if we take the value, we check the value of skip, add the value of skip to the dp[i]. Now, because of this, there is a chance that the skip may change. we take care of it by adding a variable temp.
        }
        return Math.max(skip, take); // in the end, we simply return the max of skip and take.
    }
}
//tc - O(m*n) and sc - O(1);