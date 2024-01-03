//Accepted on LT
//So made a array and used indexs as refrence to number and transformed it into house robber problem and than got the max profit
//Time should be O(m) where m is the size of nums

class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = Integer.MIN_VALUE;

        for(int num: nums){
            max = Math.max(num,max);
        }
        int[] a = new int[max+1];
        for(int i=0;i<nums.length;i++){
            a[nums[i]] = a[nums[i]] + nums[i];
        }
        int n = a.length;
        if (n == 1) {
            return a[0];
        }

        a[1] = Math.max(a[0], a[1]);
        max = a[1];
   
        for(int j=2;j<n;j++){
            a[j] = Math.max(a[j-1],a[j-2]+a[j]);
            max = Math.max(max,a[j]);

        }
        return max;
        
    }
}