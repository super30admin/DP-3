// Time Complexity : O(n) where n is the number of elements in the nums array
// Space Complexity : O(m) where m is the maximum value in the nums array, due to the space used for the points array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.Arrays;

public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Find the maximum value in the nums array
        int maxVal = Arrays.stream(nums).max().getAsInt();

        // Create an array to store the points for each value
        int[] points = new int[maxVal + 1];

        // Accumulate points for each value in the nums array
        for (int num : nums) {
            points[num] += num;
        }

        int prevSkip = 0; // Initialize points for skipping the current value
        int prevTake = 0; // Initialize points for taking the current value

        // Dynamic programming to calculate maximum points
        for (int i = 1; i <= maxVal; i++) {
            int take = prevSkip + points[i]; // Take the current value and add its points to previous skipped points
            int skip = Math.max(prevSkip, prevTake); // Skip the current value and take the maximum of previous skipped and taken points

            prevSkip = skip; // Update previous skipped points
            prevTake = take; // Update previous taken points
        }

        // Return the maximum of the last skipped and taken points
        return Math.max(prevSkip, prevTake);
    }
}
