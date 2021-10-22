// Time Complexity : O(max)
// Space Complexity : O(max)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
public class DeleteAndEarn {
	 public int deleteAndEarn(int[] nums) {
	        int max=0;
	        
	        for(int i=0;i<nums.length;i++){
	            if(nums[i]>max){
	                max=nums[i];
	            }
	        }
	        
	        int[] hash=new int[max+1];
	        
	        for(int i=0;i<nums.length;i++){
	            hash[nums[i]]+=nums[i];
	        }
	        
	        int take=0;
	        int skip=0;
	        
	        for(int i=0; i<hash.length;i++){
	            
	            int temp=skip;
	            skip=Math.max(take,skip);
	            take=hash[i]+temp;
	        }
	        
	        return Math.max(skip,take);
	        
	 }
}
