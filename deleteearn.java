//Time Complexity: O(n + m)
//n = nums.length → to build the pointsMap
//m = range from minNum to maxNum 
//Space Complexity: O(m) - For the pointsMap storing cumulative points for each unique number in the range [minNum, maxNum].

//Build a map where pointsMap[num] = num * frequency, to simulate earning points from deleting num.
//for each number, choose whether to take (delete) it and skip the previous, or skip it.
//Track the max points using two variables (prev, curr) and return curr as the final result.


class Solution {
    public int deleteAndEarn(int[] nums) {
        HashMap<Integer, Integer> pointsMap = new HashMap<>();

        int minNum = Integer.MAX_VALUE;
        int maxNum = 0;

        for (int num : nums) {
            pointsMap.put(num, pointsMap.getOrDefault(num, 0) + num);
            minNum = Math.min(minNum, num);
            maxNum = Math.max(maxNum, num);
        }

        int prev = pointsMap.getOrDefault(minNum, 0);
        int curr = prev;

        if (pointsMap.containsKey(minNum + 1)) {
            curr = Math.max(prev, pointsMap.get(minNum + 1));
        }

        for (int num = minNum + 2; num <= maxNum; num++) {
            int temp = curr;
            if (pointsMap.containsKey(num)) {
                curr = Math.max(curr, pointsMap.get(num) + prev);
            }
            prev = temp;
        }

        return curr;
    }
}
