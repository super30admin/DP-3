/**
## Problem1: (https://leetcode.com/problems/delete-and-earn/)
 
Time Complexity :   O (M + N) 
Space Complexity :  O (M) 
Did this code successfully run on Leetcode :    Yes (740. Delete and Earn)
Any problem you faced while coding this :       No
 */

 class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        if (nums== null || nums.length == 0)
            return 0;
        
        // calculate the max, to get max array size to store sum
        int max = nums[0];
        for(int num: nums){
            max = Math.max(max, num);
        }
        
        // calculate the sum
        int[] sum = new int[max+1];
        for(int num: nums){
            sum[num] +=num;
        }
        
        // Use DP on new sum
        int prev = 0;
        int curr = sum[1];
        
        for(int i =2; i< sum.length; i++){
            int temp = curr;
            curr = Math.max(curr, prev + sum[i]);
            prev = temp;
        }
        return curr;
    }
    
    public static void main(String args[]) 
    { 
        DeleteAndEarn obj = new DeleteAndEarn();
        int[] nums = {1,2,5};
        System.out.println(obj.deleteAndEarn(nums));
    }
}