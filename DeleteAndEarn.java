// Time Complexity : O(n)+O(max(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length==0) return -1;
        int max=0;
        for(int num:nums)
        {
            max= Math.max(max,num);   // Find max element
        }
        int[] arr = new int[max+1];   // Make an array of size of max element 
        arr[0]=0; // Intialize 0th index with 0
      
        for(int i=0;i<nums.length;i++)
        {
           
            arr[nums[i]]+=nums[i];   
    // here caluculate cumulative sum of each element store at its corresponding index;
   
        }
        int previous = arr[0];
        int curr = Math.max(arr[0], arr[1]);
        for(int i=2; i<arr.length;i++)
        {
            int temp = curr;
            curr = Math.max(curr,  previous+arr[i]);
            previous= temp;
        }
        return curr;
    }
}