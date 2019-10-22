class Solution {
    public int deleteAndEarn(int[] nums) {
        
        int[] values = new int[10001];
        int skip =0 , take =0;
        for(int num: nums) values[num] += num;
    
    for(int i=0; i<10001; i++){
        int curr_skip = Math.max(skip,take);
        int curr_take = skip+ values[i];
        skip = curr_skip;
        take = curr_take;
    }
    return Math.max(skip, take);
    
    
    }
}