/*
Author: Akhilesh Borgaonkar
Problem: LC 740. Delete and Earn (DP-3)
Approach: Using Dynamic Programming approach here to find the pattern of repeating sub-problems. 
Time Complexity: O(n) where n is number of elements in nums[]
Space complexity: O(1) constant
*/

class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] total = new int[100001];
        int skipValue=0, takeValue=0;
        
        for(int n : nums)
            total[n] += n;                          //filling the total[] with sums of indexes in nums[]
        
        for(int i=0; i<total.length; i++){
            int tmp = skipValue;
            skipValue = Math.max(skipValue, takeValue); //if we skip then we take the max of previous values
            takeValue = tmp + total[i];                 //if we take the current value then value will be previous skipValue + total of current index
        }
        return Math.max(skipValue, takeValue);          //again we take the max of last skip and take values
    }
}