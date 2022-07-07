//Time Complexity: O(2^n)
//Space Complexity : O(n)
//Solution accepted, but Time Limit Exceeded due to Exhaustive Search.

public class Problem1_ExhaustiveSearch {
	
    public int deleteAndEarn(int[] nums) {
   	 
	 if(nums == null || nums.length == 0)
		 return -1;
	 
	 int max = Integer.MIN_VALUE;
	 for(int i =0; i < nums.length; i++) {
		 if(nums[i] > max)
			 max = nums[i];
	 }
	 
	 int[] arr = new int[max + 1];
	 
	 for(int i =0; i < nums.length; i++)
		 arr[nums[i]] += nums[i];
	 
	 return helper(arr,0,0);
    
   }
 
    private int helper(int[] nums, int index, int amount) {
	 
	 if(index >= nums.length)
		 return amount;
		 
	 //do not choose current index
	 int case1 = helper(nums, index + 1 , amount);
	 
	 //choose current index
	 int case2 = helper(nums, index +2, amount + nums[index]);
	 
	 return Math.max(case1, case2);
   }
}
