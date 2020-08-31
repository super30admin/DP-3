package com.Aug2020.dp3;

public class DeleteAndEarn {
	  public static int deleteAndEarn(int[] nums) {
		     
	        int[] dp = new int[10002]; 
	        
	        for(int num : nums) dp[num] += num; 
	        
	        for(int i = 2; i < dp.length; i++){
	            dp[i] = Math.max(dp[i-1], dp[i-2] + dp[i]);
	        }
	        
	        return dp[10001];  
	    }
	public static void main(String[] args) {
		
		System.out.println("Total points earned : "  + deleteAndEarn(new int[]{3,4,2}));
	}
}
