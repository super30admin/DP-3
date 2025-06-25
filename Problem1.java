// Time Complexity : O(nums.length + max(nums[i]))
// Space Complexity : O(max(nums[i]))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Problem1 {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int[] points = new int[max + 1];
        for (int num : nums) {
            points[num] += num; // accumulate total points for each unique number
        }
        int take = 0, skip = 0;
        for (int i = 0; i <= max; i++) {
            int takeNew = skip + points[i]; // take current: add points[i] to previous skip
            int skipNew = Math.max(skip, take); // skip current: take max of previous take or skip
            take = takeNew;
            skip = skipNew;
        }
        return Math.max(take, skip);
    }
}
