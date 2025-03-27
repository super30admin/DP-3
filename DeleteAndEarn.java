package s30.week2;

/*
 * https://leetcode.com/problems/delete-and-earn/description/
 * You are given an integer array nums. You want to maximize the number of points you get by performing the following operation any number of times:
 * Pick any nums[i] and delete it to earn nums[i] points. Afterwards, you must delete every element equal to nums[i] - 1 and every element equal to nums[i] + 1.
 * Return the maximum number of points you can earn by applying the above operation some number of times.
 * */

public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for(int num : nums) {
            max = Math.max(max, num);
        }
        int[] arr = new int[max + 1];
        for (int i = 0 ; i <= nums.length ; i++) {
            arr[nums[i]] += nums[i];
        }
        int prev = arr[0];
        int curr = Math.max(arr[0], arr[1]);

        for (int i = 2 ; i < max ; i++) {
            int temp = curr;
            curr = Math.max(curr, arr[i] + prev);
            prev = temp;
        }
        return curr;
    }

    public int deleteAndEarnHM(int[] nums) {
        int max = 0;
        for(int num : nums) {
            max = Math.max(max, num);
        }
        int[] arr = new int[max + 1];
        for (int i = 0 ; i <= nums.length ; i++) {
            arr[nums[i]] += nums[i];
        }
        int prev = arr[0];
        int curr = Math.max(arr[0], arr[1]);

        for (int i = 2 ; i < max ; i++) {
            int temp = curr;
            curr = Math.max(curr, arr[i] + prev);
            prev = temp;
        }
        return curr;
    }
}
