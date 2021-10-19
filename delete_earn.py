#Time Complexity : O(n + max(numbers))
#Space Complexity : O(max(numbers)) 
# Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No



class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        maxv = -1
        for i in nums:
            maxv = max(maxv, i)
        
        li = [0]*(maxv+1)
        for i in nums:
            li[i] += i
        skip = take = temp = 0    
        for i in range(1, len(li)):
            temp = skip
            skip = max(skip, take)
            take = li[i] + temp
        return max(skip, take)