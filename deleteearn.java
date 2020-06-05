// Time Complexity :O(n) n - length of nums 
// Space Complexity :O(1) as length of copy is a constant its negligible
// Did this code successfully run on Leetcode :yes 
class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] copy=new int[10001];
        for(int i=0;i<nums.length;i++)
        {
          copy[nums[i]]+=nums[i]; //storing all the copies of each number in a cell with index as the number
        }
        // now we have the array where we cant use the alternate value.  Just like House robber Problem
        for(int i=2;i<copy.length;i++)
        {
            copy[i]=Math.max(copy[i]+copy[i-2] , copy[i-1]);
        }
        return copy[10000];
    }
}