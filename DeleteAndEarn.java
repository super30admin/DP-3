// Time complexity : O(N+K) -> N to populate PointsMap, K to go from 2 to maxNUmber(K)

// Space complexity : O(N) -> create pointsMap

/**
 * Uses dynamic programming to maximize points by treating the problem like the House Robber problem.  
 * Builds a frequency map (`pointsMap`) to store the total points for each unique number, then applies DP to decide whether to take or skip each number.  
 * Maintains two variables (`twoBack` and `oneBack`) to track the max points up to the previous numbers, optimizing space to O(1).
 */

import java.util.*;

class DeleteAndEarn {
    Map<Integer, Integer> pointsMap = new HashMap();

    public int deleteAndEarn(int[] nums) {
        int maxNumber = 0;
        for (int i : nums) {
            pointsMap.put(i, pointsMap.getOrDefault(i, 0) + i);
            maxNumber = Math.max(maxNumber, i);
        }

        int twoBack = 0;
        int oneBack = pointsMap.getOrDefault(1, 0);

        for (int i = 2; i <= maxNumber; i++) {
            int gain = pointsMap.getOrDefault(i, 0);
            int maxPoints = Math.max(oneBack, twoBack + gain);
            twoBack = oneBack;
            oneBack = maxPoints;
        }
        return oneBack;
    }
}

