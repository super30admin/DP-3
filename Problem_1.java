

 // Time Complexity : O(n) n is the max of all the numbers in nums
// Space Complexity : O(n) n is the max of all the numbers in nums
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no  


// Your code here along with comments explaining your approach
// Dynamic Programming using house robber problem model.
class Solution {
    public int deleteAndEarn(int[] nums) {
        int max=0;
       for(int num: nums){
           max = Math.max(max, num);
       }
        int[] mnums = new int[max+1];
        for(int num : nums){
            mnums[num] =mnums[num]+ num;
        }
        int skip=0, take=0;
        for(int num : mnums){
            int temp =skip;
            skip= Math.max(skip, take);
            take= temp+num;
        }
        return Math.max(skip,take);
    }
}