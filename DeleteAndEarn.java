package dp3;

public class DeleteAndEarn {
	//Time Complexity : O(n), where n is the length of nums
	//Space Complexity : O(n)
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : Used yesterday's technique from class
	public int deleteAndEarn(int[] nums) {
        int[] count = new int[100001];
        
        for(int i: nums)
            count[i] += i;
        
        int prev1 = 0;
        int prev2 = 0;
        
        for(int i=0; i<count.length; i++) {
            int temp = prev1;
            prev1 = Math.max(count[i] + prev2, prev1);
            prev2 = temp;
        }
        return prev1;
    }
}
