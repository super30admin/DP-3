/*
// Time Complexity : O(n + count) where n is the size of the array and count is biggest element in the array.
// Space Complexity : O(max element in arrray) as we are creating extra array as a size of max element.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
*/

public class DeleteandEarn {

    public int deleteAndEarn(int[] nums) {
        // getting the maximum element fro the array.
        int count = 0;
        for (int i : nums) {

            if (count < i) {

                count = i;
            }

        }

        // creating another array with count +1 beacause array index starts with the 0.
        int index[] = new int[count + 1];

        for (int i = 0; i < nums.length; i++) {

            // adding the value of element at there index.
            index[nums[i]] = index[nums[i]] + nums[i];
        }

        // now probleme turn in to house robber problem.

        // checking if last or second last and current eleement what is bigger storing
        // that value.
        for (int i = 2; i < index.length; i++) {

            index[i] = Math.max(index[i - 1], (index[i] + index[i - 2]));

        }
        // rerturning the last element in the array.
        return index[index.length - 1];

    }
}
