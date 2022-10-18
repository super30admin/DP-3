class Solution {
    public int deleteAndEarn(int[] nums) {
        int m = m(nums);
        int[] points = new int[m+1];
        for(int num : nums){
            points[num]+=num;}
        for (int i=1; i<=m; ++i){
             points[i]= Math.max(
             points[i] + (i-2<0?0:points[i-2]),points[i-1]);}
        return points[m];
        }
    private int m(int[] a){
        int m = 0;
        for(int num : a){
            m = Math.max(m, num);
        }
        return m;
    }
    }
//tc=O(n);
//sc=O(n)
