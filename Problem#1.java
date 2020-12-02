// 740. Delete and Earn (PR# 24 S30)


class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] count = new int[10001];
        for (int x: nums) count[x]++;
        int avoid = 0, using = 0, prev = -1;

        for (int k = 0; k <= 10000; ++k) if (count[k] > 0) {
            int m = Math.max(avoid, using);
            if (k - 1 != prev) {
                using = k * count[k] + m;
                avoid = m;
            } else {
                using = k * count[k] + avoid;
                avoid = m;
            }
            prev = k;
        }
        return Math.max(avoid, using);
    }
}

/*

Complexity Analysis

Time Complexity (Java): We performed a radix sort instead, so our complexity is 

O(N+W) where 
W is the range of allowable values for nums[i].

Space Complexity (Java): 
O(W), the size of our count.

*/