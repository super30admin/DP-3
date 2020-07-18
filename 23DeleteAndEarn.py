"""
// Time Complexity :O(n) where n is numbers in an array
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this :NA

//Explanation:
Calculate the maximum from the nums.
Preprocessing->
create array of maximum size and place the number at correct indices
i.e place 2 at 2nd index, incase of duplicates, add to the existing value
place 3 at 3rd index..
Further solution is similar to house robber problem. 
"""
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if nums is None or len(nums)==0:
            return 0
        mx = 0
        skip , take = 0,0
        for num in nums:
            mx = max(num,mx)
        array = [0] * (mx+1)

        for num in nums:
            array[num] = array[num] + num

        for i in range(len(array)):
            temp = skip
            skip = max(skip, take)
            take = temp + array[i]
        return max(skip,take)

if __name__=="__main__":
  input=[3,4,2]
  s=Solution()
  print(s.deleteAndEarn(input))
