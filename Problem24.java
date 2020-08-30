//Time Complexity: O(n)
//Space Complexity: O(n)
//Did it run on leetcode: Yes
//Problems faced any: No

public class Problem24 {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;

        int max = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            if(nums[i]>max)
                max = nums[i];
        }

        int[] arr = new int[max+1];

        for(int i=0; i<nums.length; i++){
            int x = nums[i];
            arr[x] += x;
        }

        int c = 0;
        int dc = 0;
        for(int i : arr){
            int temp = dc;
            dc = Math.max(c,dc);
            c = i+temp;
        }

        return Math.max(c,dc);
    }
}
