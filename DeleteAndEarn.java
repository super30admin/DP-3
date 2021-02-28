// This problem can be brought down to house robber problem with a little modification. 
// I have created the array and at each index I have incremented it's value if that number is present in the inut array
// Then have applied the same logic as the house robber problem to earn more points 

// Time Complexity : O(n), where n is the max element in the input array 
// Space Complexity : O(n), where n is the max element in the input array

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeleteAndEarn {
    public static int deleteAndEarn(int[] nums) {
        int[] countElem = new int[getMax(nums) + 1];

        for (int n : nums) {
            countElem[n] += n;
        }

        int c = 0, dc = 0;
        for (int n : countElem) {
            int temp = dc;
            dc = Math.max(c, dc);
            c = temp + n;
        }
        return Math.max(c, dc);
    }

    private static int getMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int n : nums) {
            if (n > max) {
                max = n;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        List<int[]> input = new ArrayList<>();
        Collections.addAll(input, new int[] { 3, 4, 2 }, new int[] { 2, 2, 3, 3, 3, 4 });

        for (int[] nums : input) {
            System.out.println(deleteAndEarn(nums));
        }
    }
}