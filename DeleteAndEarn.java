// Time Complexity : O(max( nums.length, arr.length))
// Space Complexity : O(arr.length)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Problem in figuring how to use the auxiliary space to reject neighbours from the current index.

// Notes : Convert the input array to an array whose indices are the elements and values are the sum of all occurences of that element, thus, this problem will now be similar to the House Robber problem.

public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        int max = nums[0];
        for(int i = 1; i < nums.length; i++){
            max = Math.max(max, nums[i]);
        }
        
        int[] arr = new int[max+1];
        
        for(int i = 0; i < nums.length; i++){
            arr[nums[i]] = arr[nums[i]] + nums[i];
        }
        
        int skip = 0, take = arr[0];
        
        for(int i = 0; i < arr.length; i++){
            int prevSkip = skip;
            
            skip = Math.max(skip, take);
            take = prevSkip + arr[i];
        }
        
        return Math.max(skip, take);
    }
}
