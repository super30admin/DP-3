// Time Complexity : O(n) where n is the length of the nums array
// Space Complexity : O(n) where n is the range of the elements in the nums array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, had to look up the solution.


// Your code here along with comments explaining your approach


class deleteAndEarn {

    public static int deleteAndEarn(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int[] counts = new int[10001];
        for (int num : nums) {
            counts[num] += num;
        }
        int chosen = counts[0];
        int notChosen = 0;
        for (int i = 1; i < counts.length; i++) {
            int temp = chosen;
            chosen = notChosen + counts[i];
            notChosen = Math.max(temp, notChosen);   
        }
        return Math.max(chosen, notChosen);
    }

	public static void main(String[] args) {
		int[] nums = {2, 2, 3, 3, 3, 4};
		System.out.println(deleteAndEarn(nums));
	}
}