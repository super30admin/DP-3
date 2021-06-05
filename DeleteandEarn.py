class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        maxnum = 0
        for i in nums:
            maxnum = max(i, maxnum)
        arr = [0 for _ in range(0,maxnum+1)]
        for i in nums:
            arr[i]+=i
        skip = 0
        take = arr[0]
        for i in range(len(arr)):
            prevskip = skip
            skip = max(skip, take)
            take = prevskip+arr[i]
        return max(skip, take)
    
#  This implementation takes max(O(max(nums)), O(n)) time complexity.
#  space Complexity - O(max(nums))
            