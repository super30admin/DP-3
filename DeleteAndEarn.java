// Time Complexity : O(n) where n is max value in the nums array
// Space Complexity : O(n) n is max value in the nums array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        if(nums==null || nums.length == 0){
            return 0;
        }

        int max = Integer.MIN_VALUE;
        for(int num : nums){
            max = Math.max(max, num);
        }
        //Initialize a new array of size say 10000
        int[] transformedNums = new int[max+1];
        
        //Lets store each value in nums in its corresponding index in transformedNums so that its easier to track n+1  and n-1 values for deletion
        for(int i: nums){
            transformedNums[i] = transformedNums[i] + i;
        }
        //Once this is transformed, this is as good a House robber problem where if we choose one index, its +1 and -1 indeces will be deleted.
        int C=0;
        int DC = 0;
        for(int i=0;i<transformedNums.length;i++){
            int temp = DC; 
            //If we don't choose, then we have the max of the previos index values for Choose and Don't Choose
            DC = Math.max(C, DC); 
            //If we choose, then it means we have not chosen the previous index. 
            //So the value will be the Don't choose value of the previous index plus the value at the current index.
            C = transformedNums[i] + temp; 
        }
        return Math.max(C,DC);
        
    }
}