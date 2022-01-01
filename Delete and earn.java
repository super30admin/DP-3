//Time complexity: O(n)
//Space complexity: O(n)

class Solution {
    public int deleteAndEarn(int[] nums) {
        HashMap<Integer,Integer>map=new HashMap<Integer,Integer>();
        int n=nums.length;
        if(n==1)
            return nums[0];
        for(int i=0;i<n;i++)
        {
            if(!map.containsKey(nums[i]))
                map.put(nums[i],1);
            else
            {
                int x= map.get(nums[i]);
                x++;
                map.put(nums[i],x);
            }
            
        }
        
        int a[]=new int[map.size()]; int k=0;
         for (int i : map.keySet())
         {
             a[k]=i;
             k++;
         }
        Arrays.sort(a);
        int dp[]=new int[a.length];
        dp[0]=a[0]*map.get(a[0]);
        if(a[1]==a[0]+1)
            dp[1]= Math.max(dp[0],a[1]*map.get(a[1]));
        else
            dp[1]= dp[0]+a[1]*map.get(a[1]);
        for(int i=2;i<dp.length;i++)
        {
            if(a[i]!= a[i-1]+1)
            {
                dp[i]= dp[i-1]+a[i]*map.get(a[i]);
                }
            
            else
            {
                dp[i]=Math.max((a[i]*map.get(a[i])+dp[i-2]), dp[i-1]);
            }
        }
        return dp[dp.length-1];
        
        
    }
}