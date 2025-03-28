public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        int max = 0;

        for (int num : nums) {
            max = Math.max(max, num);
        }

        int[] arr = new int[max + 1];

        for (int num : nums) {
            arr[num] += num;
        }

        int prev = arr[0];
        int curr = Math.max(prev, arr[1]);
        for (int i = 2; i <= max; i++) {
            int tmp = curr;
            curr = Math.max(arr[i - 1], arr[i] + arr[i - 2]);
            prev = tmp;
        }

        return curr;
    }
}

/**
 * •	We first find the maximum value in nums, since we only need an array up to that value.
 * •	We create a frequency-based array arr, where arr[i] stores the total sum we can earn from selecting i.
 * •	This transforms the problem into a House Robber problem where we must choose numbers optimally to maximize earnings while avoiding adjacent numbers.
 * •	We use dynamic programming with two variables (prev and curr) to keep track of the maximum points without using extra space for a DP array.
 * <p>
 * Time & Space Complexity:
 * •	Time Complexity: O(n + maxValue)
 * •	O(n) to compute max and populate arr
 * •	O(maxValue) for the DP iteration
 * •	Space Complexity: O(maxValue) (for the arr array)
 */