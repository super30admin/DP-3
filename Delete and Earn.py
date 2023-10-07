#LC: 740, yes
#problem: NA
#TC: O(n) , n is len of nums
#TC: O(max(n)), n is len of nums
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        # null scene
        if nums is None or len(nums) == 0: return 0
        maxi = 0
        
        for num in nums:
            maxi = max(maxi, num)
            
        arr = [0]*(maxi+1)
        
        for num in nums:
            arr[num] += num
            
        # rob the houses
        prev = arr[0]
        curr = max(arr[0], arr[1])
        
        for i in range(2, len(arr)):
            temp = curr
            curr = max(curr, prev+arr[i])
            prev = temp
        
        return curr
        
        