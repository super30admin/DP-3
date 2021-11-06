class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i:nums)
            max = Math.max(i,max);
        int data[] = new int[max+1];

        for(int i:nums){
            data[i]+=i;
        }

        int runningMax1,runningMax2, currMax;
        runningMax1 = runningMax2 = 0;
        for(int i=0;i<=max;i++){
            currMax = runningMax2 + data[i];
            runningMax2 = Math.max(runningMax2, runningMax1);
            runningMax1 = currMax;
        }
        return Math.max(runningMax1, runningMax2);
    }
}