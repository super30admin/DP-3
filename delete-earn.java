//TC: O(N)
//SC: O(M)
class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int num:nums) {
            if(max<num)
                max = num;
        }
        
        int[] arr = new int[max+1];
        for(int num:nums) {
            arr[num] += num;
        }
        
        int skip = 0, choose = arr[0];
        
        for(int i=0; i<arr.length; i++) {
            int prevSkip = skip;
            skip = Math.max(skip, choose);
            choose = prevSkip - arr[i];
        }
        
;       return Math.max(skip, choose);
    }
}