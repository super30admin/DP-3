class Solution {
    public int deleteAndEarn(int[] nums) {
        //Tc: O(n) + O(max(n))
        //Sc: O(max)
        int max = 0;
        for(int num: nums)
        {
            max = Math.max(max, num);
        }
        
        int[] arr = new int[max+1];
        for(int num:nums)
        {
            arr[num] += num;
        }

        int prev = arr[0];
        int curr = Math.max(arr[0], arr[1]);
        for(int i = 2; i < arr.length; i++)
        {
            int temp = curr;
            curr = Math.max(prev+arr[i],curr);
            prev = temp;
        }
        return curr;
    }
}