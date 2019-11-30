// Time Complexity : O(2^n)
// Space Complexity :O(2^n)
// Did this code successfully run on Leetcode : TLE

class Solution{
	int max = Integer.MAX_VALUE;
	
	public int deleteAndEarn(int[] nums){
		if(nums == null || nums.length ==0){
			return 0;
		}
		helper(nums, 0, 0);
		helper(nums,1, 0);
		return max;
		
	}
	
	private void helper(int[] nums, int i, int sum){
		while(i<nums.length && nums[i] == 0){
			i++;
		}
		//base case
		if(i == nums.length)
			return;
		
		int[] temp = nums.clone();//cloning nums so that we can modify the original array freely and have a temp copy availale to us
		
		int tempSum = sum;
		int prev = nums[i] -1;
		int next = nums[i] +1;
		
		for(int j=i; j< nums.length; j++){
			if(nums[j] == next || nums[j] == prev){
				nums[j] = 0;
			}
		}
		
		sum += nums[i];
		if(sum > max){
			max = sum;
		}
		
		helper(nums, i+1, sum);
		helper(temp, i+1, tempSum);
	}
}
// Time Complexity : O(n)
// Space Complexity :O(1)// as dp array is always of the same size independent of input
// Did this code successfully run on Leetcode : yes
// DP Solution
class Solution{
	public int deleteAndEarn(int[] nums){
		if(nums == null || nums.length ==0){
			return 0;
		}
		int[] dp = new int[10001];
		for(int num : nums){
			dp[num] += num;
		}
			
		int take = 0, skip =0;
		for (int i=1; i< 10001; i++){
			int tempTake = skip + dp[i];
			int tempSkip = Math.max(skip, take);
			take = tempTake;
			skip = tempSkip;
		}
		
		return Math.max(skip,take);
	}
	}
}

