// Time Complexity : O(max(M,N)), M -> maximum element in the nums array, N-> frequency of elements
// Space Complexity :  O(M),  M -> maximum element in the nums array,
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class DeleteEarn{
	
	public int deleteandearn(int[] nums) {
		
        //checking whether the input array nums is empty or not
		if(nums==null || nums.length==0) {
			return 0;
		}

        //finding the maximum value among the elements in nums array		
		int max=Integer.MIN_VALUE;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]>=max) {
				max=nums[i];
			}
		}
		
        
		int[] dp = new int[max+1];

        //filling the dp array with frequency of num at index "num"
		for(int i=0;i<nums.length;i++) {
			dp[nums[i]]=dp[nums[i]]+nums[i];
		}
		
        //following house approach, as to choose that particular number to determine the max output
		int skip=0,take=0;
		for(int i=0;i<dp.length;i++) {
			int temp = Math.max(skip, take);
			take = skip +dp[i];
			skip = temp;
		}
		return Math.max(skip,take);
		
	}
	
	public static void main(String[] args) {
		DeleteEarn d = new DeleteEarn();
		int[] nums = {2,2,3,3,4};
		System.out.println(d.deleteandearn(nums));
	}
}