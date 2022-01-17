// Time Complexity : O(max(n)) + O(n)
// Space Complexity : O(max(n))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0) return 0; //null check
        
        int max = 0;
        
        for(int i = 0; i < nums.length; i++){ // TC: O(n)
            max = Math.max(max, nums[i]); //storing max element bcz we need to create a new array of size max + 1
        }
        
        int[] arr = new int[max + 1]; //new array
        for(int i = 0; i < nums.length; i++){
            arr[nums[i]] += nums[i]; //storing sum of an element at its particular index
        }
        
        //house robber concept
        
        int skip = 0;
        int take = arr[0];
        
        for(int i = 1; i < arr.length; i++){ // TC: O(max(n))
            
            int temp = skip; //storing skip in temp to calculate curr take and alongside not loosing previous skip
            //skip 
            skip = Math.max(skip, take);  
            //take
            take = temp + arr[i]; 
        }
        
        return Math.max(skip, take); 
    }
}