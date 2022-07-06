class Solution {
    public int deleteAndEarn(int[] nums) {
        
        int[] tmp = new int[getMax(nums)+1];   

        for(int el : nums){
            tmp[el]+=el;
        }
        
        int temp;
        int prev = 0, prev2prev=0;
        for(int i=1; i<tmp.length;i++){
            temp = prev;
            prev = Math.max(prev2prev+tmp[i],prev);
            prev2prev = temp;
        }
        return prev;

    }

    public int getMax(int[] arr){
        int res = 0;
        for(int el : arr){
            if(res < el){
                res = el;
            }
        }
        return res;
    }
}