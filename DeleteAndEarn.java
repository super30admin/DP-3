// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : getting started

// Your code here along with comments explaining your approach

public class DeleteAndEarn {

    class Solution {
        public int deleteAndEarn(int[] nums) {
            int max = 10000;
            //count the number of occurence of each number
            int[] count = new int[max + 1];
            for (int x : nums) count[x]++;

            int using = 0, avoid = 0, prev = -1;

            for (int i = 0; i <= max; ++i) {
                if (count[i] > 0) {
                    int m = Math.max(avoid, using);
                    if (i - 1 != prev) {
                        using = i * count[i] + m;
                        avoid = m;
                    } else {
                        using = i * count[i] + avoid;
                        avoid = m;
                    }
                    prev = i;
                }
            }
            return Math.max(using, avoid);
        }

    }
}
