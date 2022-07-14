// Time Complexity : O(N + k) where k is the maximum element
// Space Complexity : O(N + k)
// Did this code successfully run on Leetcode : Yes

//Problem statement: https://leetcode.com/problems/delete-and-earn/

class Solution {
    private HashMap<Integer, Integer> points = new HashMap<>();
    private HashMap<Integer, Integer> cache = new HashMap<>();

    private int maxPoints(int num) {

        if (num == 0) {
            return 0;
        }
        if (num == 1) {
            return points.getOrDefault(1, 0);
        }
        if (cache.containsKey(num)) {
            return cache.get(num);
        }

        int gain = points.getOrDefault(num, 0);
        cache.put(num, Math.max(maxPoints(num - 1), maxPoints(num - 2) + gain));
        return cache.get(num);
    }

    public int deleteAndEarn(int[] nums) {
        int maxNumber = 0;

        for (int num : nums) {
            points.put(num, points.getOrDefault(num, 0) + num);
            maxNumber = Math.max(maxNumber, num);
        }

        return maxPoints(maxNumber);
    }
}