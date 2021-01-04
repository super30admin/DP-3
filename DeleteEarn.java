class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] res = new int[10001];
        int[] weights = new int[10001];
        int[] values = new int[10001];
        for(int i=0;i<nums.length;i++){
            weights[nums[i]]++;
            values[nums[i]] = weights[nums[i]]*nums[i];
        }
        
        int max = 0;
        res[1] = values[1];
        max = res[1];
        for(int i=2;i<weights.length;i++){
            if(weights[i]!=0){
                if(res[i-1]!=0){
                    res[i] = Math.max(res[i-1], res[i-2]+values[i]);
                    max = res[i];
                }
                else{
                    res[i] = res[i-2] + values[i];
                    max = res[i];
                }
            }
            else{
                res[i] = max;
            }
            
        }
        return max;
    }
}

//Time complexity : O(N) where N is the length of nums array
//space complexity : O(n) here n is constant which is 10001
