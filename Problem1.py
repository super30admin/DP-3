#Time Complexity - O(n)
#Space Complexity - O(n)

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        maxElement = max(nums)
        
        arr = [0] * (maxElement + 1)
        
        for x in nums:
            arr[x] += x

        for x in range(len(arr)):
            if x - 1 < 0 or x - 2 < 0:
                arr[x] = arr[x] if x - 1 < 0 else max(arr[x], arr[x - 1])
                continue
            arr[x] = max(arr[x - 1], arr[x] + arr[x - 2])
        
        return arr[maxElement]