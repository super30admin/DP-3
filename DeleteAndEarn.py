# Time Complexity : O(n) where n is the number of elements
# Space Complexity : O(n) where n is the number of elements
# Did this code successfully run on LeetCode : yes
# Any problem you faced while coding this : No


# Since we miss some values in the array and because of that we have some expensive operations,
# we will create new array with size of input array's max element.
# Now we will add values to the newly created array based on the input array element count
# We will create a dp matrix to keep track of previous element based on the decision to choose or not to choose
# Get max of the last row represents our maximum earn by deleting
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:

        if len(nums) == 0 or nums is None:
            return 0

        maxElement = max(nums)

        NewArray = [0] * (maxElement + 1)

        for num in nums:
            NewArray[num] += num

        dpMatrix = [[0, 0] for i in range(maxElement + 1)]

        for i in range(1, maxElement + 1):
            dpMatrix[i][0] = max(dpMatrix[i - 1][:])

            dpMatrix[i][1] = NewArray[i] + dpMatrix[i - 1][0]

        return max(dpMatrix[-1])
