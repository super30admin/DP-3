// Time Complexity : O(M+N)  M = length of array , N=max length of array
// Space Complexity : O(N) - Max length
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// create new array with counting the occurrences of each element in given array 
// save total value of the one element in the specific index of the value in the new array
// this gives new array with order and total value for each array element
// we can choose one element and ignore neighboring elements
// this is similar to house robber 

class Solution {
    public int deleteAndEarn(int[] nums) {   
        int max = 0;
        for(int i =0;i<nums.length;i++){
            if(max<=nums[i]){
                max = nums[i];
            }
        }
        
        int[] a = new int[max+1];
        
        for(int i =0;i<nums.length;i++){
            a[nums[i]] += nums[i]; 
        }
        
        // house robber
        
        int c=0;
        int dc=0;
        
        for(int i =0;i<=max;i++){
            int temp = dc;
            
            dc = Math.max(c,dc);
            c = a[i] + temp;
            
        }
        
        return Math.max(c,dc);
    }
}