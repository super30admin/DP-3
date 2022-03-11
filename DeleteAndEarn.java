// Time Complexity : O(n)+O(m); where n is length of input array and m is max number present in nums array
// Space Complexity : O(m); where m is max number present in nums array
public class DeleteAndEarn {
	public int deleteAndEarn(int[] nums) {
		if(nums==null || nums.length==0) return 0;
		if(nums.length==1) return nums[0];
			
		int max=0;
		for(int n:nums) {
			max=Math.max(max, n);
		}
		
		//Create array of max+1 size
		int[] arr = new int[max+1];
		for(int i=0; i<nums.length; i++) {
			arr[nums[i]]+= nums[i];
		}
		
		//Perform house robber on above array
		int skip=0;
		int take=0;
		for(int i=1; i<arr.length; i++) {
			int temp=skip;
			skip=Math.max(skip, take);
			take=temp+arr[i];
		}
		
		//Answer is maximum of final skip/take
		return Math.max(skip, take);
	}
	
	// Driver code to test above 
	public static void main(String[] args) {
		DeleteAndEarn ob= new DeleteAndEarn();
		int[] arr= {2,2,3,3,3,4};
		System.out.println("Min falling path sum is: "+ ob.deleteAndEarn(arr));
	}
}
