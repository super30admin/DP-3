// Time Complexity : O(n) , n is length of input array
// Space Complexity : O(n) , where n is the maximum value in the array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nothing specific

//We declared a temp array with the size of the maximum element in the array
//loop through the array and increment the value in the temp array at the index corresponding to value
//the temp array now becomes similar to the house robber problem, where we chose /not choose alternate houses
//get the max value from the last row(from choose/dont choose)

class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] temp=new int[getMax(nums)+1];
        
        for(int num:nums){
            temp[num]+=num;
        }
        int C=0,DC=0,t=0;
        for(int te:temp){
            t=DC;
            DC=Math.max(C,DC);
            C=te+t;
        }
        return Math.max(C,DC);   
        }
    private int getMax(int[] nums){
            int max=0;
            for (int n:nums){
                if(n>max){
                    max=n;
                }
                
            }
            return max;
        }
}