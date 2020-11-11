
public class DeleteAndEarn {
	//	Time:  O(n) 
	//	Space O(1) only 10000-constant
	//	LeetCode: yes
	class Solution {
	    public int deleteAndEarn(int[] nums) {
	    	
	    	if(nums == null || nums.length==0) return 0;
	        
	        int[] dp = new int[10001];
	        
	        for(int i=0; i < nums.length ; i++){
	            dp[nums[i]] += nums[i];  
	        }
	        
	        int take=0;
	        int skip =0;
	        for(int i =0; i <=10000;i++){
	            int tempTake = skip + dp[i];
	            int tempSkip = Math.max(take,skip);
	            take = tempTake;
	            skip = tempSkip;
	        }
	        
	        return Math.max(take,skip);
	    }
	}
}
