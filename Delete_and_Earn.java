// Time Complexity : O(max(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*Using Dynamic Approach, Similar to house robber
 * Iterate through array and store the max we earned
 * If we choose the earned value, then add the earned value with previous row's not choosen value
 * if we dont choose earned value, then get the max from previous row's values
 * retun the max of last row*/

public class Delete_and_Earn {
	 public static int deleteAndEarn(int[] nums) {
		 if(nums == null || nums.length == 0)
			 return 0;
		 
		 int max = -99999;
		 for(int i=0; i<nums.length; i++)		//iterate and store the max of each
			 max = Math.max(max, nums[i]);
		 
		 int[] earned = new int[max+1];
		 for(int num : nums)
			 earned[num] = earned[num] + num; //if we encounter the number, then add the index to array earned
		 
		 int[][] dp = new int[max+1][2];
		 for(int i=1; i<dp.length; i++) {
			 dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);	// if we dont choose, then get the max from previous row(similar to house robber)
			 dp[i][1] = earned[i] + dp[i-1][0];		//if we choose, add the earned/current value with previous row not choosen value	
		 }
		 
		 return Math.max(dp[max][0], dp[max][1]);	 
	 }
	 
	 public static void main(String[] args) {
		int[] nums = {2, 2, 3, 3, 3, 4};
		System.out.print(deleteAndEarn(nums));
	}
}

/*******************************Recursive*******************************************/


// Time Complexity : O(n * 2^n), n because of search and delete and 2^n nodes
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : For few cases i'm getting expected output, few cases are failing


// Your code here along with comments explaining your approach
/*Recursive Approach with choose and dont choose logic,
 * return the maximum amount earned of all valid paths*/

public class Delete_and_Earn {
	 public static int deleteAndEarn(int[] nums) {
		 int max = -99999;
		 for(int i=0; i<nums.length; i++) {
			 max = Math.max(max, nums[i]);
		 }
		 
		 int[] earned = new int[max+1];
		 for(int num: nums)
			 earned[num] = earned[num] + num;
		 
		 return helper(nums, 0, 0);
		 
	 }
	 
	 public static int helper(int[] nums, int index,int earned) {
		 if(index >= nums.length)		//base case
			 return earned;
		 
		 int choose = helper(nums, index+2, earned+nums[index]);
		 
		 int dontChoose = helper(nums, index+1, earned);
		 
		 return Math.max(choose, dontChoose);
	 }

	public static void main(String[] args) {
		int[] nums = {3, 4, 2};
		System.out.print(deleteAndEarn(nums));
		}
}