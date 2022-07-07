//Time Complexity : O(max(n)) + O(n) : Whichever is greater will dictate the time complexity.
//Space Complexity: O(max(n))
//Code run successfully on LeetCode.

public class Problem1_DP {
	
	public int deleteAndEarn(int[] nums) {
      
		if(nums == null || nums.length == 0)
			return -1;
		
		int max = Integer.MIN_VALUE;
		 for(int i =0; i < nums.length; i++) {
			 if(nums[i] > max)
				 max = nums[i];
		 }
		 
		 int[] dp = new int[max +1];
		 
		 for(int num : nums) {
			 dp[num] += num;
		 }
		 
		 int skip = 0;
		 int take = dp[0];
		 int temp = skip;
		 
		 for(int i =1; i < max+1; i++) {
			 temp = skip;
			 skip = Math.max(skip,  take);
			 take = temp + dp[i];
		 }
		 
		 return Math.max(skip, take);
    }

}
