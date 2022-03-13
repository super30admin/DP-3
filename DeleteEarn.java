// Time Complexity : O(max) + O(n)
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//Similar to house robber approach
class DeleteEarn {
    public int deleteAndEarn(int[] nums) {
        int max = nums[0];
        for(int i = 1; i < nums.length; i++){
            max = Math.max(max,nums[i]);
        }
        
        int[] arr = new int[max+1];
        
        // array with total value of original values
        for(int i = 0; i < nums.length; i++){
            arr[nums[i]] = arr[nums[i]] + nums[i];
        }
        
        int skip = arr[0];
        int take = arr[1];
        int tmp = skip;
      
        //skip and take are essentially storing current maximum paths of not choosing that total value
        for(int i = 2; i < arr.length; i++){
            tmp = skip;
            skip = Math.max(skip, take);
            take = tmp + arr[i];
        }
        
        return Math.max(skip,take);
        
    }
}
