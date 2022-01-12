// Time Complexity : O(n+m) , where n is length of nums and m is range of values for nums
// Space Complexity : O(m) - where m is the range of values for nums
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No Problems faced


// Your code here along with comments explaining your approach
public class Problem1 {
	  public int deleteAndEarn(int[] nums) {
	        int[] values = new int[10001];
	        for (int num : nums)
	            values[num] += num;

	        int take = 0, skip = 0;
	        for (int i = 0; i < 10001; i++) {
	            int takei = skip + values[i];
	            int skipi = Math.max(skip, take);
	            take = takei;
	            skip = skipi;
	        }
	        return Math.max(take, skip);
	    }
}
