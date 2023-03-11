// Time Complexity: O(n*m) m is the max(nums)
// Space Complexity: O(m) m is the max(nums)

class Solution {
    public int deleteAndEarn(int[] nums) {
        int []arr = new int[Arrays.stream(nums).max().getAsInt()+1];
        // ArrayList<Integer> arr = new ArrayList();
        // System.out.println(Arrays.stream(nums).max().getAsInt());
        // int sum = 0;
        for (int i=0;i < nums.length; i++){
            // sum += nums[i];
            // System.out.println(sum);
            arr[nums[i]] += nums[i];
        }
        arr[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++){
            arr[i] = Math.max(arr[i-1], (arr[i]+ arr[i-2]));
        }

        // System.out.println(Arrays.toString(arr));
        return arr[arr.length-1];
    }
}