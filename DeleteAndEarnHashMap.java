// This is little same as the array implementation, here instead of an array a hashmap is used as array wastes lot of space 

// Time Complexity : O(n), where n is the number of elements in the input array
// Space Complexity : O(n), where n is the number of elemens in the input array

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeleteAndEarnHashMap {
    public static int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + n);
        }

        int pre = 0, curr = 0;
        for (int n : map.keySet()) {
            if (!map.containsKey(n - 1)) {
                pre = curr;
                curr += map.get(n);
            } else {
                int temp = Math.max(pre + map.get(n), curr);
                pre = curr;
                curr = temp;
            }
        }
        return curr;
    }

    public static void main(String[] args) {
        List<int[]> input = new ArrayList<>();
        Collections.addAll(input, new int[] { 3, 4, 2 }, new int[] { 2, 2, 3, 3, 3, 4 });

        for (int[] nums : input) {
            System.out.println(deleteAndEarn(nums));
        }
    }
}
