// Time Complexity : O(nxm)
// Space Complexity : O(nxm) where m is column size
// Did this code successfully run on Leetcode : Not for [8,10,4,9,1,3,5,9,4,10]. Ran for the initial test cases
// Any problem you faced while coding this : Realized my algorithm is wrong. My brute force ran into time limit exceeded the firdt time itself


// Your code here along with comments explaining your approach

class Solution {
    public int deleteAndEarn(int[] nums){
        if(nums.length==0){
            return 0;
        }
        
        int n = nums.length;
        
        int[][] dp = new int[n+1][2];
        int C = 0;
        int DC = 0;
               
        for(int i=0;i<n;i++){
            //int temp = C;
			//checking if previous numbers have a difference of one with this element, if yes - I take dont choose scenario of previous element
            if(i>0 && (nums[i]+1==nums[i-1]||nums[i]-1==nums[i-1])){
                dp[i][0] = nums[i]+DC; 
                dp[i][1] = C;
            }
            //else if(nums[i]==C){
              //  dp[i][0] = nums[i]+C;
               // dp[i][1] = DC;
            //}
            else{
                dp[i][0] = C + nums[i];
                dp[i][1] = DC;
            }
            C = dp[i][0];
            DC = dp[i][1];
        }
        return Math.max(dp[n-1][0],dp[n-1][1]);
    }
}

//Brute force 

public int deleteAndEarn(int[] nums) {
        return helper(nums,0,0);
    }
    
    public int helper(int[] nums, int index, int points){
        if(index == nums.length){
            return points;
        }
           
        int path1 = helper(nums,calcIndex(nums,index),points+nums[index]);
        
        int path2 = helper(nums,index+1,points);
        
        if(path1>=path2){
            return path1;
        }
        else{
            return path2;
        }
                
    }
    
    public int calcIndex(int nums[], int i){
        int temp = nums[i];
        int upperCheck = temp+1;
        int lowerCheck = temp-1;
        
        i=i+1;
        while(i!=nums.length){
            if(nums[i]==upperCheck || nums[i]==lowerCheck)
                i+=1;
        }
        return i;
    }