// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : No

class Solution {
    public int deleteAndEarn(int[] nums) {
        // return 0 if array is nul or empty
        if(nums == null || nums.length == 0) return 0;
        // initialize max pointer
        int max = Integer.MIN_VALUE;
        // find max element in the array
        for(int num : nums){
            max = Math.max(max, num);
        }
        // create new auxillary array of length max + 1
        int[] arr = new int[max + 1];
        // fill the array with total values present in the original array
        // corresponsing to value index
        for(int num : nums){
            arr[num] = arr[num] + num;
        }
        // initialize skip and take variables
        int skip = 0;
        int take = 0;
        // iterate through the auxillary array to find the max sum
        for(int i = 0; i < arr.length; i++){
            int temp = skip;
            // if an element is skipped, total value until we skip the element would be
            // max of skip or take of the previous element
            skip = Math.max(skip, take);
            // if an element is chosen, total value until we choose the element would be
            // previous skip plus the value corresponding to that element
            take = temp + arr[i];
        }
        // return the max value between skip and take at the end
        return Math.max(skip, take);
    }
}