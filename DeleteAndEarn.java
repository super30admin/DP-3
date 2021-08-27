// Time Complexity : O(n) where n is length of new created array (max unique number + 1)
// Space Complexity : O(n) where n is length of new created array (max unique number + 1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        //null check
        if(nums.length == 0 || nums == null) return 0;
        
        int max = Integer.MIN_VALUE; //default value of max initializing
        
        for(int num: nums) {
            max = Math.max(max, num);
        }
        
        int arr[] = new int[max+1]; //declaring a new array to store the values
        
        //traversing through nums array and finding max
        for(int num : nums) {
            arr[num] = arr[num] + num; //arr stores now how much each digit can value
        }
        
        int skip = 0, take = 0; //initializing vars to avoid using array for 0 & 1
        
        for(int i = 0; i < arr.length; i++) {
            int temp = skip; //just in case if the take is bigger than skip
            skip = Math.max(skip, take); //putting max between these inside skip
            take = temp + arr[i]; //adding skip value to next value & putting in take
        }
        
        return Math.max(skip, take); //returning max of 2 values from last row of 0 & 1
    }
}