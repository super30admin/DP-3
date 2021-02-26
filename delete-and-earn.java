// Time Complexity : 
O(n) n=size of the nums array

// Space Complexity :

// Did this code successfully run on Leetcode : 
Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class Solution {
    public int deleteAndEarn(int[] nums) {
        
    int [] intermediateArray = new int [maxFunction(nums)+1];
    //Fill the intermediate array
for(int j:nums ){
    intermediateArray[j] += j;
}
    
    int C=0;
    int DC=0;
    for(int k=0; k<intermediateArray.length;k++){
        int temp=DC;
        DC = Math.max(C, DC);
        C = temp + intermediateArray[k];
        
    }
    return Math.max(C,DC);
    }
    
    //find maximum value in the given array to create the intermediate array
    public int maxFunction(int[] nums){
        int maxValue = Integer. MIN_VALUE;
        for(int i: nums){
            maxValue = Math.max(maxValue, i);
        }
        return maxValue;
        }
}