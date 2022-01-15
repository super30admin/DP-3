// DP Approach
// Form a matrix to store probalble summation solutions from the denominations.
// Check for number of probable solutions by adding the number of previous coins used plus the Denomination before the same case occured 
// Fill the matrix and the last value will give you the no of ways denominations could be used to get to the solution.

// Time Complexity O(m) 
// Space Complexity O(m) where m is maximum number in Nums array
class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums==null) return 0;
        int max = 0;
        for(int i=0;i<nums.length;i++){
            max = Math.max(max, nums[i]);
        }
        int[] arr = new int[max + 1];
        for(int i=0;i<nums.length; i++){
            arr[nums[i]] += nums[i];
        }
        int skip = 0; int take = 0;
        for(int i=0; i<arr.length;i++){
            int temp = skip;
            skip = Math.max(skip,take);
            take = temp + arr[i];
        }
        return Math.max(skip, take);
    }
}