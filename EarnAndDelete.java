// Time Complexity : O(N)+O(2^(N-1)) N=No of elements
// Space Complexity : O(N) + O(N) for the two hashmaps
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No
import java.util.HashMap;
import java.util.Map;

public class EarnAndDelete {
    class Solution {
        public int deleteAndEarn(int[] nums) {
            int maxNum = 0;
            Map<Integer, Integer> points =  new HashMap<Integer, Integer>();
            for(int num: nums) {
                points.put(num, points.getOrDefault(num, 0) + num);
                maxNum = Math.max(maxNum, num);
            }
            Map<Integer, Integer> cache =  new HashMap<Integer, Integer>();

            return maxPoints(points, cache, maxNum);
        }

        private int maxPoints(Map<Integer, Integer> points, Map<Integer, Integer> cache, int num) {
            //base
            if(num == 0) return 0;

            if(num==1) return points.getOrDefault(1,0);

            if(cache.containsKey(num)) return cache.get(num);

            //logic
            int gain = points.getOrDefault(num,0);
            //decision 1:don't use num
            int deci1 =  maxPoints(points, cache,num-1);
            //decision2:use that num
            int deci2 = gain + maxPoints(points, cache,num-2);
            cache.put(num, Math.max(deci1,deci2));

            return cache.getOrDefault(num,0);
        }

    }
}