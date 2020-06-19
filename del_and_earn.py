class Solution:
	def deleteAndEarn(self, nums: List[int]) -> int:
		if not nums:
			return 0
		array = [0 for _ in range(max(nums)+1)]
		for value in nums:
			array[value] += value
		skip, take = 0,0
		for value in array:
			temp = skip
			skip = max(skip, take)
			take = value+temp
		return max(skip, take)

#time complexity - O(n)
#space complexity - O(n) as we use the extra array

#all test cases passed