class DeleteAndEarn{
    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int cur = 0;
        int prev = 0;
        int prev2 = 0;
        int startIndex = 0;

        while(i < nums.length){
            cur = nums[i];
            startIndex = i - 1;
            while(i < nums.length - 1 && nums[i] == nums[i+1]) cur += nums[i++];

            if(startIndex >= 0 && nums[i] > nums[startIndex] + 1) cur += prev;
            else cur = Math.max(cur + prev2, prev);

            prev2 = prev;
            prev = cur;
            i++;
        }
        return cur;
    }
    //Time Complexity : O(nlogn)
    //Space : o(1)
}