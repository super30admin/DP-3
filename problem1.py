#Time Complexity = O(n)
#Space Complexity = O(n)

def deleteAndEarn(self, nums: List[int]) -> int:
        skip = 0
        take = 0 
        arr = [0 for i in range(max(nums)+1)]
        for i in nums:
            arr[i]+=i
        for i in arr:
            temp = skip
            skip = max(skip,take)
            take = temp+i
        return max(skip,take)