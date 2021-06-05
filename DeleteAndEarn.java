// Time Complexity : O(n)+O(max(n)) // n is number of elements in input
// Space Complexity : O(max(n) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


/**
 * 1. Group the elements sum in the index array like 2,2,3 as 0,0,4(2+2),3
 * 2. After that it is same as house robber logic.
 * 3. can not use alternate so house robber DP logic will work.
 */

public class DeleteAndEarn {
	public int deleteAndEarn(int[] nums) {

		int maxEle = nums[0];
		for (int i = 1; i < nums.length; i++) {
			maxEle = Math.max(maxEle, nums[i]);
		}
		
		//prepare an optimized array
		int arr[]= new int[maxEle+1];
		for(int i=0;i<nums.length;i++) {
			arr[nums[i]]=arr[nums[i]]+nums[i];
		}
		
		int chose=arr[0];
		int notChose = 0;
		
		int notChoseTmp;
		for(int row=1;row<arr.length;row++) {
			notChoseTmp=notChose;
			
			notChose= Math.max(chose, notChose);
			chose = arr[row]+notChoseTmp;
		}
		
		return Math.max(chose,notChose);
		
	}

	public static void main(String[] args) {
		int nums[] = new int[] {3,4,2 };
		System.out.println(new DeleteAndEarn().deleteAndEarn(nums));
	}
}
