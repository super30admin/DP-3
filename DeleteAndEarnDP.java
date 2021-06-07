package DP3;

//Time Complexity : o(m*n) 
//Space Complexity :o(m*n) 
//Did this code successfully run on Leetcode :Yes
//Any problem you faced while coding this :No

//Your code here along with comments explaining your approach
//get the max in given array and create that size of an array
//place max earnings at each index in same index in the new array
//iterating through new array, create a table and fill in values

public class DeleteAndEarnDP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3,4,2};
		
		int max = deleteAndEarn(nums);
		
		System.out.println(max);

	}

	private static int deleteAndEarn(int[] nums) {
		// TODO Auto-generated method stub
		
		if(nums == null || nums.length == 0) return 0;
		int max = 0;
		for(int i = 0; i < nums.length; i++) {
			max = Math.max(nums[i], max);
		}
		
		int[] arr = new int[max+1];
		
		for(int num : nums) {
			arr[num] += num;
		}
		
		int choose = arr[0];
		int not_choose = 0;
		
		for(int i=0;i<arr.length; i++) {
			int temp = not_choose;
			not_choose = Math.max(not_choose, choose);
			choose = temp + arr[i];
		}
		
		
		return Math.max(choose, not_choose);
	}

}
