// Time Complexity : O(max element).
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int deleteAndEarn(int[] nums) {
     
        if (nums == null || nums.length == 0)
			return 0;

		int max = 0, k = 0,l=1;
		for (int num : nums) {
			max = Math.max(max, num);
		}
		int[] count = new int[max + 1];
		for (int i = 0; i < nums.length; i++)
			count[nums[i]] +=1;

		int[] res = new int[max + 1];
		

		for (int num = 1; num <= max; num++) {

			k = Math.max(num - l - 1, 0);
			res[num] = Math.max(res[num - 1], num * count[num] + res[k]);
		}

		return res[max];
    }
}
