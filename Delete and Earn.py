# Time Complexity : O(len(coins) * amount)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : 
# Any problem you faced while coding this : Yes, intution to change into house robber is difficult


# Your code here along with comments explaining your approach
# TC - O(n) + O(greater) 
# SC - O(n)

def deleteAndEarn( nums) -> int:
    if nums == None or len(nums) == 0:
        return 0
    greater = nums[0]
    for num in nums:
        greater = max(greater,num)
    arr = [0]*(greater+1)
    for num in nums:
        arr[num] += num
    prev = 0
    curr = arr[1]
    for i in range(2,len(arr)):
        temp = curr
        curr = max(curr,prev + arr[i])
        prev = temp
    return curr

nums = [3,4,2]
print(deleteAndEarn(nums))
        