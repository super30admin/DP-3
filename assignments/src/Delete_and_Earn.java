import java.util.HashMap;
import java.util.Map;

// Time: O(N+k), Space: O(N+k) where N = length of nums[], k = max number in nums[]

public class Delete_and_Earn {
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> points = new HashMap();
        int max = 0;

        for (int num : nums) {
            points.put(num, points.getOrDefault(num, 0) + num);
            max = Math.max(max, num);
        }

        int maxPoints[] = new int[max+1];
        maxPoints[1] = points.getOrDefault(1,0);

        for (int i = 2; i<maxPoints.length; i++) {
            maxPoints[i] = Math.max(maxPoints[i-1], maxPoints[i-2] + points.getOrDefault(i,0));
        }

        return maxPoints[max];
    }
}