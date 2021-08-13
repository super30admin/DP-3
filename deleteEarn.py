# Time Complexity: O(max(nums)) + O(n), creation of auxiliary array 
# Space Complexity: O(max(nums)) if we use the skip, take variable approach

def deleteAndEarn(self, nums: list[int]) -> int:
    # Finding Max is O(n) and creation of the empty array is O(max(nums))
    m = max(nums)
    new_arr = [0 for _ in range(m+1)]
    # Augment the input nums to create a new array:
    # [0,0,4,9,4,0,6]
    #  0,1,2,3,4,5,6 <- store sum into index
    for idx, num in enumerate(nums):
        new_arr[num] += nums[idx]
    # Exactly the same as the house robber problem.
    dp = [0,0]
    for i in range(len(new_arr)-1,-1,-1):
        dp.insert(0,max(dp[0],new_arr[i] + dp[1]))