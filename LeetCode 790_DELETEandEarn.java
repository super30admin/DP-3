//approach -  find max val from the  nums

//define new array with length max+1;
// now,  take value of nums[i] --> this value is dp's index-- go to that index, and add the nums[i] to existing value
// now it becomes house robber problem where we are not allowed to take the adjacent indoces. 
// if we choose i we cnt choose i-1 and i+1;
// let say nums.length == n, and max value = m

//TC - O(n)+ O(m) == O(Maxvalueof(m,n))
//space complexity = O(m);


class Solution {
    public int deleteAndEarn(int[] nums) {
        
        if(nums == null || nums.length ==0) return 0;
		
		int max = Integer.MIN_VALUE;
		for(int  i=0; i< nums.length; i++)
		{
			max = Math.max(max, nums[i]);
		}
		
		int[] dp = new int[max+1];
		
		for(int i=0; i< nums.length; i++)
		{
			int idx = nums[i];
			dp[idx] += nums[i];
		}
		
		int skip =0, take = dp[0];
		for(int i=1; i< dp.length; i++)
		{
			int temp =skip; 
			
			skip = Math.max(skip, take);
			take = temp + dp[i];
		}
		return Math.max(skip , take);
	}
}

class Solution {
    public int deleteAndEarn(int[] nums) {
        
        if(nums == null || nums.length ==0) return 0;
        
        //find maximum
        int max = Integer.MIN_VALUE;
        for(int i =0; i< nums.length; i++)
        {
            max = Math.max(max, nums[i]);
        }
        
        //define the new array with length as max+1
        
        int[] dp = new int[max+1];
        
        for(int i=0; i < nums.length; i++)
        {
            int idx = nums[i];
            dp[idx] = dp[idx] + nums[i];
        }
        
        //now it's the house robber problem
        
        int skip = 0, take = dp[0];
        
        for(int i = 1; i< dp.length ;  i++)
        {
            int temp =skip; 
            
            skip = Math.max(skip, take);
            take = temp + dp[i];
        }
        return Math.max(skip, take);
        
    }
}