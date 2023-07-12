# Time Complexity: O(n + max_num)
# Space Complexity: O(max_num)
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        max_num = max(nums)  # Find the maximum number in the list (O(n))
        hmap_list = [0] * (max_num + 1)  # Create a list to store the counts (O(max_num))
        result = [0] * (max_num + 1)  # Create a list to store the maximum earn (O(max_num))

        for i in range(1, len(hmap_list)):  # Iterate through the list of counts (O(max_num))
            hmap_list[i] = i * nums.count(i)  # Calculate the count for each number (O(n))

        result[1] = hmap_list[1]  # Initialize the base case for the maximum earn

        for i in range(2, len(result)):  # Iterate through the list of maximum earn (O(max_num))
            result[i] = max(result[i - 1], hmap_list[i] + result[i - 2])  # Calculate the maximum earn for each number

        return result[-1]  # Return the maximum earn