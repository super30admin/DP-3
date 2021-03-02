// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int deleteAndEarn(int[] nums) {
     
        if(nums == null || nums.length == 0)return 0;
        int []dp = new int[getMax(nums)+ 1];
        
        for(int x:nums){
            dp[x] += x;
            System.out.println(x);
        }
        
        int C=0, DC = 0;
        
        for(int x:dp){
            int temp = DC;
            DC = Math.max(C,temp);
            C = x + temp;
        }
    return Math.max(C,DC);
    }
    private int getMax(int[] nums){
        int max = Integer.MIN_VALUE;
        for(int x:nums){
            if(x>max)
            {max = x;}
        }
       return max; 
    }
}
//TC O(n) n:max
//SC O(n)