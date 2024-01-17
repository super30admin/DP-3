// Time Complexity : O(max(N, M)), where N is the length of the input array nums and M is the maximum value in the array
// Space Complexity :O(M)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

// dynamic programming with a HashMap to store the sum of points for each unique element in the array.
// The algorithm iterates through the array and builds an array maxPoints to store the maximum points that can be earned at each index,
// considering the option of deleting or keeping the current element.
import java.util.HashMap;

public class problem1 {
    public int deleteAndEarn(int[] nums) {
        HashMap<Integer, Integer> points = new HashMap<>();
        int maxNumber = 0;

        for (int num : nums) {
            points.put(num, points.getOrDefault(num, 0) + num);
            maxNumber = Math.max(maxNumber, num);
        }

        int[] maxPoints = new int[maxNumber + 1];
        maxPoints[1] = points.getOrDefault(1, 0);

        for (int num = 2; num < maxPoints.length; num++) {
            int gain = points.getOrDefault(num, 0);
            maxPoints[num] = Math.max(maxPoints[num - 1], maxPoints[num - 2] + gain);
        }

        return maxPoints[maxNumber];
    }
}
