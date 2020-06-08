from collections import defaultdict
class Solution:
    def deleteAndEarn(self, nums):
        if len(nums)==0:
            return 0
        length=max(nums)+1
        arr=[0]*length
        temp=defaultdict(list)
        for i in nums:
            temp[i]=temp.get(i,0)+i
        for k,v in temp.items():
            arr[k]=v
        
        dp=[[0 for y in range(2)] for x in range(len(arr))]
        dp[0][1]=arr[0]
        
        for i in range(1,len(dp)):
            dp[i][0]=max(dp[i-1][0],dp[i-1][1])
            dp[i][1]=arr[i]+dp[i-1][0]
        
        return max(dp[-1][0],dp[-1][1])
        
 Time complexity is O(n)
 Space complexity is O(2n)~O(n)
