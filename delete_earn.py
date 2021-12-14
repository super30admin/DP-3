#time complexity: O(max(n, max_ele))
#space complexity: O(max(n, max_ele))

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if(nums==None or len(nums)==0): return 0
        maxi=max(nums)
        sum_arr=[0]*(maxi+1)
        
        for i in nums:
            sum_arr[i]=sum_arr[i]+i
        
        skip=0
        take=sum_arr[0]
        
        for i in range(len(sum_arr)):
            temp=skip
            skip=max(skip, take)
            take=temp+sum_arr[i]
            
        return max(skip, take)
        
        
        
        
        