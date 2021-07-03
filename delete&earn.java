// Time Complexity : O(Max(N, Max(nums)))
// Space Complexity : O(Max(nums))
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution1 {
    public int deleteAndEarn(int[] nums) {
        
        //checking edge case
        if(nums == null || nums.length == 0)
            return 0;
        
        int max = Integer.MIN_VALUE;
        
        //Find max value in the nums array
        for(int num: nums){
            if(max < num)
                max = num;
        }
        
        //create a new array of max+1 length
        int[] arr = new int[max+1];
        
        //store the total of each value in its index
        for(int num: nums){
            arr[num] += num;
        }
        
        //set the first choose & don't choose value of first index
        int skip=0, choose=arr[0];
        
        //calucalte echoose & don't choose value for each index
        for(int i=1; i<arr.length; i++){
            int prevSkip = skip;
            skip = Math.max(skip, choose);
            choose = prevSkip + arr[i]; 
        }
        
        //return the max of choose & dont' choose of last index
        return Math.max(skip, choose);
    }
}