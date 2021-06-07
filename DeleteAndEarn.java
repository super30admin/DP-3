

// Time Complexity : O(n)
// Space Complexity :  O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this - 

public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        if(nums == null) return 0;
        int max = 0;
        for (int num : nums){
            max = Math.max(max,num);
        }
        int [] arr = new int[max+1];
        for(int num : nums) {
            arr[num] += num;
        }
        int skip = 0; int take = arr[0];
        for (int i = 0; i< arr.length; i++){
            int temp = skip;
            skip = Math.max(skip, take);
            take = temp + arr[i];
        }
        return Math.max(skip,take);
    }
}
