#740. Delete and Earn
"""
Time Complexity : O(max(nums) + len(arr))
Space Compelxity : O(max(nums)) #arr space
"""
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        n = max(nums)
        arr = [0] * (n + 1)
        
        for i in nums:
            arr[i] = arr[i] + i
            
        print(arr)
        
        prev = arr[0]
        curr = max(arr[0], arr[1])
        
        for i in arr[2::]:
            #print("i = ", i)
            temp = curr
            curr = max(prev + i, curr)
            prev = temp
            
        return curr
