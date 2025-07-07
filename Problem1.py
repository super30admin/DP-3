
# Time Complexity:
# O(n + max(n))

# Space Complexity:
# O(max(n))

class Solution(object):
    def deleteAndEarn(self, nums):
       
        max_val = 0
        for num in nums:
            max_val = max(max_val, num)
        
        arr=[0] * (max_val + 1)
        for num in nums:
            arr[num] += num

        take,skip =arr[0],max(arr[0], arr[1])
        for i in range(2,max_val+1):
            tempSkip=skip
            skip=max(skip,arr[i]+take)
            take= tempSkip
        return skip
       
