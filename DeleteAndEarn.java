class Solution {
    public int deleteAndEarn(int[] nums) {
        //TC - O(max(n , m)), where n is length of nums array, and m is the length of arr, which ever is greater
        //SC - O(m), where m is the max element in the nums array
        
        //iterate the nums array to find the maximum number in the array
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }

        //create an array of length equal to max so that we can store the total value of each number at their respective index
        int[] arr = new int[max + 1];
        for (int num : nums) {
            arr[num] += num;
        } 

        // iterate over this array and at each step calculate the max points between picking the cuu element or summing up prev and element at current index
        int prev = arr[0];
        int curr = Math.max(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            int temp = curr;
            curr = Math.max(curr, arr[i] + prev);
            prev = temp;
        }
        return curr;
    }
}