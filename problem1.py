# Time Complexity : O(input size + max element in input)
# Space Complexity : O(max element in input)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        maxele = float("-inf")
        for num in nums:
            if num > maxele:
                maxele = num
        arr = [0 for i in range(maxele+1)]
        for num in nums:
            arr[num] += num
        dparr = [0 for i in range(maxele+1)]
        
        for i in range(maxele+1):
            select = arr[i] + (dparr[i-2] if i-2 >=0 else 0)
            notselect = dparr[i-1] if i-1 >= 0 else 0
            dparr[i] = max(select,notselect)
        return dparr[maxele]