//Time Complexity: O(N)
//Space Complexity: O(N)
//Runtime: 3 ms, faster than 51.89% of Java online submissions for Delete and Earn.
//Memory Usage: 40.6 MB, less than 12.79% of Java online submissions for Delete and Earn.

class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums == null) return 0;
        
        int max = 0;
        
        
        for(int num : nums){
            max = Math.max(num, max);
        }
        
        int[] arr = new int[max+1];
        
        for(int num : nums){
           arr[num] += num;
        }
        
        int skip = 0;
        int take = arr[0];
        
        for(int i = 0; i < arr.length; i++){
            int temp = skip;
            skip = Math.max(skip, take);
            take = temp + arr[i];
        }
        
        return Math.max(skip, take);
    }
}
