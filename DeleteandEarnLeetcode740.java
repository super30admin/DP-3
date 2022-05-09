//Time Complexity: O(total number of elements + max_number) >>>O(N) can consider this as N as everything is still single pass
//Space Complexity O(N) extra hashmaps
//Leetcode : Yes.
import java.util.HashMap;

public class DeleteandEarnLeetcode740 {

    class Solution {

        private HashMap<Integer, Integer> freq_points = new HashMap<>();
        private HashMap<Integer, Integer> memoization = new HashMap<>();

        private int maxHelper(int num) {
            // base case for 0 and 1 becasue if we choose  0 we will delete 1 as we have to  delete number + 1
            //so 0 will also be zero no matter how many times it appeared.
            if (num == 0) {
                return 0;
            }
            // base case for 1 becasue if we choose 1 we will delete 2 as we have to  delete number + 1
            //next number after 1 wil be 0 which will give so no need to go forward jsut return 1 when we see it
            if (num == 1) {
                return freq_points.getOrDefault(1, 0);
            }

            if (memoization.containsKey(num)) {
                return memoization.get(num);
            }

            // choose the current number (current number * how many times it has appeared)
            //first case take the number, then we cannot choose the number - 1 as we have to delete that
            int case1 = freq_points.getOrDefault(num, 0) + maxHelper(num - 2);
            //if we don't choose the current number (which is greater than all numbers left we choose number -1)
            int case2 = maxHelper(num -1);

            memoization.put(num, Math.max(case1, case2));

            return memoization.get(num);
        }

        public int deleteAndEarn(int[] nums) {
            int max = 0;

            // Precompute how many points we gain from taking an element
            for (int number : nums) {
                freq_points.put(number, freq_points.getOrDefault(number, 0) + number);
                max = Math.max(max, number);
            }

            return maxHelper(max);

        }

    }
}
