import java.util.HashMap;

// Time Complexity :length of nums + maxElement in nums
// Space Complexity :-do-
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
public class DeleteAndEarn {
        public int deleteAndEarn(int[] nums) {
                HashMap<Integer, Integer> points = new HashMap<>();
                int maxNumber = 0;

                // Precompute how many points we gain from taking an element
                for (int num : nums) {
                        points.put(num, points.getOrDefault(num, 0) + num);
                        maxNumber = Math.max(maxNumber, num);
                }

                // Declare our array along with base cases
                int[] maxPoints = new int[maxNumber + 1];
                maxPoints[1] = points.getOrDefault(1, 0);

                for (int num = 2; num < maxPoints.length; num++) {
                        // Apply recurrence relation
                        int gain = points.getOrDefault(num, 0);
                        maxPoints[num] = Math.max(maxPoints[num - 1], maxPoints[num - 2] + gain);
                }

                return maxPoints[maxNumber];
        }
}
