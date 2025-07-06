class Solution {
    public int deleteAndEarn(int[] nums) {
        
    if(nums==null || nums.length==0)
    {
        return 0;
    }

int max = Integer.MIN_VALUE;

for(int i = 0;i<nums.length;i++)
{
    max=Math.max(max,nums[i]);
}

int[]arr=new int[max+1];

for(int i = 0 ;i < nums.length;i++)
{
    int index = nums[i];
    arr[index]+=index;
}

int take = 0;
int skip = 0;
for(int i = 1 ; i < arr.length ;i++)
{
    int tskip = skip ;
    skip=Math.max(skip,take);
    take = tskip+arr[i]; 
}
return Math.max(skip,take);
    }
}
