// Time Complexity : O(n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

public int deleteAndEarn(int[] nums) {
    if(nums == null || nums.length ==0 ) return 0;
    
    int max = 0;
    for(int i : nums) max = Math.max(max, i);
    
    int[] val = new int[max+1];
    
    for(int i : nums) val[i]+=i;
    
    int a = 0, b=val[1];
    for(int i=2; i<val.length; i++){
        int temp = Math.max(b,a + val[i]);
        a=b;
        b=temp;
    }
    return b;
}