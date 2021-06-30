// Time Complexity : O(n) + O(max)
// Space Complexity : O(max)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        if(nums == null){
            return 0;
        }
        int max = 0;
        for(int num : nums){
            max = Math.max(max, num);
        }
        
        int[] arr = new int[max + 1]; //O(max) space
        
        for(int i=0; i<nums.length; i++){
            int index = nums[i];
            arr[index] += nums[i];
        }
        
        int skip = 0; 
        int take = arr[0];
        
        for(int i=0; i< arr.length; i++){
            int temp = skip;
            skip = Math.max(skip, take);
            take = temp + arr[i];
        }
        
        return Math.max(skip, take);
    }
}