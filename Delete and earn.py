'''
Time Complexity: O(N) + O(max(N)), where N is the length of list nums
Space Complexity: O(max(N)), where N is the length of list nums
Successfully executed: Yes
Challenges faced: No
'''



#CODE
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if nums == [] or len(nums) == 0:
            return 0
        
        maxx = 0
        for i in range(len(nums)):
            maxx = max(maxx, nums[i])
            
        arr = [0] * (maxx+1)
        for i in range(len(nums)):
            arr[nums[i]] += nums[i]
        
        print(arr)
        
        ch = arr[0]
        nc = max(arr[0],arr[1])
        
        for i in range(2,len(arr)):
            temp = ch
            ch = max(ch,nc)
            nc = arr[i] + temp
        
        return max(ch,nc)