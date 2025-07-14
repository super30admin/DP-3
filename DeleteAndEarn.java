//TC: O(n) where n is the max element in the array
//SC: O(1)
//Implemented using House robber pattern initially traverse over the given array to find the max element and 
// create a new array with that max element length and consider the value from given array as index 
// in the new array.
class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for(int i =0; i < nums.length; i++){
            max = Math.max(max, nums[i]);
        }
        int[] arr = new int[max + 1];
        for(int i = 0; i < nums.length; i++) {
            int index = nums[i];
            arr[index] += nums[i];
        }

        int take = 0;
        int skip = 0;
        for(int i = 0; i< max + 1; i++) {
            int tempSkip = skip;
            skip = Math.max(skip, take);
            take = tempSkip + arr[i];
        }
        return Math.max(skip, take);

    }
}