class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        
        maxm = nums[0]
        
        for num in nums:
            maxm = max(maxm,num)
        
        arr = [0 for i in range(maxm+1)]
        
        for num in nums:
            arr[num]+=num
        
        prev = 0
        curr = arr[1]
        
        for i in range(2,len(arr)):
            temp = curr
            curr = max(curr,arr[i]+prev)
            prev = temp
            
        return curr