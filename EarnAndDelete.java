// Time Complexity : O(n+max(nums))  n=number of elements in array. nums = input array
// Space Complexity :O(max(nums))   
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No



class Solution {
	public static int deleteAndEarn(int[] nums) {
		int length = nums.length;
		int max = nums[0];
		for (int i = 0; i < length; i++) {
			if (max < nums[i]) {
				max = nums[i];
			}
		}
		int[] arr = new int[max + 1];
		for (int i = 0; i < length; i++) {
			arr[nums[i]] += nums[i];
		}
		int dont = 0;
		int del = 0;
		int temp = 0;
		for (int i = 0; i < arr.length; i++) {
			temp = dont;
			dont = Math.max(dont, del);
			del = temp + arr[i];
		}
		return Math.max(dont, del);
	}

	public static void main(String args[]) {
		System.out.print(deleteAndEarn(new int[] { 3, 4, 2 }));
	}
}